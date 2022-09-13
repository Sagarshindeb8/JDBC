/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbccrud;
import java.sql.*;
/**
 *
 * @author Sagar Shinde
 */
public class BookStore
{
    public void getAllBooks(Statement st) throws Exception
    {        
        String str = "select title,author,price from book;";
        ResultSet rs = st.executeQuery(str);
        int RowCounter = 0;
            
        while(rs.next())
        {
            String title = rs.getString("title");
            String author = rs.getString("author");
            float price = rs.getInt("price");

            System.out.println("The data = ");
            System.out.println("title = "+title + " : " + "author = "+author+ " : " +"price = "+price );
            ++RowCounter;
        }       
    }
    public void saveData(Connection con) throws Exception
    {
        String str = "insert into book(title,author,price) values (?,?,?);";
        PreparedStatement pt = con.prepareStatement(str);
        pt.setString(1, "Angular");
        pt.setString(2, "Ethan Brown");
        pt.setFloat(3,630);
        int row = pt.executeUpdate();
    } 
    
    public void DeleteBook(Statement st)throws Exception
    {
        String sq1 = "delete from book where book_id >= 3 and book_id < 4;";
        int Counter = st.executeUpdate(sq1);
        System.out.println("The delete recorded: " + Counter);
    }
    
    public void UpdateBook(Statement st)throws Exception
    {
        String sq2 = "update book set price = 499 where book_id = 3;";
        int Counter = st.executeUpdate(sq2);
        System.out.println("The update recorded: " + Counter);   
    }
}
