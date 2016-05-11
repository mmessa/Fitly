<%@ include file="shared/header.jspf"%>
<%@ include file="shared/navigation.jspf"%>

<h3 id="myProfile">My Profile</h3>
<div class="profileHeader">
	<div class="row">
		<div class="col-sm-3 col-md-3 col-lg-2">
			<img src="<c:url value='/uploads/${profile.userId}/profile.jpg'/>"
				alt="pic" class="profilePicture">
		</div>
		<div class="profileElements col-sm-6 col-md-7 col-lg-8">
			<h2 class="name">
				<c:out value='${profile.firstName}' />
				<c:out value='${profile.lastName}' />
			</h2>
			<div class="levelXp">
				<h4>
					Level:
					<c:out value='${profile.level}' />
				</h4>
				<div class="xp">
					<h4>
						Experience:
						<c:out value='${profile.experiencePoints}' />
					</h4>
				</div>
			</div>
		</div>
		<div class="col-sm-3 col-md-2 col-lg-2">
			<img src="<c:url value='/static/images/static/shiny-coin2.png'/>"
				alt="pic" height="45px" width="45px"> <span class="coins"><c:out
					value='${profile.coins}' /></span>
			<div class="nextLevel">
				<h4>
					Next Level:
					<c:choose>
						<c:when test="${profile.level == 1}">
						3000
					</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${profile.level == 2}">
								7000
							</c:when>
								<c:otherwise>
								Max
							</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>

				</h4>
			</div>
		</div>
	</div>





</div>



