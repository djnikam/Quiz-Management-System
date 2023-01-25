import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLOutput;


class Teacher_homepage1 extends JFrame {


    Connection con = null;
    JButton b1,b2,b3;
    JTextField Que_no,Question,opt1,opt2,opt3,opt4,ans,Que_num;
    JPanel p1,p2,p3,p4;

    Teacher_homepage1(int tea_id,String tea_name)
    {
        con = (Connection) Db.dbconnect();

        setTitle("Teacher Homepage");
        setLocation(280,120);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.lightGray);
        Font fo = new Font("Times New Roman", Font.ITALIC, 40);
        Font fo1 = new Font("Times New Roman", Font.PLAIN, 30);
        Font fo2 = new Font("Times New Roman", Font.PLAIN, 18);
        Font fo3 = new Font("Sitka Display", Font.BOLD, 15);

        JPanel panel1 = new JPanel();
        panel1.setBounds(0,0,250,560);
        panel1.setLayout(null);
        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        panel1.setBackground(new Color(127,255,212));
        add(panel1);

        JLabel prof_img = new JLabel();
        prof_img.setIcon(new ImageIcon("D:\\Desktop\\Quiz_Management_System - Copy\\Images\\teacher.png"));
        prof_img.setBounds(10, 10, 250, 100);
        prof_img.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(prof_img);

        JLabel pan_name = new JLabel("Name   :");
        pan_name.setFont(fo3);
        pan_name.setBounds(5,120,80,30);
        panel1.add(pan_name);

        JLabel prof_name = new JLabel(tea_name);
        prof_name.setFont(fo3);
        prof_name.setBounds(75,120,215,30);
        panel1.add(prof_name);

        JLabel pan_roll = new JLabel("ID Num:");
        pan_roll.setFont(fo3);
        pan_roll.setBounds(5,160,80,30);
        panel1.add(pan_roll);

        JLabel prof_roll = new JLabel(String.valueOf(tea_id));
        prof_roll .setFont(fo3);
        prof_roll .setBounds(75,160,215,30);
        panel1.add(prof_roll );

        p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(255,182,193));

        p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(238,232,170));

        p3=new JPanel();
        p3.setBackground(new Color(152,251,152));
        p3.setLayout(null);

        p4=new JPanel();
        p4.setBackground(new Color(255,228,225));
        p4.setLayout(null);

        JTabbedPane tp=new JTabbedPane();
        tp.setBounds(251,0,530,560);
        tp.add("Create Quiz",p1);
        tp.add("Delete Questions",p2);
        tp.add("Delete Quiz",p3);
        tp.add("Student Information",p4);
        add(tp);

        b1=new JButton("Create Quiz");
        b1.setBounds(190,460,120,50);
        p1.add(b1);

        b2=new JButton("Delete Question");
        b2.setBounds(190,100,150,50);
        p2.add(b2);

        b3=new JButton("Delete Quiz");
        b3.setBounds(190,100,150,50);
        p3.add(b3);

        JLabel l1=new JLabel("Question No :");
        l1.setBounds(50,40,120,40);
        p1.add(l1);

        Que_no=new JTextField();
        Que_no.setBounds(190,40,180,40);
        p1.add(Que_no);

        JLabel l2=new JLabel("Question :");
        l2.setBounds(50,100,120,40);
        p1.add(l2);

        Question=new JTextField();
        Question.setBounds(190,100,180,40);
        p1.add(Question);

        JLabel o1=new JLabel("Option 1 :");
        o1.setBounds(50,160,120,40);
        p1.add(o1);

        opt1=new JTextField();
        opt1.setBounds(190,160,180,40);
        p1.add(opt1);

        JLabel o2=new JLabel("Option 2 :");
        o2.setBounds(50,220,120,40);
        p1.add(o2);

        opt2=new JTextField();
        opt2.setBounds(190,220,180,40);
        p1.add(opt2);

        JLabel o3=new JLabel("Option 3 :");
        o3.setBounds(50,280,120,40);
        p1.add(o3);

        opt3=new JTextField();
        opt3.setBounds(190,280,180,40);
        p1.add(opt3);

        JLabel o4=new JLabel("Option 4 :");
        o4.setBounds(50,340,120,40);
        p1.add(o4);

        opt4=new JTextField();
        opt4.setBounds(190,340,180,40);
        p1.add(opt4);

        JLabel Answer=new JLabel("Answer :");
        Answer.setBounds(50,400,120,40);
        p1.add(Answer);

        ans=new JTextField();
        ans.setBounds(190,400,180,40);
        p1.add(ans);

