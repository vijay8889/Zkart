<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOGIN PAGE</title>
    <link rel = "stylesheet"  href="style.css" media = "screen" />
    
</head>
<body style="overflow:hidden;">

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
                <li><a href="">About</a></li>
                <li><a href="first.jsp">Back</a></li>
                
            </ul>
        </nav>
        <img src="images/cart.png" width="30px" height="30px">
        <img src="images/menu.png" class="menu-icon" onclick="menutoggle()">
    </div>
    </div>
      
    
    <div class="account-page">
    <div class="container" style="margin-top:-17%;">
        <div class="row">
            <div class="col-2">
                <img id="image1"  src="images/image2.png" width="100%">
            </div>
            <div class="col-2">
                <div class="form-container" style="margin-left:30%; margin-top:-20%; border-radius: 10px;">
             
                            <h1>Login</h1>
                      <form align="center" action="Login" method="GET">
                      <% String invalid; %>
									<% if (request.getAttribute("invalid") != null) {
     								  invalid = request.getAttribute("invalid").toString(); 
      										 out.println(invalid + "<p style='color:red'><br>Please try again<br></p>"); 
     										 }  %> 
                          
                          EmailId: <input type="email" placeholder="Email" name="email" required><br> 
                                    <br>  
                                  
                        Password: <input type="password" placeholder="Password" name="password" required><br>
                               <br>
                        
                               <button type="submit" class="btn" >Sign in</button>
                               
                       </form>
                </div>

            </div>

        </div>
    </div>


            
<script>
    var MenuItems=document.getElementById("MenuItems");
    MenuItems.style.maxHeight="0px";

    function menutoggle(){
    if(MenuItems.style.maxHeight="0px"){
        MenuItems.style.maxHeight="200px"
    }
    else{
        MenuItems.style.maxHeight="0px";
    }
    }
</script>

</body>
</html>