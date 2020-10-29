package datachange;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import classes.Registeration;

public class RegisterationData {

	public Connection getConnection()
	{
		
	
	Connection conn = null ;
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver"); 
		conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/maysadb", "root", "");
		
		if(conn != null)
		
			System.out.println( "Connection Successfuly" );
		
		
	}catch (Exception e) {

		   System.out.println( "Connection Failed" );
         }
	return conn;
	
	}
	public String insertData(Registeration registeration) {
		
		try {
			// create a mysql database connection
			Connection con = getConnection();
			
			String myDriver = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/maysadb";
			Class.forName(myDriver);
			 con = (Connection) DriverManager.getConnection(myUrl, "root", "");
			// note that i'm leaving "date_created" out of this insert statement
			String qury = "insert into maysadb.users  values (?,?,?,?,?)";
			
			java.sql.PreparedStatement st = con.prepareStatement(qury);
			st.setString(1, registeration.getFirstName());
			st.setString(2, registeration.getLastName());
			st.setString(3, registeration.getEmail());
			st.setString(4, registeration.getUsername());
			st.setString(5, registeration.getPassword());
			st.executeUpdate();
            
            System.out.print("Hi Inserted");
            
            
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		return null;
		

	}

}
