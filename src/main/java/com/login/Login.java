package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.http.HttpSession;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		 String url="jdbc:postgresql://localhost:5432/postgres";
		 Connection conn = DriverManager.getConnection(url, "postgres", "postgres");

		 String email=request.getParameter("email");
		 String password=request.getParameter("password");
		 PrintWriter out = response.getWriter();
		 Statement st = conn.createStatement();

		 String query = "SELECT * FROM users"+" WHERE email='"+email+"' and password='"+password+"';";
		 ResultSet rs= st.executeQuery(query);
//		 cookie.ccls = rs.getString(0);
//		 Cookiecls.uname = "";
		 if(rs.next()) {
			 Cookiecls.name = rs.getString("username");
			 Cookiecls.email=rs.getString("email");
			 System.out.println(Cookiecls.name);
		 response.sendRedirect("home.jsp");
		 HttpSession session=(HttpSession) request.getSession();
		 session.setAtribute("usename",email);
		 }
		 else {
			 request.setAttribute("invalid", "Wrong Password or Email ");
				RequestDispatcher rd = request.getRequestDispatcher("log.jsp");
				rd.forward(request, response);
		 }
	    }
		catch(Exception e) {}
}}
