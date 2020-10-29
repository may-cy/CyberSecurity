package datachange;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

import classes.Message;

public class MessageData {
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
	public String insertData(Message message) {
		
		try {
			// create a mysql database connection
			Connection con = getConnection();
			
			String myDriver = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/maysadb";
			Class.forName(myDriver);
			 con = (Connection) DriverManager.getConnection(myUrl, "root", "");
			// note that i'm leaving "date_created" out of this insert statement
			String qury = "insert into maysadb.usermessages  values (?,?,?,?)";
			
			java.sql.PreparedStatement st = con.prepareStatement(qury);
			st.setInt(1, message.getId());
			st.setString(2, message.getUsername());
			st.setString(3, message.getSentname());
			st.setString(4, message.getMesg());
			
			st.executeUpdate();
            
            System.out.print("Hi Inserted");
            
            
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		return null;
		

	}

}
