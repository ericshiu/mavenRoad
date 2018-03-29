/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年3月17日 下午11:30:27
 * Copyright (c) 2017.炬火數位有限公司版權所有. 
 * 注意：本內容僅限於炬火數位內部傳閱，禁止外洩以及用於其他商業目的
 ******************************************************************************/
/**
 * <P>TODO</P>
 * @version $Id$
 * @user Eric修義  2018年3月17日 下午11:30:27
 */
package com.fileupload.c;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/updataimg")
@MultipartConfig(maxFileSize = 16177215)
public class FileUploadDBServlet extends HttpServlet {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		InputStream inputStream = null;
		Part filePart = request.getPart("photo");
		if (filePart != null) {
			inputStream = filePart.getInputStream();
		}

		Connection conn = null; // connection to the database
		String message = null; // message will be sent back to client
		try {
			conn = getConnection();
			String sql = "INSERT INTO img (first_name, last_name, photo) values (?, ?, ?)";
			PreparedStatement pstmtSave = conn.prepareStatement(sql);
			pstmtSave.setString(1, firstName);
			pstmtSave.setString(2, lastName);

			if (inputStream != null) {
				pstmtSave.setBlob(3, inputStream);
			}
			int row = pstmtSave.executeUpdate();
			if (row > 0) {
				message = "File uploaded and saved into database";
			}
			response.getOutputStream().print("http://localhost:8081/maven02-imgToDB/view?pk=" + firstName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}