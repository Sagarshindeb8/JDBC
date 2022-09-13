//JDBC

import java.sql.*;

class JDBC
{
	public static void main(String a[])
	{
		try
		{
			//Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create connection
			String url = "jdbc:mysql://localhost:3306/vehicle";
			String username = "root";
			String password = "Mym@rathi1";
			Connection con = DriverManager.getConnection(url,username,password);
			
			//Check connection
			if(con.isClosed())
			{
				System.out.println("Connection is closed");
			}
			else
			{
				System.out.println("Connection created successfully...");
			}
			
			//create query
			String s = "create table vehicle.car(Sno int(10) primary key auto_increment,car_name varchar(20),car_no int(10) not null,car_price int(100));";
			
			//create statement
			Statement st = con.createStatement();
			
			st.executeUpdate(s);
			
			System.out.println("car table created successfully!");
			
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}