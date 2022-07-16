package com.login;

public class HttpServlet {

}
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>REGISTRATION PAGE</title>
    <link rel = "stylesheet"  href="style.css" media = "screen" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
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
                <li><a href="">Contact</a></li>
                <li><a href="">Account</a></li>
            </ul>
        </nav>
        <img src="images/cart.png" width="30px" height="30px">
        <img src="images/menu.png" class="menu-icon" onclick="menutoggle()">
    </div>
    </div>
    
    <div class="account-page">
    <div class="container">
        <div class="row">
            <div class="col-2">
                <img src="images/image1.png" width="100%">
            </div>
            <div class="col-2">
                <div class="form-container">
             
                            <h1>Register</h1>
                      <form align="center" action="Register" method="post">
                        UserName: <input type="text" placeholder="Username" name="username" required><br>
                               <br>
                        Password: <input type="password" placeholder="Password" name="password" required><br>
                               <br>
                        EmailId: <input type="email" placeholder="Email" name="email" required><br>
                               <br>
                        PhoneNumber: <input type="number" placeholder="Phone Number" name="phno" required><br>
                               <br>
                               <button type="submit" class="btn" >Sign Up</button>
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





















<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

        <title>Sample Registration Page</title>
        <style>
            body {
               background-color: #eec0c6;
               background-image: linear-gradient(315deg, #eec0c6 0%, #7ee8fa 74%);
               background-repeat: none;
            }
            
            form {
                padding: 10px;
                line-height: 10px
            }
            
            main {
                width: 200px;
                height: 200px;
                padding: 10px;
                background: beige;
            }
            
            p {
                font-family: Open Sans;
                color: black;
               /* border-bottom: 1.50px solid black;*/
                font-family: cursive;
                color: black;
            }
            
            button {
                background-color: rgb(0, 0, 0);
                cursor: pointer;
                width: 100px;
                height: 25px;
            }
            
            button:hover {
                opacity: 0.52;
            
            }
     .topnav {
      overflow: hidden;
      background-color: rgb(85, 79, 79);
    }
    
    .topnav a {
      float: left;
      color: #f2f2f2;
      text-align: center;
      padding: 14px 16px;
      text-decoration: none;
      font-size: 17px;
    }
    
    .topnav a:hover {
      background-color: #ddd;
      color: black;
    }
    
    .topnav a.active {
      background-color: #9481c2;
      color: white;
    }
            
    
    
        </style>
    </head>
    
    
    
    <body>
        <div class="topnav">
            <a class="active">Home</a>
            <a href="news.html">News</a>
            <a href="contact.html">Contact</a>
            <a href="about.html"target=>About</a>
            <a href="login.html">Login</a>
           
          </div>
      <section>
        <p style="color:rgb(14, 10, 141); 
        font-size:45px;  
        font-weight:bold;
        text-align:center;">
                Registration form </p>
        
    
      
        <form align="center" action="Register" method="post">
           UserName: <input type="text" placeholder="Username" name="username" required><br>
            <br>
            Password: <input type="password" placeholder="Password" name="password" required><br>
            <br>
            EmailId: <input type="email" placeholder="Email" name="email" required><br>
            <br>
            PhoneNumber: <input type="number" placeholder="Phone Number" name="phno" required><br>
            <br>
            <input type="submit" value="Sign Up">
        </form>
    
    
       
    </section>
    
    
    </body>
    
    
</html>
