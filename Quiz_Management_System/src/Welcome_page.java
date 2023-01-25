import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


class Welcome_page1 extends JFrame {
        Welcome_page1() throws IOException {
            setTitle("Quiz Management System");
            setLocation(380,120);
            setLayout(null);
            setResizable(false);
            setContentPane(new JLabel(getImage()));
            Font fo = new Font("Times New Roman Bold", Font.PLAIN, 40);
            Font fo1 = new Font("Times New Roman Bold", Font.PLAIN, 30);
            Font fo2 = new Font("Times New Roman", Font.PLAIN, 18);


            ImageIcon i1 = new ImageIcon("Images/logo.png");
            setIconImage(i1.getImage());
            JLabel stu = new JLabel("Welcome ");
            stu.setBounds(80, 1, 200, 100);
            stu.setFont(fo);
            add(stu);

            JLabel j1 = new JLabel("Quiz Management System");
            j1.setFont(fo1);
            j1.setBounds(80, 70, 400, 100);
            add(j1);

            JLabel quiz_img = new JLabel();
            quiz_img.setIcon(new ImageIcon("D:\\Desktop\\Quiz_Management_System - Copy\\Images\\Quiz.jpg"));
            quiz_img.setBounds(80, 180, 360, 180);
            add(quiz_img);


            JButton b1 = new JButton("Student");
            b1.setFont(fo2);
            b1.setBounds(200, 400, 100, 40);
            add(b1);

            JButton b2 = new JButton("Teacher");
            b2.setFont(fo2);
            b2.setBounds(330, 400, 100, 40);
            add(b2);

            JButton b3 = new JButton("Admin");
            b3.setFont(fo2);
//            b3.setBorderPainted(false);
            b3.setBounds(460, 400, 100, 40);
            add(b3);

            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    dispose();
                    Student_login1 s1 = null;
                    try {
                        s1 = new Student_login1();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    s1.setVisible(true);
                    s1.setSize(800,600);
                }
            });

            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    Teacher_login1 t1= null;
                    try {
                        t1 = new Teacher_login1();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    t1.setVisible(true);
                    t1.setSize(800, 600);
                }
            });

            b3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    Admin_login1 a1= null;
                    try {
                        a1 = new Admin_login1();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    a1.setVisible(true);
                    a1.setSize(800, 600);
                }
            });


            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    static ImageIcon getImage() throws IOException {
        BufferedImage img = ImageIO.read(new File("D:\\Desktop\\Quiz_Management_System - Copy\\Images\\Q_bg.jpg"));
        Image scaled = img.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaled);
        return icon;
    }

}

public class Welcome_page {

    public static void main(String[] args) throws IOException {

        Welcome_page1 w1 = new Welcome_page1();
        w1.setSize(800, 600);
    }
}
