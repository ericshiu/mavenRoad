package com.fileupload.c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class FileReadDBServlet extends HttpServlet {
	private static final int BUFFER_SIZE = 4096;
	private String dbURL = "jdbc:mysql://119.28.25.204:3306/test";
	private String dbUser = "eric123";
	private String dbPass = "eric123";

	private Connection getConnection() {
		Connection conn = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
		} catch (Exception e) {
			throw new RuntimeException("Failed to obtain database connection.", e);
		}
		return conn;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			String pk = request.getParameter("pk");
			Connection conn = getConnection();
			String sql1 = "SELECT first_name,photo FROM img WHERE first_name=? ";
			PreparedStatement pstmtSelect = conn.prepareStatement(sql1);
			pstmtSelect.setString(1, pk);
			ResultSet result = pstmtSelect.executeQuery();
			if (result.next()) {
				response.setHeader("Content-Disposition", "fileName=\"" + result.getString("first_name") + "\"");
				response.setHeader("Content-Type", "JPG");
				response.setHeader("Connection", "close");
				response.getOutputStream().write(result.getBytes("photo"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
