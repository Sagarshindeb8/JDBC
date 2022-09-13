/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jdbc.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

/**
 *
 * @author Sagar Shinde
 */
public class UpdateJDBC
{
    public static void main(String[] args) {
        try {
            Connection con = ConnectionProvider.getConnection();
            
            String q = "update vehicle.car set car_name=?, car_no=? where Sno=? ;";
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("Enter new car name");
            String name = br.readLine();
            
            System.out.println("Enter new car number");
            int no = Integer.parseInt(br.readLine());
            
            System.out.println("Enter car Sno");
            int id = Integer.parseInt(br.readLine());
            
            PreparedStatement ptmt = con.prepareStatement(q);
            
            ptmt.setString(1, name);
            ptmt.setInt(2, no);
            ptmt.setInt(3, id);
            
            ptmt.executeUpdate();
            
            System.out.println("Done...");
            
            con.close();
            
        } catch (Exception e) {
        }
    }
}
