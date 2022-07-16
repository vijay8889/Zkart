<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>
Login page
</title>
<meta charset="UTF-8">
<link rel = "stylesheet"  href="style.css" media = "screen" />
    
</head>
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

div.containerss {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 50px;
  margin : auto;
  height: 600px;
  width:500px;
  
}
</style>

<body>
<div class="header">
    <div class="container">
    <div class="navbar">
        <div class="logo">
            <img src="images/logo1.png" width="125px" height="70px">
        </div>
        <nav>
            <ul id="MenuItems">
                <li><a href="home.jsp">Home</a></li>
                
                
            </ul>
        </nav>

<div class="containerss">
<h1>EDIT DETAILS</h1>
<form action="Edit" method="post">


    <label for="name">Name</label>
    <input type="text" id="name" name="name" >
    
     <label for="password">Password</label>
    <input type="password" id="password" name="password" >
    
     <label for="email">Email</label>
    <input type="email" id="email" name="email" >
    
     <label for="address">Address</label>
    <input type="text" id="address" name="address" >
    
     <label for="phno">PhoneNumber</label>
    <input type="number" id="phno" name="phno" >
    
    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>