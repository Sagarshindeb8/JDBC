/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jdbctut1;
import java.sql.*;

/**
 *
 * @author Sagar Shinde
 */
public class ConnectionProvider {
    
    private static Connection con;
    
    public static Connection getConnection()
    {
        try
        {
            if(con == null)
            {
                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle","root","Mym@rathi1");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return con;
    }
    
}
