//PreparedStatement:insert

import java.sql.*;
import java.util.*;

class JDBCInsertStUser
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
			Scanner sobj = new Scanner(System.in);
			
			System.out.println("Enter car name");
			String s1 = sobj.nextLine();
			System.out.println("Enter car number");
			int s2 = sobj.nextInt();
			System.out.println("Enter car price");
			int s3 = sobj.nextInt();
			
			String str = "insert into vehicle.car(car_name,car_no,car_price) values(?,?,?);";
			
			PreparedStatement pobj = con.prepareStatement(str);
			
			//pobj.setInt(1,4);
			pobj.setString(1,s1);
			pobj.setInt(2,s2);
			pobj.setInt(3,s3);
			
			pobj.executeUpdate();
			
			System.out.println("Values Inserted...");
			
			con.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}