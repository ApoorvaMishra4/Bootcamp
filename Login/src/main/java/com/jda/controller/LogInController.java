package com.jda.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jda.dao.DatabaseUtil;
import com.jda.model.UserModel;

public class LogInController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel user = DatabaseUtil.fetchData(request.getParameter("email"), request.getParameter("password"));
		if(user == null){
			
		}
		else
		{
			
		}
	}
}
