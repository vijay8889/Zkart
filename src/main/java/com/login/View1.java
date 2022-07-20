package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class View1 extends HttpServlet {
    Connection conn;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String p_id=request.getParameter("details");
        
        
        try {
            String url="jdbc:postgresql://localhost:5432/postgres";
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(p_id);
            conn = DriverManager.getConnection(url, "postgres", "postgres");
            Statement st = conn.createStatement();
            String query = "select * from products where product_id="+p_id+"";
            System.out.println(query);
            ResultSet rs = st.executeQuery(query);
           
            //boolean usrExists = false;
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
           // ResultSetMetaData rsmd = rs.getMetaData();
          //  int no_of_columns = rsmd.getColumnCount();
           // String query2 = "select count(*) from products";
//            ResultSet set2 = st.executeQuery(query2);
//            System.out.println(set2);
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
            		+ "                <li><a href=\" \">Home</a></li>\r\n"
            		+ "                <li><a href=\"first.jsp\">Back</a></li>\r\n"
            		+ "                \r\n"
            		+ "            </ul>\r\n"
            		+ "        </nav>\r\n"
            		+ "    </div>");
  if(rs.next()) {
	  String x="";
            	
            		    String y="";
                      	String p="product_id:  ";
                      	String n="Name:  ";
                      	String pr="Price:  ";
                      	String r="Rating:  ";
                      	String a="Available:  ";
                      	String d="Discount:  ";
                      	String f="Feature:   ";
                      	String ds="Description:   ";
                      	String dp="DiscountedPrice: ";
                      	String imurl=rs.getString("img_url");
                      	x+="<img src="+imurl+" style='width:60%; height:60%;margin-left:200px;'>"+"<br>";
                      			x+="<div style='background: rgb(238,174,202);background: radial-gradient(circle, rgba(238,174,202,1) 0%, rgba(148,187,233,1) 100%);border-radius:10px;width:750px;margin-left:200px;height:150px; text-align:center';>";
                                 y+="<br>";
                      			 //y+="<strong>"+p  +"</strong>" + rs.getString("product_id")+"<br>";
                             		 
                             		// y+="Catregory:"+ rs.getString("catogories")+"<br>";
                             		 y+="<strong>"+n  +"</strong>" + rs.getString("name")+"<br>";
//                         		     y+="<strong>"+pr  +"</strong>" + rs.getString("price")+"<br>";		 
//                             		 y+="<strong>"+r  +"</strong>" + rs.getString("rating")+"<br>";
//                             		 y+="<strong>"+a  +"</strong>" + rs.getString("availability")+"<br>";
//                             		 y+="<strong>"+d  +"</strong>" + rs.getString("discounts")+"off"+"<br>";
//                             		//y+="<strong>"+dp  +"</strong>" + rs.getString("discounted_price")+"<br>";
                             		 y+="<strong>"+f +"</strong>" + rs.getString("feature")+"<br>";
                             		 y+="<strong>"+ds  +"</strong>" + rs.getString("decription");
                             		 y+="<br>";
                             		 
                             		 
                         		x+=y;
                         		x+="</div>";
                         		
                         		x+="<br/>";
                         		
            		
                         		out.println(x);
                         		
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

