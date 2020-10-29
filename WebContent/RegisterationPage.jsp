<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Registeration Page</title>
</head>
<body>
<form action="./RegisterationServlets"  method="post">

<table>
<tr><td>First Name </td><td><input type="text" name ="fname"></td></tr>
<tr><td>Last Name </td><td><input type="text" name ="lname"></td></tr>
<tr><td>Email </td><td><input type="text" name = "email" ></td></tr>
<tr><td>UserName </td><td><input type="text" name = "uname" ></td></tr>
<tr><td>Password </td><td><input type="password"  id="txtPassword" name ="pword" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required></td></tr>
<tr><td>Confirm Password </td><td><input type="password" id="txtConfirmPassword"  name ="p2word" required="required" ></td></tr>
<tr><td><input type="submit"  value="Register" onclick="return Validate()"></td></tr>



</table>
<script type="text/javascript">
    function Validate() {
        var password = document.getElementById("txtPassword").value;
        var confirmPassword = document.getElementById("txtConfirmPassword").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }
</script>
</form>
</body>
</html>