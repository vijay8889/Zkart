package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddToWishlist extends HttpServlet {
    Connection conn;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int productid = Integer.parseInt(request.getParameter("details"));
        String email = Cookiecls.email;
        //System.out.println(u_name);
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
            Statement st1 = conn.createStatement();
            String q="select * from products where product_id="+productid+"";
            ResultSet rs1= st.executeQuery("Select * from wishlist where p_id = "+productid+" and email='"+email+"'");
            ResultSet rs=st1.executeQuery(q);
            if(rs.next()&& !rs1.next()) {
            	if(rs.getInt("availability")==0  ) {
		            String query = "insert into wishlist(p_id, email) values(?, ?)";
		            
		            PreparedStatement pStatement = conn.prepareStatement(query);
		            pStatement.setInt(1, productid);
		            pStatement.setString(2, email);
		            
		            pStatement.execute();
		            pStatement.clearParameters();
		            HttpSession session = request.getSession();
		            session.setAttribute("invalid", "Product Added to Wishlist Successfully ");
					response.sendRedirect("home.jsp");
            	}
            	else {
            		HttpSession session = request.getSession();
		            session.setAttribute("invalid", "This product is Available  ");
					response.sendRedirect("home.jsp");
            	}
            		
            
            }
            else {
            	HttpSession session = request.getSession();
	            session.setAttribute("invalid", "This product is  Already in Wishlist");
				response.sendRedirect("home.jsp");
            }
            
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