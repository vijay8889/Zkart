<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>REGISTRATION PAGE</title>
    <link rel = "stylesheet"  href="style.css" media = "screen" />
    
</head>
<body style="overflow: hidden;">
    <div class="header">
    <div class="container">
    <div class="navbar">
        <div class="logo">
            <img src="images/logo1.png" width="125px" height="70px">
        </div>
        <nav>
            <ul id="MenuItems">
                <li><a href="">Home</a></li>
                <li><a href="">Products</a></li>
                <li><a href="">About</a></li>
                <li><a href="first.jsp">Back</a></li>
             
            </ul>
        </nav>
        <img src="images/cart.png" width="30px" height="30px">
        
    </div>
    </div>
     
    
    <div class="account-page acc-pg">
    <div class="container">
        <div class="row">
            <div class="col-2">
                <img id="image1"  src="images/image2.png" width="100%"><br><br>
            </div>
            <div class="col-2">
                <div class="form-container frm-con" style="margin-left:30%; margin-top:-20%; border-radius: 10px; height:450px">
             		<div id="content" style="margin-top:-11%;">
                            <h1>Register</h1>
                      <form align="center" action="Register" method="post">
                      <% String invalid; %>
								<% if (request.getAttribute("invalid") != null) {
      							 invalid = request.getAttribute("invalid").toString(); 
       								out.println(invalid + "<p style='color:red'><br>Please try again With New Email Id<br></p>"); 
     							 }  %>
     							 
                        UserName: <input type="text" placeholder="Username" name="username" required><br>
                               <br>
                        Password: <input type="password" placeholder="Password" name="password" required><br>
                               <br>
                        EmailId: <input type="email" placeholder="Email" name="email" required><br>
                               <br>
                        Address: <input type="address" placeholder="address" name="address" required><br>
                               <br>
                               
                        &ensp;PhoneNumber: <input type="number" placeholder="Phone Number" name="phno" required><br>
                               
                               <button type="submit" class="btn" >Sign Up</button>
                              
                       </form>
                       </div>
                        
                </div>

            </div>

        </div>
    </div>


            



</body>
</html>