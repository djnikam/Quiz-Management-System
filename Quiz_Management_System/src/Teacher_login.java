import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class Teacher_login1 extends JFrame {

    JTextField user,password;

    Connection con = null;
    public int tea_id;
    public String tea_name;
    Teacher_login1() throws IOException {

        con = (Connection) Db.dbconnect();
        setTitle("Teacher Login");
        setLocation(380,120);
        setLayout(null);
        setResizable(false);
        setContentPane(new JLabel(getImage()));

        Font fo = new Font("Times New Roman", Font.BOLD, 30);
        Font fo1 = new Font("Times New Roman", Font.PLAIN, 18);


        ImageIcon i1 = new ImageIcon("Images/logo.png");
        setIconImage(i1.getImage());

        JLabel stu = new JLabel("Teacher Login ");
        stu.setBounds(180, 1, 200, 100);
        stu.setForeground(Color.RED);
        stu.setFont(fo);
        add(stu);

        JLabel Tea_img = new JLabel();
        Tea_img.setIcon(new ImageIcon("D:\\Desktop\\Quiz_Management_System - Copy\\Images\\Teacher.png"));
        Tea_img.setBounds(225, 90, 200, 100);
        add(Tea_img);


        JLabel j1 = new JLabel("User Name :");
        j1.setBounds(175, 200, 100, 40);
        j1.setForeground(Color.BLACK);
        j1.setFont(fo1);
        add(j1);

        JLabel j2 = new JLabel("Password :");
        j2.setBounds(175, 300, 100, 40);
        j2.setForeground(Color.BLACK);
        j2.setFont(fo1);
        add(j2);

        user = new JTextField();
        user.setBounds(275, 200, 120, 40);
        add(user);

        password = new JPasswordField();
//        password.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        password.setBounds(275, 300, 120, 40);
        add(password);


        JButton b1 = new JButton("Login");
        b1.setFont(fo1);
        b1.setBounds(175, 380, 100, 40);
        add(b1);

        JButton b2 = new JButton("Back");
        b2.setFont(fo1);
        b2.setBounds(295, 380, 100, 40);
        add(b2);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String teach_usr= user.getText();
                    String teach_pwd=String.valueOf(password.getText());
                    PreparedStatement pst= (PreparedStatement)con.prepareStatement("select * from teacher_login where teach_username =? and teach_password=?");
                    pst.setString(1,teach_usr);
                    pst.setString(2,teach_pwd);
                    ResultSet r = pst.executeQuery();
                    if(r.next())
                    {
                        tea_id = r.getInt("teach_id");
                        tea_name = r.getString("teach_name");
                        JOptionPane.showMessageDialog(null,"Login Successfull.. ");
                        dispose();
                        Teacher_homepage1 t1 = new Teacher_homepage1(tea_id,tea_name);
                        t1.setSize(800, 600);
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
                Welcome_page1 w1 = null;
                try {
                    w1 = new Welcome_page1();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                w1.setSize(800, 600);

            }
        });


        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    static ImageIcon getImage() throws IOException {
        BufferedImage img = ImageIO.read(new File("D:\\Desktop\\Quiz_Management_System - Copy\\Images\\teach_bg.jpeg"));
        Image scaled = img.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaled);
        return icon;
    }

}

    public class Teacher_login {

    public static void main(String args[]) throws IOException {


    Teacher_login1 t=new Teacher_login1();
    t.setSize(800, 600);

    }
}