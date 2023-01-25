import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class Admin_login1 extends JFrame {

    JTextField user, password;
    JLabel adm;
    Connection con = null;
    public int ad_id;
    public String ad_name;
    Admin_login1() throws IOException {

        con = (Connection) Db.dbconnect();
        setTitle("Admin Login");
        setLocation(380,120);
        setLayout(null);
        setResizable(false);
//        getContentPane().setBackground(Color.LIGHT_GRAY);
        setContentPane(new JLabel(getImage()));

        Font fo = new Font("Times New Roman", Font.BOLD, 30);
        Font fo1 = new Font("Times New Roman", Font.PLAIN, 18);


        ImageIcon i1 = new ImageIcon("Images/logo.png");
        setIconImage(i1.getImage());

        adm = new JLabel("Admin Login ");
        adm.setBounds(310, 1, 200, 100);
        adm.setForeground(Color.RED);
        adm.setFont(fo);
        add(adm);


        JLabel Adm_img = new JLabel();
        Adm_img.setIcon(new ImageIcon("D:\\Desktop\\Quiz_Management_System\\Images\\Admin.jpg"));
        Adm_img.setBounds(355, 90, 200, 100);
        add(Adm_img);

//        ImageIcon i2 =new ImageIcon();
//        setIconImage(i2.getImage());

        JLabel j1 = new JLabel("User Name :");
        j1.setBounds(300, 200, 100, 40);
//        j1.setForeground(Color.WHITE);
        j1.setFont(fo1);
        add(j1);


        JLabel j2 = new JLabel("Password :");
        j2.setBounds(300, 300, 100, 40);
        j2.setFont(fo1);
        add(j2);

        user = new JTextField();
        user.setBounds(400, 200, 120, 40);
        add(user);

        password = new JPasswordField();
        password.setBounds(400, 300, 120, 40);
        add(password);


        JButton b1 = new JButton("Login");
        b1.setFont(fo1);
        b1.setBounds(300, 380, 100, 40);
        add(b1);

        JButton b2 = new JButton("Back");
        b2.setFont(fo1);
        b2.setBounds(420, 380, 100, 40);
        add(b2);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String adm_usr= user.getText();
                    String adm_pwd=String.valueOf(password.getText());
                    PreparedStatement pst= (PreparedStatement)con.prepareStatement("select * from Admin_login where adm_username =? and adm_password=?");
                    pst.setString(1,adm_usr);
                    pst.setString(2,adm_pwd);
                    ResultSet r = pst.executeQuery();
                    if(r.next())
                    {
                        ad_id = r.getInt("ad_id");
                        ad_name = r.getString("adm_name");
                        JOptionPane.showMessageDialog(null,"Login Successfull.");
                        dispose();
                        Admin_homepage1 h1 = new Admin_homepage1(ad_id,ad_name);
                        h1.setSize(800, 600);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Invalid Username or Password!");
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
        BufferedImage img = ImageIO.read(new File("D:\\Desktop\\Quiz_Management_System - Copy\\Images\\adm_bg.jpg"));
        Image scaled = img.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaled);
        return icon;
    }
}

public class Admin_login {

    public static void main(String args[]) throws IOException {

            Admin_login1 a=new Admin_login1();
            a.setSize(800, 600);
    }

}