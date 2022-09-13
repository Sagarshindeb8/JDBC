/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbccrud;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Sagar Shinde
 */
public class JDBCcrud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        BookStore bs = new BookStore(); 
        try
        {
            //Creating connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","Mym@rathi1");
            
            //Access a statement
            Statement st = con.createStatement();
            
            int input;
            
            do{
                System.out.println("Bookstore");
                System.out.println("1. Display");
                System.out.println("2. Insert");
                System.out.println("3. Modify");
                System.out.println("4. Delete");           
                
                Scanner sobj = new Scanner(System.in);
                input = sobj.nextInt();
                
                switch(input)
                {
                    case 1:
                        bs.getAllBooks(st); //Display all
                        break;
                    case 2:
                        bs.saveData(con); //Insert / Create
                        break;
                    case 3:
                        bs.UpdateBook(st); //Update
                        break;
                    case 4:
                        bs.DeleteBook(st); //Delete
                        break;
                    default:
                        
                        break;
                }
            }while(input > 0);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }
    
}
