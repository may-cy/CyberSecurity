package connection;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DBconnection {

		public static void main(String args[])
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
			

		}

	}
