//PreparedStatement:insert

import java.sql.*;

class JDBCInsertSt
{
	public static void main(String a[])
	{
		try
		{
			//Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			//Create Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle","root","Mym@rathi1");
			
			if(con.isClosed())
			{
				System.out.println("Connection is closed");
			}
			else
			{
				System.out.println("Connection created successfully!");
			}
			
			//Create Query			
			String st = "insert into vehicle.car values(3,'verna',1234,800000);";
			
			Statement s = con.createStatement();			

			s.executeUpdate(st);
			
			System.out.println("Values Inserted...");
			
			con.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}