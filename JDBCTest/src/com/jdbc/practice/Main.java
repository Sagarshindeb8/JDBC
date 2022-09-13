/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jdbc.practice;
import java.io.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Sagar Shinde
 */
public class Main
{
    public static void main(String[] args) {
        try 
        {            
            //System.out.println("Testing.....");
            
            Connection c = ConnectionProvider.getConnection();
            
            String q = "insert into pics(id,pic) values(?,?);";
            
            PreparedStatement ptmt = c.prepareStatement(q);
            
            JFileChooser jfc = new JFileChooser();
            
            jfc.showOpenDialog(null);
            
            File file = jfc.getSelectedFile();
            
            FileInputStream fis = new FileInputStream(file);
            
            ptmt.setInt(1,3);
            
            ptmt.setBinaryStream(2,fis,fis.available());
            
            ptmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"success");
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}

