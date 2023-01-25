import java.sql.*;

public class Demo_1 {

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo_1","Djnikam","Pass@1234");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from employee");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
           }catch(Exception e){ System.out.println(e);}
        System.out.println("Connected");
    }
}
