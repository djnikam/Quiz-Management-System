import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


class Admin_homepage1 extends JFrame {

    Connection con = null;
    JTabbedPane tp;
    JPanel p1,p2,p3,p4,p5,p6;
    JTextField stud_id,stud_password,stud_name,stud_username,stud_rollno,del_stu,del_teach;
    JTextField t_id,t_name,t_username,t_password;
    JLabel j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11;

    Admin_homepage1(int admin_id,String admin_name)
    {
        con = (Connection) Db.dbconnect();
        setTitle("Admin Homepage");
        setLocation(280,120);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.lightGray);
        Font fo = new Font("Times New Roman", Font.ITALIC, 40);
        Font fo1 = new Font("Times New Roman", Font.PLAIN, 30);
        Font fo2 = new Font("Times New Roman", Font.PLAIN, 18);
        Font fo3 = new Font("Sitka Display", Font.BOLD, 15);

        ImageIcon i1 = new ImageIcon("Images/logo.png");
        setIconImage(i1.getImage());

        JPanel panel1 = new JPanel();
        panel1.setBounds(0,0,250,560);
        panel1.setLayout(null);
        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel1.setBackground(Color.cyan);
        add(panel1);

        JLabel prof_img = new JLabel();
        prof_img.setIcon(new ImageIcon("D:\\Desktop\\Quiz_Management_System - Copy\\Images\\Admin.jpg"));
        prof_img.setBounds(10, 10, 250, 100);
        prof_img.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(prof_img);

        JLabel pan_name = new JLabel("Name   :");
        pan_name.setFont(fo3);
        pan_name.setBounds(5,120,80,30);
        panel1.add(pan_name);

        JLabel prof_name = new JLabel(admin_name);
        prof_name.setFont(fo3);
        prof_name.setBounds(75,120,215,30);
        panel1.add(prof_name);

        JLabel pan_roll = new JLabel("ID Num:");
        pan_roll.setFont(fo3);
        pan_roll.setBounds(5,160,80,30);
        panel1.add(pan_roll);

        JLabel prof_roll = new JLabel(String.valueOf(admin_id));
        prof_roll .setFont(fo3);
        prof_roll .setBounds(75,160,215,30);
        panel1.add(prof_roll );

