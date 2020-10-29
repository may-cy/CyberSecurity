<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Confirm Login</title>
</head>

<body>

	<%
		if (session.getAttribute("username") == null)
		{
			
			response.sendRedirect("login.jsp");
		}

	
	%>

Welcome ${username}

<br>
<a href="newMessage.jsp" > Send New Message </a>
OR <a href="Message.jsp" > Show Previous Messages   </a>

</body>
</html>