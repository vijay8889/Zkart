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

public class Review extends HttpServlet {
    Connection conn;
    

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	 String review = request.getParameter("review");
         String rating = request.getParameter("rating");
         String p_id=request.getParameter("p_id");
        
//       System.out.println(p_id);
//       System.out.println(review);
//       System.out.println(rating);
        String email=Cookiecls.email;
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
            String query="insert into review(email,review,p_id) values('"+email+"','"+review+"',"+p_id+")";
            int rs=st.executeUpdate(query);
            String query1="select count(*) from products,purchase where products.product_id in (select p_id from cart where c_id=purchase.c_id) and products.product_id="+p_id+";";
            ResultSet rs1=st.executeQuery(query1);
            int count=0;
            while(rs1.next()) {
            	count=rs1.getInt(1);
            	
            }
            String query2="select rating from products where product_id="+p_id+"";
            ResultSet rs2=st.executeQuery(query2);
            int ratings=0;
            while(rs2.next()) {
            	ratings=rs2.getInt("rating");
            	
            }
            int newrating=(ratings*count+Integer.parseInt(rating))/(count+1);
            System.out.println(newrating);
            String query3="update products set rating="+newrating+"where product_id="+p_id+"";
            int rs3=st.executeUpdate(query3);
            
            HttpSession session = request.getSession();
            session.setAttribute("invalid", "Review submited successfully");
			response.sendRedirect("home.jsp");
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

