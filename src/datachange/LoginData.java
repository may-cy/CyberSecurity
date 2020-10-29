package datachange;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import classes.Login;

public class LoginData {
	
	
	
	public boolean validate(Login login) throws ClassNotFoundException {
		boolean status = false;

		

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/maysadb" ,"root", "");
		

		   // Step 2:Create a statement using connection object
		    PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("select * from users where username = ? and password = ? ");
			preparedStatement.setString(1, login.getUsername());
			preparedStatement.setString(2, login.getPassword());

			//System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();

				} catch (Exception e) {
					System.err.println("Got an exception!");
					System.err.println(e.getMessage());
				}
				
		return status;
	


}}
