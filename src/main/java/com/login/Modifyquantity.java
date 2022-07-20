package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Modifyquantity")
public class Modifyquantity extends HttpServlet {
	 Connection conn;

	    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	String p_id=request.getParameter("details");
	    	String operation=request.getParameter("operation");
	    	String quantity=request.getParameter("quantity");
	    	System.out.println(operation);
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
            ResultSet rs = st.executeQuery("select email from users");
            int newquantity=0;
            if (operation.equals("-")) {
            	newquantity=Integer.parseInt(quantity)-1;
            }else {
            	newquantity=Integer.parseInt(quantity)+1;
            }
            String query1="update cart set quantity="+Integer.toString(newquantity)+"where p_id="+p_id+"";
        	int rs2=st.executeUpdate(query1);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
           
            
            response.sendRedirect("http://localhost:8081/Zkart/MyCart");
          
        } catch (SQLException e) {
			
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
