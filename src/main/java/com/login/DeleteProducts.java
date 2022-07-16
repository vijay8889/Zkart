package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteProducts extends HttpServlet {
    Connection conn;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    
        String name = request.getParameter("name");
        
       
        try {
            String url="jdbc:postgresql://localhost:5432/postgres";
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            conn = DriverManager.getConnection(url, "postgres", "postgres");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from products");
            boolean nameExists = false;
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            while(rs.next()) {
                if(name.equals(rs.getString("name"))) {
                    nameExists = true;
                    String query = "delete from products where name = '"+name+"'";
                    System.out.println("hello");
                    PreparedStatement pStatement = conn.prepareStatement(query);
                    pStatement.execute();
                    pStatement.clearParameters();
                    request.setAttribute("valid", "Product Deleted ");
        			RequestDispatcher rds = request.getRequestDispatcher("Addproducts.jsp");
        			rds.forward(request, response);
                    break;
                }
            }
            
           
			 request.setAttribute("invalid", "No such  Product available here");
 			RequestDispatcher rd = request.getRequestDispatcher("Addproducts.jsp");
 			rd.forward(request, response);
            
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            try {
                conn.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }   
}
