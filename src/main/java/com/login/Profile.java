package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Profile extends HttpServlet {
    Connection conn;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
  
        
        
        try {
            String url="jdbc:postgresql://localhost:5432/postgres";
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("hello");
            conn = DriverManager.getConnection(url, "postgres", "postgres");
            Statement st = conn.createStatement();
            String query = "select * from users";
            System.out.println(query);
            ResultSet rs = st.executeQuery(query);
            //boolean usrExists = false;
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
         
            out.println("<!DOCTYPE html>\r\n"
            		+ "<html lang=\"en\">\r\n"
            		+ "<head>\r\n"
            		+ "    <meta charset=\"UTF-8\">\r\n"
            		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
            		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
            		+ "    <title>Z-Kart</title>\r\n"
            		+ "    <link rel = \"stylesheet\"  href=\"style.css\" media = \"screen\" />\r\n"
            		+ "</head>\r\n"
            		+ "<body >\r\n"
            		+ "    <div class=\"header\">\r\n"
            		+ "    <div class=\"container\">\r\n"
            		+ "    <div class=\"navbar\">\r\n"
            		+ "        <div class=\"logo\">\r\n"
            		+ "            <img src=\"images/logo1.png\" width=\"125px\" height=\"70px\">\r\n"
            		+ "        </div>\r\n"
            		+ "        <nav>\r\n"
            		+ "            <ul id=\"MenuItems\">\r\n"
            		+ "                <li><a href=\"home.jsp\"></a></li>\r\n"
            		
            		+ "              <li><form action=\"Logout\" method=\"POST\">\r\n"
            		+ "                         <button class=\"btn\">Logout   \r\n"
            		+ "                   <!--  <img src=\"images/cart.png\" width=\"30px\" height=\"30px\">-->\r\n"
            		+ "                           </button>    \r\n"
            		+ "                       </form>\r\n"
            		+ "                </li>  "
            		+ "                \r\n"
            		+ "            </ul>\r\n"
            		+ "        </nav>\r\n"
            		+ "    </div>");
  while(rs.next()) {
	  String x="";
            	if(rs.getString("username").equals(Cookiecls.name)) {
            		if(rs.getString("username").equals("")) {
            			response.sendRedirect("log.jsp");
            		}
            		else {
            			 
            			  
            			    String y="";
            				String email1="Emailid:  ";
            	          	String us="Name:  ";
            	          	String ad="Address:  ";
            	          	String p="Phone Number:  ";
            	        	
            	        			x+="<div style='background-color:pink;border-radius:10px;width:400px;margin-left:500px; text-align:center';>";
            	               		 y+="<ul>";
            	               		 y+="<li><strong>"+us  +"</strong>" + rs.getString("username")+"</li><br>";
            	           		     y+="<li><strong>"+email1  +"</strong>" + rs.getString("email")+"</li><br>";
            	           		     y+="<li><strong>"+ad  +"</strong>" + rs.getString("address")+"</li><br>";
            	               		 y+="<li><strong>"+p  +"</strong>" + rs.getString("ph_no")+"</li><br>";
            	               		 y+="</ul>";
            	               		 y+="<button ><a href=\"edit.jsp\">Edit</a></button>";
            	           		
            	           		x+=y;
            	           		x+="</div>";
            	           		 
            	           		x+="<br/>";
            	           		//x+="<form ><input name='details' hidden type='text' value='"+rs.getString("username")+"' ><input type='submit' style='display:inline-block;margin-left:650px;font-size:20px;border-radius:10px;background-color:yellow;border-color:white;color:white;'value='Edit'/></form>";
            	           	          		}
            	                         		out.println(x);
            	                         		//out.println("<form method='post' action='Ad'><input name='details' hidden type='text' value='"+rs.getString("product_id")+"' ><input type='submit' style='display:inline-block;margin-left:650px;font-size:20px;border-radius:10px;background-color:yellow;border-color:white;color:white;'value='Buy'/></form>");
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
