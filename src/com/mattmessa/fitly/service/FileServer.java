package com.mattmessa.fitly.service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

@Component("FileServer")
public class FileServer implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String path = "";
		try {
			path = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String delims = "[/]";
		String[] tokens = path.split(delims);

		String rootPath = System.getProperty("catalina.home");
		String fullPath = rootPath + File.separator + "uploads" + File.separator + tokens[0];
		File file = new File(fullPath, tokens[1]);
		response.setHeader("Content-Type", "image/jpeg");
		response.setHeader("Content-Length", String.valueOf(file.length()));
		response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
		try {
			Files.copy(file.toPath(), response.getOutputStream());
		} catch (IOException e) {
			System.out.printf("Error in FileServer %s\n", e.toString());
			String catHome = System.getProperty("catalina.home");
			File dir = new File(catHome + File.separator + "uploads");
			File theFile = new File(dir, "blank_pic.jpg");
			response.setHeader("Content-Type", "image/jpeg");
			response.setHeader("Content-Length", String.valueOf(theFile.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"" + theFile.getName() + "\"");
			try {
				Files.copy(theFile.toPath(), response.getOutputStream());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}