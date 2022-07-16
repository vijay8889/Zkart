<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String driverName = "org.postgresql.jdbc.Driver";
String connectionUrl = "jdbc:postgresql://localhost:5432/";
String dbName = "postgres";
String userId = "postgres";
String password = "postgres";
int x = 1;

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<html>
<head>
<!--  -->
<link rel="stylesheet" href="Members.css">
<head>
<title>View Members</title>
<body>
<h2 align="center"><font><strong>Logged in as a Super Admin</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">

<%
String cname = request.getParameter("cname");
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql =" select * from products where catogories::text Like '"+cname+"%';";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
	//int index = resultSet.getInt(1);
%>
	<div >
		<p>Product_id<%=resultSet.getString("product_id")%></p><br>
		<p>Catogory<%=resultSet.getString("catogories")%></p><br>
		<p>Feature<%=resultSet.getString("feature")%></p><br>
		<p>Description<%=resultSet.getString("catogories")%></p><br>
		<p><%=resultSet.getString("catogories")%></p><br>
		<p>Catogories<%=resultSet.getString("catogories")%></p><br>
		<p>Catogories<%=resultSet.getString("catogories")%></p><br>
		<p>Catogories<%=resultSet.getString("catogories")%></p><br>
		<p>Catogories<%=resultSet.getString("catogories")%></p>			
	</div>
 
<% 

}
connection.close();
statement.close();

} catch (Exception e) {
e.printStackTrace();
}
finally
{
    System.out.println("finally block executed");
}
%>
</table>
</body>
</html>