// Delete Questions Tab

        JLabel l5=new JLabel("Question No :");
        l5.setBounds(50,40,120,40);
        p2.add(l5);

        Que_num=new JTextField();
        Que_num.setBounds(190,40,180,40);
        p2.add(Que_num);

//Show Student_info

        JButton b4=new JButton("Show Student info");
        b4.setBounds(30,30,160,40);
        p4.add(b4);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int p1 = JOptionPane.showConfirmDialog(null,"Are you confirm to add Question in Quiz?","Confirm",JOptionPane.YES_NO_OPTION);
                if(p1==0)
                {
                    try {
                        String sql="insert into questions values (?,?,?,?,?,?,?)";
                        PreparedStatement pst= (PreparedStatement)con.prepareStatement(sql);
                        pst.setInt(1,Integer.parseInt(Que_no.getText()));
                        pst.setString(2,Question.getText());
                        pst.setString(3,opt1.getText());
                        pst.setString(4,opt2.getText());
                        pst.setString(5,opt3.getText());
                        pst.setString(6,opt4.getText());
                        pst.setString(7,ans.getText());

                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Data Inserted Successfully");
                        clearField();

                    }catch (Exception e1)
                    {
                        System.out.println(e1);
                    }
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int p2 = JOptionPane.showConfirmDialog(null,"Do you really want to delete Question No :"+Integer.parseInt(Que_num.getText())+"","Delete",JOptionPane.YES_NO_OPTION);
                if(p2==0)
                {
                    try{
                        String sql="delete from questions where que_no=?";
                        PreparedStatement pst1= (PreparedStatement)con.prepareStatement(sql);
                        pst1.setInt(1,Integer.parseInt(Que_num.getText()));
                        pst1.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Question no:"+Integer.parseInt(Que_num.getText())+" is Deleted Successfully");
                        clearField();
                    }catch (Exception e2)
                    {
                        System.out.println(e2);
                    }
                }
                clearField();
            }
        });


        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int p3 = JOptionPane.showConfirmDialog(null,"Do you really want to delete all Data","Delete",JOptionPane.YES_NO_OPTION);
                if(p3==0)
                {
                    try{
                        String sql="truncate table questions";
                        PreparedStatement pst2= (PreparedStatement)con.prepareStatement(sql);
                        pst2.executeUpdate();

                        JOptionPane.showMessageDialog(null,"All Data is Deleted Successfully.");
                        clearField();

                    }catch (Exception e2)
                    {
                        System.out.println(e2);
                    }
                }
            }
        });


        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String[][] rowData={{"Student id","Student Rollno","Student name","Marks"}};
                    String[] ColName={"Student id","Student Rollno","Student name","Marks"};
                    final DefaultTableModel model=new DefaultTableModel(rowData,ColName);
                    final JTable table=new JTable(model);
                    table.setBounds(30,100,400,200);
                    table.setRowHeight(20);
                    table.getColumnModel().getColumn(0).setPreferredWidth(5);
                    table.getColumnModel().getColumn(1).setPreferredWidth(20);
                    table.getColumnModel().getColumn(2).setPreferredWidth(25);
                    table.setOpaque(true);
                    JTableHeader header1 = table.getTableHeader();
                    header1.setOpaque(true);
                    header1.setBackground(Color.gray);
                    table.setBorder((BorderFactory.createLineBorder(Color.BLACK,1)));
                    ScrollPane s = new ScrollPane();
                    s.setBounds(10,100,500,100);
                    s.add(table);
                    p4.add(s);

                    PreparedStatement pst= (PreparedStatement)con.prepareStatement("select * from student_login");
                    ResultSet r = pst.executeQuery();

                    while (r.next())
                    {
                        String id=String.valueOf(r.getInt("Stu_id"));
                        String Stu_rollno = String.valueOf(r.getInt("stu_rollno"));
                        String Stu_name=r.getString("stu_name");
                        String Stu_marks = String.valueOf(r.getInt("marks"));

                        String tbData[]={id,Stu_rollno,Stu_name,Stu_marks};
                        model.addRow(tbData);

                    }

                }catch (Exception d)
                {
                    System.out.println(d);
                }
            }
        });



        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //Tp Empty the Textfield After Submit

    private void clearField()
    {
        Que_no.setText(null);
        Question.setText(null);
        opt1.setText(null);
        opt2.setText(null);
        opt3.setText(null);
        opt4.setText(null);
        ans.setText(null);
        Que_num.setText(null);
    }

}

public class Teacher_homepage {

    public static void main(String[] args) {

        int tea_id=10;
        String tea_name="";
        Teacher_homepage1 a1 = new Teacher_homepage1(tea_id,tea_name);
        a1.setSize(800, 600);

    }
}