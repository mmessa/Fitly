package com.mattmessa.fitly.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.mattmessa.fitly.dao.BodyFat;
import com.mattmessa.fitly.dao.Goal;
import com.mattmessa.fitly.dao.Performance;
import com.mattmessa.fitly.dao.Profile;
import com.mattmessa.fitly.dao.Supplement;
import com.mattmessa.fitly.dao.Update;
import com.mattmessa.fitly.dao.User;
import com.mattmessa.fitly.dao.Weight;
import com.mattmessa.fitly.service.BodyFatService;
import com.mattmessa.fitly.service.GoalService;
import com.mattmessa.fitly.service.PerformanceService;
import com.mattmessa.fitly.service.ProfileService;
import com.mattmessa.fitly.service.SupplementService;
import com.mattmessa.fitly.service.UpdateService;
import com.mattmessa.fitly.service.UserService;
import com.mattmessa.fitly.service.WeightService;

@Controller
public class ProfileController {

	private ProfileService profilesService;
	private UserService usersService;
	private WeightService weightsService;
	private SupplementService supplementsService;
	private GoalService goalsService;
	private BodyFatService bodyFatsService;
	private UpdateService updatesService;
	private PerformanceService performancesService;

	@Autowired
	public void setPerformancesService(PerformanceService performancesService) {
		this.performancesService = performancesService;
	}

	@Autowired
	public void setBodyFatsService(BodyFatService bodyFatsService) {
		this.bodyFatsService = bodyFatsService;
	}

	@Autowired
	public void setUpdatesService(UpdateService updatesService) {
		this.updatesService = updatesService;
	}

	@Autowired
	public void setGoalsService(GoalService goalsService) {
		this.goalsService = goalsService;
	}

	@Autowired
	public void setSupplementsService(SupplementService supplementsService) {
		this.supplementsService = supplementsService;
	}

	@Autowired
	public void setWeightsService(WeightService weightsService) {
		this.weightsService = weightsService;
	}

	@Autowired
	public void setProfilesService(ProfileService profilesService) {
		this.profilesService = profilesService;
	}

	@Autowired
	public void setUsersService(UserService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/profile")
	public String showProfile(Model model, HttpServletRequest request) {
		int userId = (int) request.getSession().getAttribute("userId");
		Profile profile = profilesService.getProfile(userId);

		List<Weight> weights = weightsService.getWeights(userId);
		List<Update> updates = updatesService.getUpdates(userId);
		List<Goal> goals = goalsService.getGoals(userId);
		List<BodyFat> bodyFats = bodyFatsService.getBodyFats(userId);
		List<Supplement> supplements = supplementsService.getSupplements(userId);
		List<Performance> performances = performancesService.getPerformances(userId);

		model.addAttribute("profile", profile);
		model.addAttribute("updates", updates);
		model.addAttribute("goals", goals);
		model.addAttribute("bodyFats", bodyFats);
		model.addAttribute("weights", weights);
		model.addAttribute("supplements", supplements);
		model.addAttribute("performances", performances);

		return "profile";
	}

	/*
	 * @RequestMapping("/profiles") public String showProfiles(Model model) {
	 * 
	 * List<Profile> profiles = profilesService.getProfiles();
	 * 
	 * model.addAttribute("profiles", profiles);
	 * 
	 * return "profiles"; }
	 */

	@RequestMapping("/createprofile")
	public String createProfile(Model model) {

		model.addAttribute("profile", new Profile());

		return "createprofile";
	}

	@RequestMapping("/editprofile")
	public String showEditProfile(Model model, HttpServletRequest request) {

		int userId = (int) request.getSession().getAttribute("userId");
		Profile profile = profilesService.getProfile(userId);
		System.out.printf("userId =  %d\n", profile.getUserId());
		model.addAttribute("profile", profile);

		return "editprofile";
	}

	@RequestMapping(value = "/updateprofile", method = RequestMethod.POST)
	public String updateProfile(@Valid Profile profile, BindingResult result, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		int userId = (int) request.getSession().getAttribute("userId");
		Profile preUpdatedProfile = profilesService.getProfile(userId);

		int level = preUpdatedProfile.getLevel();
		int xp = preUpdatedProfile.getExperiencePoints();
		int coins = preUpdatedProfile.getCoins();

		profile.setLevel(level);
		profile.setExperiencePoints(xp);
		profile.setCoins(coins);

		profilesService.updateProfile(profile);

		response.sendRedirect("profile");

		return "profile";
	}

	@RequestMapping("/newaccount")
	public String showNewAccount(Model model) {

		model.addAttribute("user", new User());
		// model.addAttribute("profile", new Profile());

		return "newaccount";
	}

	@RequestMapping(value = "/createaccount", method = RequestMethod.POST)
	public String createAccount(@Valid User user, BindingResult result) {

		if (result.hasErrors()) {
			return "newaccount";
		}

		user.setAuthority("user");
		user.setEnabled(true);

		if (usersService.exists(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username");
			return "newaccount";
		}

		try {
			usersService.create(user);
		} catch (DuplicateKeyException ex) {

			result.rejectValue("username", "DuplicateKey.user.username");
			return "newaccount";
		}

		Profile profile = new Profile();

		user = usersService.getUser(user.getUsername());

		int userId = user.getUserId();

		profile.setUserId(userId);

		profilesService.create(profile);

		return "login";
	}

	@RequestMapping("/uploader")
	String uploadFileHandler(HttpServletRequest request, MultipartFile file) {

		int userId = (int) request.getSession().getAttribute("userId");

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				// Creating the directory to store file if it does not exist
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "uploads" + File.separator + userId);
				if (!dir.exists())
					dir.mkdirs();
				// will store the pic in uploads/userid/profile.jpg
				File serverFile = new File(dir.getAbsolutePath() + File.separator + "profile.jpg");

				// Create the file on server
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				return "redirect:editprofile";
			} catch (Exception e) {
				System.out.printf("You failed to upload => %s\n", e.getMessage());
				return "redirect:editprofile";
			}
		} else {
			System.out.printf("You failed to upload because the file was empty.\n");
			return "redirect:editprofile";
		}
	}
}
