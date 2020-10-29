<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send Message</title>
</head>
<body>
<%
		if (session.getAttribute("username") == null)
		{
			
			response.sendRedirect("login.jsp");
		}

	
	%>
<form  action="./MessageServlet"   method= "post" >
<table>
<tr><td><input type="text" name="uname"   style="display: none;"  value = "<%=session.getAttribute("username")%>" ></td></tr>
<tr><td>send To :  <input type="text" name="stname" > </td></tr>
<tr><td><textarea rows="15" cols="24" name="meg"></textarea></td></tr>
<tr><td><input type="submit" value="send"> </td></tr>


</table>
</form>
</body>
</html>