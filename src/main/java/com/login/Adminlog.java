package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.http.HttpSession;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Adminlog")
public class Adminlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession HttpSession;
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

		 String usrname=request.getParameter("usrname");
		 String password=request.getParameter("password");
		 PrintWriter out = response.getWriter();
		 Statement st = conn.createStatement();

		 String query = "SELECT * FROM admin"+" WHERE name='"+usrname+"' and password='"+password+"';";
		 ResultSet rs= st.executeQuery(query);
		 if(rs.next()) {
			 if(usrname.equals(rs.getString("name"))&& password.equals(rs.getString("password"))) {
				 HttpSession session= request.getSession();
				 session.setAttribute("username",usrname);
				 response.sendRedirect("Addproducts.jsp");
				
			 }
			 
		 
		 }
		 else {
			 request.setAttribute("invalid", "Only Admin can Login Here!! ");
				RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
				rd.forward(request, response);
		 }
	    }
		catch(Exception e) {}
}}

