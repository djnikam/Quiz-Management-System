import java.sql.*;

public class Db {

    Connection con =null;

    public static Connection dbconnect()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/quiz","Djnikam","Pass@1234");
            return conn;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
}
