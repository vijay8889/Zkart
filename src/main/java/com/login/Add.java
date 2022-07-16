package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Add extends HttpServlet {
    Connection conn;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	String imgurl = request.getParameter("imgurl");
    	String catogory = request.getParameter("catogory");
        String name = request.getParameter("name");
        String feature = request.getParameter("feature");
        String description = request.getParameter("description");
        String rating = request.getParameter("rating");
        String availability = request.getParameter("availability");
        String price = request.getParameter("price");
        String discount = request.getParameter("discount");
       
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
            ResultSet rs = st.executeQuery("select name from products");
            boolean nameExists = false;
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            while(rs.next()) {
                if(name.equals(rs.getString("name"))) {
                    nameExists = true;
                    request.setAttribute("invalid", "Existing Product ");
        			RequestDispatcher rd = request.getRequestDispatcher("Addproducts.jsp");
        			rd.forward(request, response);
                    break;
                }
            }
            
            String query = "insert into products(img_url,catogories,name,feature,decription,rating,availability,price,discounts) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            System.out.println("hello");
            PreparedStatement pStatement = conn.prepareStatement(query);
            pStatement.setString(1, imgurl);
            pStatement.setString(2, catogory);
            pStatement.setString(3, name);
            pStatement.setString(4, feature);
            pStatement.setString(5, description);
            pStatement.setInt(6, Integer.parseInt(rating));
            pStatement.setInt(7, Integer.parseInt(availability));
            pStatement.setInt(8, Integer.parseInt(price));
            pStatement.setInt(9, Integer.parseInt(discount));
            pStatement.execute();
            pStatement.clearParameters();
            request.setAttribute("valid", "Product Added ");
			RequestDispatcher rds = request.getRequestDispatcher("Addproducts.jsp");
			rds.forward(request, response);
            
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
