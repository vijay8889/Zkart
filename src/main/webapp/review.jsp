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
  height: 500px;
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
        
<%
String p_id=request.getParameter("details");
String product_name="";
try{ 
	
	Connection conn=DriverManager.getConnection(url,uname,pw);
	
	String query="select * from products where product_id="+p_id+"";
	Statement st=conn.createStatement();
	ResultSet rs=st.executeQuery(query);
	System.out.println("Query: "+query);
	while(rs.next()){
	
		 product_name=rs.getString("name");
         System.out.println(product_name);
	
}} catch (Exception e) {
e.printStackTrace();
}
finally
{
    //System.out.println("finally block executed");
}
%>         

<div class="containerss">
<h1>PURCHASE DETAILS</h1>
 

<form action="Review" method="post">
     <h3><%=product_name%></h3>
     <br>
    <label for="review">Review/Comment</label>
    <input type="text" id="review" name="review" >
       
       <label>Rate Us Between 0 to 5</label>
       
     <!-- <label for="rating">Rating</label> -->
    <input type="number" id="rating" step="0.01" name="rating" >
    
     
    
     
    <input type="hidden"   name="p_id" value=<%=p_id %> >
    <input type="submit" value="submit">
  </form>
</div>

</body>
</html>