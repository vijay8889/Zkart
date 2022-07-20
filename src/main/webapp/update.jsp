<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UPDATE PAGE</title>
    <link rel = "stylesheet"  href="style.css" media = "screen" />
    <style>
body {
  font-family: Arial;
}

input {
  width: 80%;
  padding: 12px 20px;
  margin: 8px 0;
  display: block;
  border: 1px solid #ccc;
  border-radius: 10px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 80%;
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 10px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div.container1 {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 50px;
  margin : auto;
  height: 950px;
  width:500px;
  
}
</style>
    
</head>
<body >
   <%
if(session.getAttribute("username")==null){
	response.sendRedirect("Admin.jsp");
}

%>
<% 
          response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
          response.setHeader("Pragma", "no-cache");
          response.setHeader("expires","0");

        
%>

    <div class="header">
    <div class="container">
    <div class="navbar">
        <div class="logo">
            <img src="images/logo1.png" width="125px" height="70px">
        </div>
        <nav>
            <ul id="MenuItems">
                <li><a href=" ">Home</a></li>
                <li><a href="">Products</a></li>
                <li><a href="Addproducts.jsp">Back</a></li>
                <li><a href="Admin.jsp" class="btn">Logout</a></li>
                
            </ul>
        </nav>
        <img src="images/cart.png" width="30px" height="30px">
       
    </div>
    </div>
 
    <% String invalid; %>
									<% if (request.getAttribute("invalid") != null) {
     								  invalid = request.getAttribute("invalid").toString(); 
      										 out.println(invalid + "<h1 style='color:red'><br>Please Add New Product<br></h1>"); 
     										 }  %> 
     										 <% String valid; %>
									<% if (request.getAttribute("valid") != null) {
     								  valid = request.getAttribute("valid").toString(); 
      										 out.println(valid + "<p  style='color:red'><br>Add Another Product<br></p>"); 
     										 }  %>   
     										  <% String valids; %>
									<% if (request.getAttribute("valids") != null) {
     								  valids = request.getAttribute("valids").toString(); 
      										 out.println(valids + "<p style='color:red'><br>Add Another Product<br></p>"); 
     										 }  %>   
    
    <div class="container1">
<h1>UPDATE PRODUCTS</h1>
<form action="Update" method="POST" >

    <label for="imgurl">Imgage</label>
    <input type="text" id="imgurl" name="imgurl" >
    <label for="catogory">Catogory</label>
    <input type="text" id="catogory" name="catogory" >
     <label for="name">Name</label>
    <input type="text" id="name" name="name" >
     <label for="feature">Feature</label>
    <input type="text" id="feature" name="feature" >
     <label for="description">Description</label>
    <input type="text" id="description" name="description" >
     <label for="rating">Rating</label>
    <input type="number" id="rating" name="rating" >
     <label for="availability">Availability</label>
    <input type="number" id="availability" name="availability" >
     <label for="price">Price</label>
    <input type="number" id="price" name="price" >
    <label for="discount">Discount</label>
    <input type="number" id="discount" name="discount" >

  

  
    <input type="submit" value="Edit">
                   
  </form>
</div>
    


</body>
</html>
