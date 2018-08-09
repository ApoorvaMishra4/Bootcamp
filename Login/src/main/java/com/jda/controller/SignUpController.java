package com.jda.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String jdbcUrl = "jdbc:mysql://" + System.getenv("DBHOST") + ":3306/" + System.getenv("DBNAME") + "?user="+ System.getenv("DBUSER") +"&password="+System.getenv("DBPASSWORD");

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(jdbcUrl);
			PreparedStatement pst = connection.prepareStatement("insert into data (name, username, password, phoneNumber) values(?, ?, ?, ?)");
			pst.setString(1, request.getParameter("name"));
			pst.setString(2, request.getParameter("username"));
			pst.setString(3, request.getParameter("password"));
			pst.setString(4, request.getParameter("phoneNumber"));
			pst.executeUpdate();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(response.encodeRedirectUrl("Login.jsp"));
			requestDispatcher.forward(request, response);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
