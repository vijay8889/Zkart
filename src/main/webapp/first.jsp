<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>

<%
String url="jdbc:postgresql://localhost:5432/postgres";
String uname="postgres";
String pw="postgres";
Class.forName("org.postgresql.Driver");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>1</title>
    <link rel = "stylesheet"  href="style.css" media = "screen" />

</head>
<body >
    <div class="header">
    <div class="container">
    <div class="navbar">
        <div class="logo">
            <img src="images/logo1.png" width="125px" height="70px">
        </div>
        <nav>
            <ul id="MenuItems">
                  <li><a href=" ">Home</a></li>
                <li><a href="regis.jsp">Register</a></li>
                <li><a href="log.jsp">Login</a></li>
                <li><a href="Admin.jsp">Admin</a></li>
                
            </ul>
        </nav>
        <img src="images/cart.png" width="30px" height="30px">
        
        

    </div>
     <% String invalid; %>
									<% if (request.getAttribute("invalid") != null) {
     								  invalid = request.getAttribute("invalid").toString(); 
      										 out.println(invalid + "<p style='color:red'><br> To Add  Product To Cart<br></p>"); 
     										 }  %> 
    <div class="row">
        <div class="col-2">
            <h1>One Stop Shop For All Your Needs</h1>
            <h1>A New Style!</h1>
            <p> Enrich your shopping list wisely. <br>
                An exciting place for the whole family to shop.</p>
            <a href="" class="btn">Explore Now &#8594;</a>

        </div>
        <div class="col-2">
            <img src="images/image1.png" alt="">
        </div>
    </div>
</div>
</div>
<br>

<form align="center" action="Front1" method="post">
                        <input type="text"  name="cname" maxlength="50" size="100"><br>
                           <button type="submit" class="btn" >Search</button></form>  
                           
<div class="catogoriess">
    
        
           
                
<%
try{ 
	//System.out.println("At Org block");
	//String email=(String)session.getAttribute("email");
	Connection conn=DriverManager.getConnection(url,uname,pw);
	//
	String query="select * from products";
	Statement st=conn.createStatement();
	ResultSet rs=st.executeQuery(query);
	System.out.println("Query: "+query);
	while(rs.next()){
	
  	
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
            			x+="<div style='background-color:pink;border-radius:10px;width:400px;margin-left:500px; text-align:center';>";    
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
               		out.println("<form method='post' action='AddToCart1'><input name='details' hidden type='text' value='"+rs.getString("product_id")+"' ><input type='submit' style='display:inline-block;margin-left:650px;font-size:20px;border-radius:10px;background-color:yellow;border-color:white;color:white;'value='Add To Cart'/></form>");
            }
	
	
	conn.close();
	st.close();
} catch (Exception e) {
e.printStackTrace();
}
finally
{
    //System.out.println("finally block executed");
}
%>         
   
            </div>

                             
 
 
 <div class="catogories">
    <div class="small-container">
        <div class="row">
            <div class="col-3">
                <img src="images/category-4.jpg" >
            </div>
            <div class="col-3"><img src="images/category-5.jpg" ></div>
            <div class="col-3"><img src="images/category-8.jpg" ></div>
            
        </div>
    </div>
    
</div>
 <div class="offer">
    <div class="small-container">
        <div class="row">
            <div class="col-2">
                <img src="images/exclusive.png" class="offer-img">
            </div>
            <div class="col-2">
                <p>Exclusive Available on ZKART</p>
                <h1>Smart Brand 4</h1>
                <small>
                    SWADESI STUFF Analogue Men's Watch (Black Dial Brown Colored Strap)
                </small>
                <a href="" class="btn">Buy Now &#8594</a>
            </div>
        </div>
    </div>
</div>                            
<div class="brands">
    <div class="small-container">
        <div class="row">
            <div class="col-5">
                <img src="images/logo-godrej.png">
            </div>
            <div class="col-5">
                <img src="images/logo-coca-cola.png">
            </div>
            <div class="col-5">
                <img src="images/logo-oppo.png">
            </div>
            <div class="col-5">
                <img src="images/logo-philips.png">
            </div>
            <div class="col-5">
                <img src="images/logo-paypal.png">
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <div class="container">
        <div class="row">
            <div class="footer-col-1">
                <h3>Download Our App</h3>
                <p>Download App for Android and ios mobile phones</p>
                <div class="app-logo">
                    
                    <img src="images/play-store.png">
                    <img src="images/app-store.png" >
                </div>
            </div>
            <div class="footer-col-2">
                <img src="images/logo1.png" >
                <p>Download App for Android and ios mobile phones</p>
            </div>
            <div class="footer-col-3">
               <h3>UselFul Links</h3>
               <ul>
                <li>Coupons</li>
                <li>Blog Posts</li>
                <li>Return Policy</li>
                <li>Join Afflicate</li>
               </ul>
            </div>
            <div class="footer-col-4">
                <h3>Follow Us</h3>
                <ul>
                 <li>Twitter</li>
                 <li>Instagram</li>
                 <li>Facebook</li>
                 <li>Youtube</li>
                </ul>
             </div>
             

        </div>
        <hr>
        <p class="copyrights">Copyright 2022 - ZKART</p>
    </div>
</div>
  
 
</body>
</html>