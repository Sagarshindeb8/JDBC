/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.jdbctut1;
import java.io.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Sagar Shinde
 */
public class JDBCTut1 {

    public static void main(String[] args) {
        try
        {
            //System.out.println("Hello World!");
            
            Connection cobj = ConnectionProvider.getConnection();
            
            String q = "insert into vehicle.pics(id,pic) values(?,?);";
            
            PreparedStatement pt = cobj.prepareStatement(q);
            
            JFileChooser jfc = new JFileChooser();
            
            jfc.showOpenDialog(null);
            
            File fobj = jfc.getSelectedFile();
            
            FileInputStream fis = new FileInputStream(fobj);
            
            pt.setInt(1,1);
            pt.setBinaryStream(2, fis, fis.available());
            
            pt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"success");
            
        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
    }
}
