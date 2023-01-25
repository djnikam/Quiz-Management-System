import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

class Student_login1 extends JFrame
{
    JTextField user;
    JTextField password;

        Connection con = null;
        public  int roll_no,stuid;
        public String name;
        public Student_login1() throws IOException {
            con = (Connection) Db.dbconnect();
            setTitle("Student Login");
            setLocation(380,120);
            setLayout(null);
            setResizable(false);
            setContentPane(new JLabel(getImage()));

            Font fo = new Font("Times New Roman",Font.BOLD,30);
            Font fo1 = new Font("Times New Roman",Font.PLAIN,18);


            ImageIcon i1 = new ImageIcon("Images/logo.png");
            setIconImage(i1.getImage());

            JLabel stu = new JLabel("Student Login ");
            stu.setBounds(400, 1, 200, 100);
            stu.setForeground(Color.RED);
            stu.setFont(fo);
            add(stu);

            JLabel stu_img = new JLabel();
            stu_img.setIcon(new ImageIcon("D:\\Desktop\\Quiz_Management_System - Copy\\Images\\student.png"));
            stu_img.setBounds(455, 90, 200, 100);
            add(stu_img);


            JLabel j1 = new JLabel("User Name :");
            j1.setBounds(400, 200, 100, 40);
            j1.setFont(fo1);
            add(j1);

            JLabel j2 = new JLabel("Password :");
            j2.setBounds(400, 300, 100, 40);
            j2.setFont(fo1);
            add(j2);

            user = new JTextField();
            user.setBounds(500,200,120,40);
            add(user);

            password = new JPasswordField();
            password.setBounds(500,300,120,40);
            add(password);


            JButton b1 = new JButton("Login");
            b1.setFont(fo1);
            b1.setBounds(400,380,100,40);
            add(b1);

            JButton b2 = new JButton("Back");
            b2.setFont(fo1);
            b2.setBounds(520,380,100,40);
            add(b2);


            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   try {
                       String usr= user.getText();
                       String pwd=String.valueOf(password.getText());
                       PreparedStatement pst= (PreparedStatement)con.prepareStatement("select * from student_login where stu_username =? and stu_password=?");
                       pst.setString(1,usr);
                       pst.setString(2,pwd);
                       ResultSet r = pst.executeQuery();
                       if(r.next())
                       {
                           stuid = r.getInt("stu_id");
                           roll_no = r.getInt("stu_rollno");
                           name = r.getString("stu_name");
                           JOptionPane.showMessageDialog(null,"Login Successfull ");
                           dispose();
                           student_instruction_page1 i1 = new student_instruction_page1(stuid,roll_no,name);
                           i1.setSize(1000, 600);
                       }
                       else
                       {
                           JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                       }
                   }catch (Exception e1)
                   {
                       e1.printStackTrace();
                   }
                }
            });

            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    Welcome_page1 w2 = null;
                    try {
                        w2 = new Welcome_page1();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    w2.setSize(800, 600);

                }
            });

            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        static ImageIcon getImage() throws IOException {
        BufferedImage img = ImageIO.read(new File("D:\\Desktop\\Quiz_Management_System - Copy\\Images\\stu_bg.jpg"));
        Image scaled = img.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaled);
        return icon;
    }

}

public class Student_login
{
    public static void main(String args[]) throws IOException {

        Student_login1 s = new Student_login1();
        s.setSize(800,600);
    }
}