<div class="container-fluid">
	<div class="profileContent">
		<div class="row">
			<div class="col-lg-6">
				<span class="profileTitle">Name:</span> <span class="profileField"><c:out
						value='${profile.firstName}' /> <c:out
						value='${profile.lastName}' /></span> <br> <span
					class="profileTitle">Height:</span> <span class="profileField"><c:out
						value='${profile.heightFeet}' />" <c:out
						value='${profile.heightInches}' />'</span> <br> <span
					class="profileTitle">DOB:</span> <span class="profileField"><c:out
						value='${profile.DOB}' /></span> <br> <span class="profileTitle">Gender:</span>
				<span class="profileField"><c:out value='${profile.gender}' /></span>
			</div>
			<div class="col-lg-6">
				<span class="profileTitle">City:</span> <span class="profileField"><c:out
						value='${profile.city}' /></span> <br> <span class="profileTitle">State:</span>
				<span class="profileField"><c:out value='${profile.state}' /></span>
				<br> <span class="profileTitle">Zip Code:</span> <span
					class="profileField"><c:out value='${profile.zipCode}' />
					<br>
					<span class="profileTitle">Gym:</span> <span class="profileField"><c:out
							value='${profile.gym}' /></span>
			</div>

		</div>

		<br> <br> <a class="btn btn-info myButton"
			href="<c:url value='editprofile'/>">Edit Profile</a>
	</div>
	<div id="accordion">
		<h3>Weight History</h3>
		<div>

			<c:choose>
				<c:when test="${weights.size() == 0}">
					<div class="noneRecorded">No weights recorded</div>
				</c:when>
				<c:otherwise>
					<table class="table">
						<thead>
							<tr>
								<th>Weight</th>
								<th>Date</th>
								<th colspan="4"></th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="row" items="${weights}">

								<tr>
									<td>${row.weight}</td>
									<td>${row.createDate}</td>
									<td>
										<form action="createweight" method="post">
											<button type="submit" name="weightId" value="${row.weightId}"
												class="btn btn-secondary myEditButton">Edit</button>
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</form>
									</td>
									<td>
										<form action="deleteweight" method="post">
											<button type="submit" name="weightId" value="${row.weightId}"
												class="btn btn-danger myDeleteButton">Delete</button>
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</form>
									</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>



				</c:otherwise>

			</c:choose>
			<form action="createweight" method="post">
				<button type="submit" class="btn btn-info myButton">Add
					Weight</button>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
		</div>


		<h3>Updates</h3>
		<div>
			<c:choose>
				<c:when test="${updates.size() == 0}">
					<div class="noneRecorded">No updates recorded</div>
				</c:when>
				<c:otherwise>
					<table class="table">
						<thead>
							<tr>
								<th>Notes</th>
								<th>Date</th>
								<th colspan="4"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="row" items="${updates}">
								<tr>
									<td>${row.notes}</td>
									<td>${row.createDate}</td>
									<td>
										<form action="createupdate" method="post">
											<button type="submit" name="updateId" value="${row.updateId}"
												class="btn btn-secondary myEditButton">Edit</button>
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</form>
									</td>
									<td>
										<form action="deleteupdate" method="post">
											<button type="submit" name="updateId" value="${row.updateId}"
												class="btn btn-danger myButtonDanger">Delete</button>
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
			<form action="createupdate" method="post">
				<button type="submit" class="btn btn-info myButton">Add
					Update</button>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

		</div>
		<h3>Body Fat History</h3>
		<div>
			<c:choose>
				<c:when test="${bodyFats.size() == 0}">
					<div class="noneRecorded">No body fats recorded</div>
				</c:when>
				<c:otherwise>
					<table class="table">
						<thead>
							<tr>
								<th>Body Fat%</th>
								<th>Date</th>
								<th colspan="4"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="row" items="${bodyFats}">
								<tr>
									<td>${row.bodyFatPercentage}</td>
									<td>${row.createDate}</td>
									<td>
										<form action="createbodyfat" method="post">
											<button type="submit" name="bodyFatId"
												value="${row.bodyFatId}"
												class="btn btn-secondary myEditButton">Edit</button>
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</form>
									</td>
									<td>
										<form action="deletebodyfat" method="post">
											<button type="submit" name="bodyFatId"
												value="${row.bodyFatId}"
												class="btn btn-danger myDeleteButton">Delete</button>
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
			<form action="createbodyfat" method="post">
				<button type="submit" class="btn btn-info myButton">Add
					Body Fat%</button>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
		</div>
		<h3>Supplements</h3>
		<div>
			<c:choose>
				<c:when test="${supplements.size() == 0}">
					<div class="noneRecorded">No supplements recorded</div>
				</c:when>
				<c:otherwise>
					<table class="table">
						<thead>
							<tr>
								<th>Name</th>
								<th colspan="3"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="row" items="${supplements}">
								<tr>
									<td>${row.name}</td>
									<td>
										<form action="createsupplement" method="post">
											<button type="submit" name="supplementId"
												value="${row.supplementId}"
												class="btn btn-secondary myEditButton">Edit</button>
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</form>
									</td>
									<td>
										<form action="deletesupplement" method="post">
											<button type="submit" name="supplementId"
												value="${row.supplementId}"
												class="btn btn-danger myDeleteButton">Delete</button>
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
			<form action="createsupplement" method="post">
				<button type="submit" class="btn btn-info myButton">Add
					Supplement</button>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
		</div>
		<h3>Goals</h3>
		<div>
			<c:choose>
				<c:when test="${goals.size() == 0}">
					<div class="noneRecorded">No goals recorded</div>
				</c:when>
				<c:otherwise>
					<table class="table">
						<thead>
							<tr>
								<th>Goal</th>
								<th>Type</th>
								<th>Description</th>
								<th>Value</th>
								<th>Complete</th>
								<th colspan="7"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="row" items="${goals}">
								<tr>
									<td>${row.name}</td>
									<td>${row.type}</td>
									<td>${row.description}</td>
									<td>${row.value}</td>
									<td>${row.complete}</td>
									<td>
										<form action="creategoal" method="post">
											<button type="submit" name="goalId" value="${row.goalId}"
												class="btn btn-secondary myEditButton">Edit</button>
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</form>
									</td>
									<td>
										<form action="deletegoal" method="post">
											<button type="submit" name="goalId" value="${row.goalId}"
												class="btn btn-danger myDeleteButton">Delete</button>
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
			<form action="creategoal" method="post">
				<button type="submit" class="btn btn-info myButton">Add
					Goal</button>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
		</div>

		<h3>My Challenges</h3>
		<div>
			<c:choose>
				<c:when test="${performances.size() == 0}">
		No challenges started or completed
	</c:when>
				<c:otherwise>
					<table class="table">
						<thead>
							<tr>
								<th>Name</th>
								<th>Level</th>
								<th>Description</th>
								<th>Coins Given</th>
								<th>Experience Given</th>
								<th>Start Date</th>
								<th>Completed Date</th>
								<th>Completed</th>
								<th colspan="10"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="row" items="${performances}">
								<tr>
									<td>${row.name}</td>
									<td>${row.level}</td>
									<td>${row.description}</td>
									<td>${row.coinsGiven}</td>
									<td>${row.experienceGiven}</td>
									<td>${row.startedDate}</td>
									<c:choose>
										<c:when test="${row.complete == 1}">
											<td>${row.completedDate}</td>
											<td>Yes</td>
										</c:when>
										<c:otherwise>
											<td>--</td>
											<td>No</td>
											<td>
												<form action="docompleteperformance" method="post">
													<button type="submit" name="performanceId"
														value="${row.performanceId}"
														class="btn btn-secondary myEditButton">Complete</button>
													<input type="hidden" name="${_csrf.parameterName}"
														value="${_csrf.token}" />
												</form>
											</td>
										</c:otherwise>
									</c:choose>
									<td>
										<form action="deleteperformance" method="post">
											<button class="btn btn-danger myDeleteButton" type="submit"
												name="performanceId" value="${row.performanceId}">Delete</button>
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<a class="btn btn-info myButton"
						href="<c:url value='/challenges'/>">Go To Challenges</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
<%@ include file="shared/footer.jspf"%>