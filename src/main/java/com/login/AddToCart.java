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

public class AddToCart extends HttpServlet {
    Connection conn;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int productid = Integer.parseInt(request.getParameter("details"));
        
        String u_name = Cookiecls.name;
        String email=Cookiecls.email;
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
            String q="select * from products where product_id="+productid+"";
            String q1="select * from curr_cart where email=(select id from users where email='"+email+"')";
            ResultSet rs2=st.executeQuery(q1);
            if(rs2.next()==false) {
            	
            	String q2="insert into curr_cart(email) values('"+email+"')";
            }
            rs2=st.executeQuery(q1);
            int c_id=rs2.getInt("c_id");
            ResultSet rs=st.executeQuery(q);
            
            while(rs.next()) {
            	if(rs.getInt("availability")!=0) {
            String query = "insert into cart(c_id, email, p_id) values(?, ?, ?)";
            
            PreparedStatement pStatement = conn.prepareStatement(query);
            pStatement.setInt(1, c_id);
            pStatement.setString(2, email);
            pStatement.setInt(2, productid);
            
            pStatement.execute();
            pStatement.clearParameters();
            HttpSession session = request.getSession();
            session.setAttribute("invalid", "Product Added to Cart Successfully ");
			response.sendRedirect("home.jsp");
    	}
    	else {
    		HttpSession session = request.getSession();
            session.setAttribute("invalid", "This product is  Not Available  ");
			response.sendRedirect("home.jsp");
    	}
    		
    
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