        p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(255,204,229));

        p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(238,232,170));

        p3=new JPanel();
        p3.setLayout(null);
        p3.setBackground(new Color(255,20,147));

        p4=new JPanel();
        p4.setLayout(null);
        p4.setBackground(new Color(210,105,30));

        p5=new JPanel();
        p5.setLayout(null);
        p5.setBackground(new Color(255,105,180));

        p6=new JPanel();
        p6.setLayout(null);
        p6.setBackground(new Color(230,230,250));

        tp=new JTabbedPane();
        tp.setBounds(251,0,530,560);
        tp.add("Stu_Info",p1);
        tp.add("Teach_info",p2);
        tp.add("Add_Stu",p3);
        tp.add("Delete_Stu",p4);
        tp.add("Add Teacher",p5);
        tp.add("Delete Teacher",p6);
        add(tp);


        JButton b1=new JButton("Show_Student_info");
        b1.setBounds(30,30,160,40);
        //b1.setFont(fo2);
        p1.add(b1);

        JButton b2=new JButton("Show_Teacher_info");
        b2.setBounds(30,30,160,40);
        p2.add(b2);

        //Add Student
        JButton b3=new JButton("Add Student");
        b3.setBounds(190,340,120,50);
        p3.add(b3);


        j1=new JLabel("Student Id :");
        j1.setBounds(50,40,120,40);
        p3.add(j1);

        stud_id=new JTextField();
        stud_id.setBounds(190,40,180,40);
        p3.add(stud_id);

        j2=new JLabel("Roll no :");
        j2.setBounds(50,100,120,40);
        p3.add(j2);

        stud_rollno=new JTextField();
        stud_rollno.setBounds(190,100,180,40);
        p3.add(stud_rollno);

        j3=new JLabel("Student Name:");
        j3.setBounds(50,160,120,40);
        p3.add(j3);

        stud_name=new JTextField();
        stud_name.setBounds(190,160,180,40);
        p3.add(stud_name);


        j4=new JLabel("Username :");
        j4.setBounds(50,220,120,40);
        p3.add(j4);

        stud_username=new JTextField();
        stud_username.setBounds(190,220,180,40);
        p3.add(stud_username);

        j5=new JLabel("Password :");
        j5.setBounds(50,280,120,40);
        p3.add(j5);

        stud_password=new JTextField();
        stud_password.setBounds(190,280,180,40);
        p3.add(stud_password);

        //Delete Student
        JButton b4=new JButton("Delete Student");
        b4.setBounds(190,100,150,50);
        p4.add(b4);

        j6=new JLabel("Student Id :");
        j6.setBounds(50,40,120,40);
        p4.add(j6);

        del_stu=new JTextField();
        del_stu.setBounds(190,40,180,40);
        p4.add(del_stu);

        //Add Teacher

        JButton b5=new JButton("Add Teacher");
        b5.setBounds(190,280,180,40);
        p5.add(b5);

        j7=new JLabel("Teacher Id :");
        j7.setBounds(50,40,120,40);
        p5.add(j7);

        t_id=new JTextField();
        t_id.setBounds(190,40,180,40);
        p5.add(t_id);


        j8=new JLabel("Teacher Name:");
        j8.setBounds(50,100,120,40);
        p5.add(j8);

        t_name=new JTextField();
        t_name.setBounds(190,100,180,40);
        p5.add(t_name);


        j9=new JLabel("Username :");
        j9.setBounds(50,160,120,40);
        p5.add(j9);

        t_username=new JTextField();
        t_username.setBounds(190,160,180,40);
        p5.add(t_username);

        j10=new JLabel("Password :");
        j10.setBounds(50,220,120,40);
        p5.add(j10);

        t_password=new JTextField();
        t_password.setBounds(190,220,180,40);
        p5.add(t_password);

        //Delete Teacher

        JButton b6=new JButton("Delete Teacher");
        b6.setBounds(190,100,150,50);
        p6.add(b6);

        j11=new JLabel("Teacher Id :");
        j11.setBounds(50,40,120,40);
        p6.add(j11);

        del_teach=new JTextField();
        del_teach.setBounds(190,40,180,40);
        p6.add(del_teach);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String[][] rowData={{"Student id","Student Rollno","Student name","username","Marks"}};
                    String[] ColName={"Student id","Student Rollno","Student name","username","Marks"};
                    final DefaultTableModel model=new DefaultTableModel(rowData,ColName);
                    final JTable table=new JTable(model);
                    table.setBounds(30,100,400,200);
                    table.setRowHeight(20);
                    table.getColumnModel().getColumn(0).setPreferredWidth(5);
                    table.getColumnModel().getColumn(1).setPreferredWidth(20);
                    table.getColumnModel().getColumn(3).setPreferredWidth(25);
                    table.getColumnModel().getColumn(4).setPreferredWidth(5);
                    table.setOpaque(true);
                    JTableHeader header1 = table.getTableHeader();
                    header1.setOpaque(true);
                    header1.setBackground(Color.gray);
                    table.setBorder((BorderFactory.createLineBorder(Color.BLACK,1)));
                    ScrollPane s = new ScrollPane();
                    s.setBounds(10,100,500,100);
                    s.add(table);
                    p1.add(s);

                    PreparedStatement pst= (PreparedStatement)con.prepareStatement("select * from student_login");
                    ResultSet r = pst.executeQuery();

                    while (r.next())
                    {
                        String id=String.valueOf(r.getInt("Stu_id"));
                        String Stu_rollno = String.valueOf(r.getInt("stu_rollno"));
                        String Stu_name=r.getString("stu_name");
                        String Stu_username=r.getString("stu_username");
                        String Stu_marks = String.valueOf(r.getInt("marks"));

                        String tbData[]={id,Stu_rollno,Stu_name,Stu_username,Stu_marks};
                        model.addRow(tbData);

                    }

                }catch (Exception d)
                {
                    System.out.println(d);
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String[][] rowData={{"Teacher id","Teacher name","Teacher username"}};
                    String[] ColName={"Teacher id","Teacher name","Teacher username"};
                    final DefaultTableModel model=new DefaultTableModel(rowData,ColName);
                    final JTable table2=new JTable(model);
                    table2.setBounds(30,10,50,100);
                    table2.setBorder((BorderFactory.createLineBorder(Color.BLACK,1)));
                    ScrollPane sp = new ScrollPane();
                    sp.setBounds(30,100,400,100);
                    sp.add(table2);
                    p2.add(sp);
                    PreparedStatement pst= (PreparedStatement)con.prepareStatement("select * from teacher_login");
                    ResultSet r = pst.executeQuery();

                    while (r.next())
                    {
                        String id=String.valueOf(r.getInt("teach_id"));
                        String tea_name=r.getString("teach_name");
                        String tea_username=r.getString("teach_username");

                        String tbData[]={id,tea_name,tea_username};
                        model.addRow(tbData);

                    }

                }catch (Exception d)
                {
                    System.out.println(d);
                }
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int p1 = JOptionPane.showConfirmDialog(null,"Are you confirm to add Student data?","Confirm",JOptionPane.YES_NO_OPTION);
                if(p1==0)
                {
                    try {
                        String sql="insert into student_login(stu_id,stu_rollno,stu_name,stu_username,stu_password) values (?,?,?,?,?)";
                        PreparedStatement pst= (PreparedStatement)con.prepareStatement(sql);
                        pst.setInt(1,Integer.parseInt(stud_id.getText()));
                        pst.setInt(2,Integer.parseInt(stud_rollno.getText()));
                        pst.setString(3,stud_name.getText());
                        pst.setString(4,stud_username.getText());
                        if(stud_password.getText().equals(""))
                        {
                            pst.setString(5,"1234");            //Default Password 1234
                        }
                        else
                        {
                            pst.setString(5,stud_password.getText());
                        }
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Student Data Inserted Successfully.");
                        clearField1();

                    }catch (Exception e1)
                    {
                        JOptionPane.showMessageDialog(null,e1);
                        System.out.println(e1);
                    }
                }
                clearField1();
            }
        });


        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int p2 = JOptionPane.showConfirmDialog(null,"Do you really want to delete Student with id :"+Integer.parseInt(del_stu.getText())+"","Delete",JOptionPane.YES_NO_OPTION);
                if(p2==0)
                {
                    try{
                        String sql="delete from student_login where stu_id=?";
                        PreparedStatement pst1= (PreparedStatement)con.prepareStatement(sql);
                        pst1.setInt(1,Integer.parseInt(del_stu.getText()));
                        pst1.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Student no:"+Integer.parseInt(del_stu.getText())+" is Deleted Successfully");
                        clearField1();
                    }catch (Exception e2)
                    {
                        System.out.println(e2);
                    }
                }
                clearField1();
            }
        });

        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int p1 = JOptionPane.showConfirmDialog(null,"Are you confirm to add Teacher Data?","Confirm",JOptionPane.YES_NO_OPTION);
                if(p1==0)
                {
                    try {
                        String sql="insert into teacher_login (teach_id,teach_name,teach_username,teach_password) values (?,?,?,?)";
                        PreparedStatement pst= (PreparedStatement)con.prepareStatement(sql);
                        pst.setInt(1,Integer.parseInt(t_id.getText()));
                        pst.setString(2,t_name.getText());
                        pst.setString(3,t_username.getText());
                        if(t_password.getText().equals(""))
                        {
                            pst.setString(4,"Teach@123");          //Default Password
                        }
                        else
                        {
                            pst.setString(4,t_password.getText());
                        }

                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Teacher Data Inserted Successfully.");
                        clearField1();

                    }catch (Exception e1)
                    {
                        JOptionPane.showMessageDialog(null,e1);
                        System.out.println(e1);
                    }
                }
                clearField1();
            }
        });

        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int p2 = JOptionPane.showConfirmDialog(null,"Do you really want to delete Teache with id :"+Integer.parseInt(del_teach.getText())+"","Delete",JOptionPane.YES_NO_OPTION);
                if(p2==0)
                {
                    try{
                        String sql="delete from teacher_login where teach_id=?";
                        PreparedStatement pst1= (PreparedStatement)con.prepareStatement(sql);
                        pst1.setInt(1,Integer.parseInt(del_teach.getText()));
                        pst1.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Teacher id:"+Integer.parseInt(del_teach.getText())+" is Deleted Successfully");
                        clearField1();
                    }catch (Exception e2)
                    {
                        System.out.println(e2);
                    }
                }
                clearField1();

            }
        });
        setVisible(true);
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void clearField1()
    {
        stud_id.setText(null);
        stud_rollno.setText(null);
        stud_name.setText(null);
        stud_username.setText(null);
        stud_password.setText(null);
        del_stu.setText(null);
        t_id.setText(null);
        t_name.setText(null);
        t_username.setText(null);
        t_password.setText(null);
        del_teach.setText(null);
    }

}

public class Admin_homepage {

    public static void main(String[] args) {

        int admin_id=10;
        String admin_name="";
        Admin_homepage1 a1 = new Admin_homepage1(admin_id,admin_name);
        a1.setSize(800, 600);

    }
}