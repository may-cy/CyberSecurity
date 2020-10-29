<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


		
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("userid");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "maysadb";
String userid = "root";
String password = "";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<body>
<% 
if (session.getAttribute("username") == null) {

		response.sendRedirect("login.jsp");
	}
	%>

<h1>Show Messages </h1>
<table border="1">
<tr>
<td>Username</td>
<td>Sent to</td>
<td>Message</td>


</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from usermessages";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td  ><%=resultSet.getString("username") %></td>
<td><%=resultSet.getString("sendername") %></td>
<td><%=resultSet.getString("message") %></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>
