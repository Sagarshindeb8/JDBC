/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jdbc.practice;

import java.sql.*;

/**
 *
 * @author Sagar Shinde
 */
public class SelectJDBC {
    public static void main(String[] args) {
        try {
            Connection con = ConnectionProvider.getConnection();
            
            String q = "select * from vehicle.car;";
            
            Statement stmt = con.createStatement();
            
            ResultSet set = stmt.executeQuery(q);
            
            while(set.next())
            {
                int id = set.getInt(1);
                String name = set.getString(2);
                int no = set.getInt(3);
                int cost = set.getInt(4);  
                System.out.println(id + " : " + name + " : " + no + " : " + cost);
            }
            
            con.close();
            
        } catch (Exception e) {
        }
    }
}
