<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<form  action="./LoginServ"  method="post"  >
<table>
<tr><td>Username</td><td><input   type="text"  name="uname"></td></tr>
<tr><td>Password</td><td><input   type="password"  name="pword"></td></tr>
<tr><td><input type="submit"  value="Login" ></td>
<td> <a href="RegisterationPage.jsp " ><input type="button" value="Register" > </a></td>
</tr>

</table>
</form>
</body>
</html>