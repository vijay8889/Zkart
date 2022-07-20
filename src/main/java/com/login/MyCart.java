package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyCart extends HttpServlet {
    Connection conn;

    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	doPost(request,response);
    }
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
            String query = "select * from products,cart where products.product_id=cart.p_id and cart.c_id=(select c_id from curr_cart where email='"+Cookiecls.email+"') and cart.quantity>0";
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
            		+ "                <li><a href=\"home.jsp\">Back</a></li>\r\n"
            		+ "                \r\n"
            		+ "            </ul>\r\n"
            		+ "        </nav>\r\n"
            		+ "    </div>");
  while(rs.next()) {
	  String x="";
            	if(rs.getString("email").equals(Cookiecls.email)) {
            		if(rs.getString("email").equals("")) {
            			response.sendRedirect("log.jsp");
            		}
            		else {
            		    String y="";
                      	String product_id="product_id:  ";
                      	String product_name="Name:  ";
                      	String product_price="Price:  ";
                      	String product_rating="Rating:  ";
                      	String product_availability="Available:  ";
                      	String product_discount="Discount:  ";
                      	String product_feature="Feature:   ";
                      	String product_description="Description:   ";
                      	String product_discountedprice="DiscountedPrice: ";
                      	String product_qantity="Quantity=";
                      	String quantity = "0";
                      	//String total=0;
                      	String imurl=rs.getString("img_url");
                      			x+="<div style='background: rgb(238,174,202);background: radial-gradient(circle, rgba(238,174,202,1) 0%, rgba(148,187,233,1) 100%);border-radius:10px;width:900px;margin-left:250px; text-align:center';>";
                      					String p_id=rs.getString("product_id");
                      			 //y+="<strong>"+p  +"</strong>" + rs.getString("product_id")+"<br>";
                             		 y+="<img src="+imurl+" style='width:40%; height:50%'>"+"<br>";
                             		// y+="Catregory:"+ rs.getString("catogories")+"<br>";
                             		 y+="<strong>"+product_name+"</strong>" + rs.getString("name")+"<br>";
                         		     y+="<strong>"+product_price+"</strong>" + rs.getString("price")+"<br>";		 
                             		 y+="<strong>"+product_rating+"</strong>" + rs.getString("rating")+"<br>";
                             		 y+="<strong>"+product_availability+"</strong>" + rs.getString("availability")+"<br>";
                             		 y+="<strong>"+product_discount+"</strong>" + rs.getString("discounts")+"off"+"<br>";
                             		String price=rs.getString("price");
                          			String discount=rs.getString("discounts"); 
                             		 float discountedprice=Float.parseFloat(price)-(Float.parseFloat(price)*(Float.parseFloat(discount)/100));
                           		     y+="<strong>"+product_discountedprice+"</strong>" +discountedprice +"<br>";
                           		   
                             		 y+="<strong>"+product_feature+"</strong>" + rs.getString("feature")+"<br>";
                             		 y+="<strong>"+product_description+"</strong>" + rs.getString("decription")+"<br>";
                             		quantity=rs.getString("quantity");
                             		 y+="<form method='post' action='Modifyquantity'><input name='details' hidden type='text' value='"+p_id+"' ><input name='quantity' hidden type='text' value='"+quantity+"' ><input name='operation' hidden type='text' value='-' ><input type='submit' style='display:inline-block;margin-left:50px;font-size:28px;padding-left:20px;padding-right:20px;border-radius:10px;background-color:grey;border-color:white;color:black;'value='-'/></form><br>";
                             		 
                             		 y+="<strong>"+product_qantity+"</strong>" + quantity+"<br>";
                             		 
                             		 y+="<form method='post' action='Modifyquantity'><input name='details' hidden type='text' value='"+p_id+"' ><input name='quantity' hidden type='text' value='"+quantity+"' ><input name='operation' hidden type='text' value='+' ><input type='submit' style='display:inline-block;margin-left:50px;font-size:28px;padding-left:20px;padding-right:20px;border-radius:10px;background-color:grey;border-color:white;color:black;'value='+'/></form><br>";
                            		 
                             		 // total+=discountedprice*quantity;
                             		 
                         		x+=y;
                         		x+="</div>";
                         		//x+="<form method='post' action='Buy'><input name='details' hidden type='text' value='"+rs.getString("product_id")+"' ><input type='submit' style='display:inline-block;margin-left:650px;font-size:20px;border-radius:10px;background-color:yellow;border-color:white;color:white;'value='Buy'/></form>";
                         		 
                         		x+="<br/>";
                         		
            		}}
                         		out.println(x);
                         		
                      }
  String query2 = "select c_id from curr_cart where email='"+Cookiecls.email+"'";
  System.out.println(query);
  ResultSet rs2 = st.executeQuery(query2);
  int c_id=0;
  while(rs2.next()) {
  	c_id=rs2.getInt("c_id");
  }
  out.println("<form method='post' action='purchase.jsp'><input name='details' hidden type='text' value='\"+c_id+\"' ><input type='submit' style='display:inline-block;margin-left:650px;font-size:28px;padding-left:20px;padding-right:20px;border-radius:10px;background-color:#FFD700;border-color:white;color:black;'value='Buy'/></form>");
                      
                     
                      
            
     
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