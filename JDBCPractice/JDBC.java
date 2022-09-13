import java.sql.*;

class JDBC
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        //Load the Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Create connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Mym@rathi1");

        //Create query
        
        //Insert query
        //String q = "insert into student values(501,'Rajkumar',98,'Nagpur');";
        
        //Delete query
        //String q = "delete from student where RollNo=501";

        //Update query
        //String q = "update student set Marks=11 where RollNo=151";

        //Read query
        String q = "select * from student";

        //Fire query
        Statement stmt = con.createStatement();

        //int r = stmt.executeUpdate(q); //used for insert, update and delete query.

        ResultSet set = stmt.executeQuery(q);

        while(set.next())
        {
            int RNo = set.getInt("RollNo");
            String name = set.getString("Name");
            int mark = set.getInt("Marks");
            String city = set.getString("City");
            System.out.println(RNo + " : " + name + " : " + mark +" : " + city);
        }

        //System.out.println(r + " rows inserted successfully!");
        //System.out.println(r + " rows deleted successfully!");
        //System.out.println(r + " rows updated successfully!");

        con.close();

    }
}