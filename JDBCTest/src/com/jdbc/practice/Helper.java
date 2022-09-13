/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jdbc.practice;

import java.awt.Image;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import javax.imageio.ImageIO;

/**
 *
 * @author Sagar Shinde
 */
public class Helper {
    public static ImageIcon getImageIconById(int id, Connection con)
    {
        ImageIcon icon = null;
        
        try{
            String q = "select pic from vehicle.pics where id=?";
            
            PreparedStatement pt = con.prepareStatement(q);
            
            pt.setInt(1, id);
            ResultSet set = pt.executeQuery();
            
            if(set.next())
            {
                Blob b = set.getBlob("pic");
                InputStream is = b.getBinaryStream();
                Image image = ImageIO.read(is);
                icon = new ImageIcon(image);
            }
        
        } catch (Exception e) {
        }

        return icon;
    }
}
