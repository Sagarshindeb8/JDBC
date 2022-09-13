//PreparedStatement:insert

import java.sql.*;

class JDBCInsert
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
			//Statement s = con.Statement();
			
			String str = "insert into vehicle.car values(?,?,?,?);";
			
			//get preparedStatement object
			PreparedStatement pobj = con.prepareStatement(str);
			
//create table vehicle.car(Sno int(10) primary key auto_increment,car_name varchar(20),car_no int(10) not null,car_price int(100));			
			//set the values to query
			pobj.setInt(1,1);
			pobj.setString(2,"i10");
			pobj.setInt(3,8052);
			pobj.setInt(4,300000);
			
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