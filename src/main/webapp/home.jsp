<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*, java.util.*, java.sql.*" %>
<%@ page import="jakarta.servlet.http.*, jakarta.servlet.*" %>

<%
String url="jdbc:postgresql://localhost:5432/postgres";
String uname="postgres";
String pw="postgres";
Class.forName("org.postgresql.Driver");
%>
<!DOCTYPE htm
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home-Page</title>
    <link rel = "stylesheet"  href="style.css" media = "screen" />

</head>
<body>
<%
response.setHeader("Cache-control","no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
%>


    <div class="header">
    <div class="container">
    <div class="navbar">
        <div class="logo">
            <img src="images/logo1.png" width="125px" height="70px">
        </div>
        <nav>
            <ul id="MenuItems">
                <li><form action="Wishlist" method="POST">
                         <button class="btn">Wishlist   
                   <!--  <img src="images/cart.png" width="30px" height="30px">-->
                           </button>    
                       </form>
                </li>
                <li><form action="Profile" method="POST">
                         <button class="btn">profile   
                   <!--  <img src="images/cart.png" width="30px" height="30px">-->
                           </button>    
                       </form>
                </li>
                
                
            
                <li><div class="mycart">
                <form action="MyCart" method="POST">
                         <button class="btn">My Cart   
                   <!--  <img src="images/cart.png" width="30px" height="30px">-->
                               
                       </form>
                </button>
			  </div> 
			</div></li>			                
            </ul>
            
        </nav>
        

    </div>
    <% String invalid; %>
									<% if (session.getAttribute("invalid") != null) {
     								  invalid = session.getAttribute("invalid").toString(); 
      										 out.println(invalid + "<p style='color:red'><br>Add Another Product To Cart<br></p>"); 
     										 }  %> 
     										 <% String invalid1; %>
									
   <% String valid; %>
									<% if (request.getAttribute("valid") != null) {
     								  valid = request.getAttribute("valid").toString(); 
      										 out.println(valid + "<p style='color:red'><br>Add Another Product To Wishlist<br></p>"); 
     										 }  %> 
    <% String valids; %>
									<% if (request.getAttribute("valids") != null) {
     								  valids = request.getAttribute("valids").toString(); 
      										 out.println(valids + "<p style='color:red'><br>Add Unavailable Products To Wishlist<br></p>"); 
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

<form align="center" action="Front" method="post">
                        <input type="text"  name="cname" maxlength="50" style="height:30px;border-radius:10px;"size="100"><br>
                           <button type="submit" class="btn" >Search</button></form>
<div class="catogoriessss">
    
        
           
                
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
            			x+="<div style='background-color:pink;border-radius:10px;width:900px;margin-left:250px; text-align:center';>";    
            			 //y+="<strong>"+p  +"</strong>" + rs.getString("product_id")+"<br>";
                   		 y+="<img src="+imurl+" style='width:40%; height:50%'>"+"<br>";
                   		// y+="Catregory:"+ rs.getString("catogories")+"<br>";
                   		 y+="<strong>"+n  +"</strong>" + rs.getString("name")+"<br>";
               		     y+="<strong>"+pr  +"</strong>" + rs.getString("price")+"<br>";		 
                   		 y+="<strong>"+r  +"</strong>" + rs.getString("rating")+"<br>";
                   		 y+="<strong>"+a  +"</strong>" + rs.getString("availability")+"<br>";
                   		 y+="<strong>"+d  +"</strong>" + rs.getString("discounts")+"off"+"<br>";
                   		 //y+="<strong>"+f +"</strong>" + rs.getString("feature")+"<br>";
                   		 //y+="<strong>"+ds  +"</strong>" + rs.getString("decription");
               		
               		x+=y;
               		x+="<form method='post' action='AddToCart'><input name='details' hidden type='text' value='"+rs.getString("product_id")+"' ><input type='submit' style='margin-left:650px;font-size:20px;border-radius:30px;background-color:yellow;border-color:white;color:black;'value='Add To Cart'/></form><form method='post' action='AddToWishlist'><input name='details' hidden type='text' value='"+rs.getString("product_id")+"' ><input type='submit' style='display:inline-block;margin-left:650px;font-size:20px;border-radius:10px;background-color:e0007a;border-color:white;color:white;'value='WishList'/></form>";
               		x+="</div>";
               		 
               		x+="<br/>";

               		out.println(x);
               		//out.println("<form method='post' action='AddToCart'><input name='details' hidden type='text' value='"+rs.getString("product_id")+"' ><input type='submit' style='margin-left:650px;font-size:20px;border-radius:10px;background-color:yellow;border-color:white;color:black;'value='Add To Cart'/></form><form method='post' action='AddToWishlist'><input name='details' hidden type='text' value='"+rs.getString("product_id")+"' ><input type='submit' style='display:inline-block;margin-left:650px;font-size:20px;border-radius:10px;background-color:e0007a;border-color:white;color:white;'value='WishList'/></form>");
            }
	
	
	conn.close();
	st.close();
} catch (Exception e) {
e.printStackTrace();
}
finally
{
    System.out.println("finally block executed");
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