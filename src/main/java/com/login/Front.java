package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Front extends HttpServlet {
    Connection conn;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String cname = request.getParameter("cname");
        
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
            String query = " select * from products where catogories::text Like '"+cname+"%' or name::text Like '"+cname+"%'";
            //String query="select * from products where catogories="+cname+" or name="+cname+";";
            System.out.println(query);
            ResultSet rs = st.executeQuery(query);
            //boolean usrExists = false;
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            //ResultSetMetaData rsmd = rs.getMetaData();
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
            		+ "                <li><a href=\"home.jsp\">Back</a></li>\r\n"
            		+ "                \r\n"
            		+ "            </ul>\r\n"
            		+ "        </nav>\r\n"
            		+ "    </div>");
            if(!rs.next()) {
            	out.print("<h1>no products available</h1>");
            	return;
            }
            while(rs.next()) {
            	
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
            	String imurl=rs.getString("img_url");
            			x+="<div style='background-color:pink;border-radius:10px;width:900px;margin-left:250px; text-align:center';>";
          
            			 //y+="<strong>"+p  +"</strong>" + rs.getString("product_id")+"<br>";
                   		 y+="<img src="+imurl+" style='width:40%; height:50%'>"+"<br>";
                   		// y+="Catregory:"+ rs.getString("catogories")+"<br>";
                   		 y+="<strong>"+n  +"</strong>" + rs.getString("name")+"<br>";
               		     y+="<strong>"+pr  +"</strong>" + rs.getString("price")+"<br>";		 
                   		 y+="<strong>"+r  +"</strong>" + rs.getString("rating")+"<br>";
                   		 y+="<strong>"+a  +"</strong>" + rs.getString("availability")+"<br>";
                   		 y+="<strong>"+d  +"</strong>" + rs.getString("discounts")+"off"+"<br>";
                   		 y+="<strong>"+f +"</strong>" + rs.getString("feature")+"<br>";
                   		 y+="<strong>"+ds  +"</strong>" + rs.getString("decription");
               		
               		x+=y;
               		x+="</div>";
               		 
               		x+="<br/>";

               		out.println(x);
               		out.println("<form method='post' action='AddToCart'><input name='details' hidden type='text' value='"+rs.getString("product_id")+"' ><input type='submit' style='display:inline-block;margin-left:650px;font-size:20px;border-radius:10px;background-color:yellow;border-color:white;color:black;'value='Add To Cart'/></form>");
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