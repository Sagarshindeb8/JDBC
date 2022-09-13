//Insert Image into Database

import java.sql.*;
import java.io.*;

class JDBCImage
{
	public static void main(String a[])
	{
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle","root","Mym@rathi1");
		
		String q = "insert into vehicle.pics(id,pic) values(?,?);";
		
		PreparedStatement pt = con.prepareStatement(q);
		
		FileInputStream fis = new FileInputStream("Ganesh.jpg");
		
		pt.setInt(1,1);
		pt.setBinaryStream(2,fis,fis.available());
		
		pt.executeUpdate();
		
		System.out.println("Image inserted into database...");
		}
		catch(Exception e)
		{
			System.out.println("Error!");
		}
	}
}