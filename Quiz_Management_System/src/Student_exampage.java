import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;


class Student_exampage1 extends JFrame {

    JPanel p1;
    JLabel j1,j2,prof_name,totaltime_lbl,totaltime_lbl1,time_lbl,min_lbl,sec_lbl,colon_lbl,date_lbl,date_lbl1,pan_name,pan_roll,prof_roll,prof_img;
    JRadioButton b1,b2,b3,b4;
    ButtonGroup g1;
    JButton save_next,sbt,clr;
    Connection con = null;
    String answer;

    public int que_id = 1;
    public int mark = 0;
    public int min =0;
    public int sec =0;
    Timer time;
    String stu_ans ="";
    Student_exampage1(final int student_id, int roll_no, String stu_name)
    {
        con = (Connection) Db.dbconnect();
        setTitle("Student Homepage");
        setLocation(280,120);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(255,255,224));
        SimpleDateFormat d = new SimpleDateFormat("dd-M-yyyy");
        Date date = new Date();
        Font fo1 = new Font("Times New Roman", Font.BOLD, 18);
        Font fo2 = new Font("Times New Roman", Font.PLAIN, 18);
        Font fo3 = new Font("Sitka Display", Font.BOLD, 15);

        ImageIcon i1 = new ImageIcon("Images/logo.png");
        setIconImage(i1.getImage());


        p1 = new JPanel();
        p1.setBounds(0,0,300,564);
        p1.setLayout(null);
        p1.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        p1.setBackground(Color.cyan);
        add(p1);

        prof_img = new JLabel();
        prof_img.setIcon(new ImageIcon("D:\\Desktop\\Quiz_Management_System - Copy\\Images\\student.png"));
        prof_img.setBounds(10, 10, 300, 100);
        prof_img.setHorizontalAlignment(JLabel.CENTER);
        p1.add(prof_img);

        pan_name = new JLabel("Name   :");
        pan_name.setFont(fo3);
//        pan_name.setBackground(Color.BLACK);
//        pan_name.setForeground(Color.WHITE);
//        pan_name.setOpaque(true);
        pan_name.setBounds(5,120,70,30);
        p1.add(pan_name);

        prof_name = new JLabel(stu_name);
        prof_name.setFont(fo3);
//        prof_name.setBackground(Color.red);
//        prof_name.setForeground(Color.cyan);
//        prof_name.setOpaque(true);
        prof_name.setBounds(75,120,225,30);
//        prof_name.setHorizontalAlignment(JLabel.CENTER);
        p1.add(prof_name);

        pan_roll = new JLabel("Roll no:");
        pan_roll.setFont(fo3);
        pan_roll.setBounds(5,160,70,30);
        p1.add(pan_roll);

        prof_roll = new JLabel(String.valueOf(roll_no));
        prof_roll .setFont(fo3);
        prof_roll .setBounds(75,160,225,30);
        p1.add(prof_roll );

        date_lbl= new JLabel("Date    :");
        date_lbl.setBounds(5,200,70,30);
        date_lbl.setFont(fo3);
        p1.add(date_lbl);

        date_lbl1= new JLabel();
        date_lbl1.setText(d.format(date));
        date_lbl1.setBounds(75,200,225,30);
        date_lbl1.setFont(fo3);
        p1.add(date_lbl1);

        totaltime_lbl= new JLabel("Time   :");
        totaltime_lbl.setBounds(5,240,70,30);
        totaltime_lbl.setFont(fo3);
        p1.add(totaltime_lbl);

        totaltime_lbl1= new JLabel("30 Min");
        totaltime_lbl1.setBounds(75,240,225,30);
        totaltime_lbl1.setFont(fo3);
        p1.add(totaltime_lbl1);

        j1=new JLabel("Question ?");
        j1.setFont(fo1);
        j1.setBounds(400,100,400,60);
        add(j1);

        j2=new JLabel("Oue_no. ?");
        j2.setBounds(340,120,50,20);
        j2.setFont(fo1);
        j2.setBackground(Color.blue);
        add(j2);

        time_lbl = new JLabel("Time Taken:");
        time_lbl.setBounds(700,10,110,50);
        time_lbl.setForeground(Color.BLACK);
        time_lbl.setFont(fo1);
        add(time_lbl);


        min_lbl = new JLabel();                                   //min
        min_lbl.setBounds(810,10,20,50);
        min_lbl.setForeground(Color.RED);
        min_lbl.setFont(fo1);
        add(min_lbl);

        colon_lbl = new JLabel(":");                                  //colon
        colon_lbl.setBounds(831,10,10,50);
        colon_lbl.setForeground(Color.RED);
        colon_lbl.setFont(fo1);
        add(colon_lbl);

        sec_lbl = new JLabel();                                  //Sec
        sec_lbl.setBounds(841,10,20,50);
        sec_lbl.setForeground(Color.RED);
        sec_lbl.setFont(fo1);
        add(sec_lbl);

        time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                min_lbl.setText(String.valueOf(min));
                sec_lbl.setText(String.valueOf(sec));
                if(sec==10)
                {
                    sec =0;
                    min++;
                    if(min==2) {
                        time.stop();
                        try {
                            answercheck(que_id,answer);
                            Statement st1 = con.createStatement();
                            st1.executeUpdate("update student_login set marks='"+mark+"'where stu_id="+student_id+"");
                            JOptionPane.showMessageDialog(null,"Times Up!!!!! Your Marks in Exam :"+mark+" out of 15.");
                            Welcome_page1 w1 = new Welcome_page1();
                            w1.setSize(800, 600);
                            setVisible(false);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                sec++;
            }
        });

        g1=new ButtonGroup();


        b1=new JRadioButton("Option1");
        b1.setBackground(new Color(255,255,224));
        b1.setFont(fo2);
        b1.setBounds(400,170,150,20);
        add(b1);

        b2=new JRadioButton("Option2");
        b2.setBackground(new Color(255,255,224));
        b2.setFont(fo2);
        b2.setBounds(400,240,150,20);
        add(b2);

        b3=new JRadioButton("Option3");
        b3.setBackground(new Color(255,255,224));
        b3.setFont(fo2);
        b3.setBounds(400,310,150,20);
        add(b3);

        b4=new JRadioButton("Option4");
        b4.setBackground(new Color(255,255,224));
        b4.setFont(fo2);
        b4.setBounds(400,380,150,20);
        add(b4);

        g1.add(b1);
        g1.add(b2);
        g1.add(b3);
        g1.add(b4);

        clr=new JButton("Clear selection");
        clr.setBounds(570,500,120,30);

        add(clr);

        save_next=new JButton("Save & next");
        save_next.setBounds(710,500,120,30);
        add(save_next);


        sbt=new JButton("Submit");
        sbt.setBounds(850,500,100,30);
        add(sbt);




        time.start();
        try {
            PreparedStatement pst= (PreparedStatement)con.prepareStatement("select * from questions where que_no="+que_id+"");
            ResultSet r = pst.executeQuery();
            while (r.next())
            {
                j2.setText("Q."+r.getString(1)+")");
                j1.setText(r.getString(2));
                b1.setText(r.getString(3));
                b2.setText(r.getString(4));
                b3.setText(r.getString(5));
                b4.setText(r.getString(6));
                answer=r.getString(7);
                answercheck(que_id,answer);
            }

        }catch (Exception e1)
        {
            System.out.println(e1);
        }

        save_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PreparedStatement pst= (PreparedStatement)con.prepareStatement("select * from questions where que_no="+(que_id+1)+"");
                    ResultSet r = pst.executeQuery();
                    while (r.next())
                    {

                        answercheck(que_id,answer);
                        g1.clearSelection();
                        j2.setText("Q."+r.getString(1)+")");
                        j1.setText(r.getString(2));
                        b1.setText(r.getString(3));
                        b2.setText(r.getString(4));
                        b3.setText(r.getString(5));
                        b4.setText(r.getString(6));
                        answer=r.getString(7);
                        que_id+=1;
                    }

                }catch (Exception e1)
                {
                    System.out.println(e1);
                }
            }
        });

        submit(student_id);    //SUb
        // mit Function Call

        clr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g1.clearSelection();
            }
        });

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void submit(final int student_id)
    {

        sbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int p1 = JOptionPane.showConfirmDialog(null,"Do you Really want to submit the Exam?"+answer+""+mark,"Confirm",JOptionPane.YES_NO_OPTION);
                if(p1==0) {
                    try {
                        answercheck(que_id,answer);
                        Statement st = con.createStatement();
                        st.executeUpdate("update student_login set marks='"+mark+"'where stu_id="+student_id+"");
                        JOptionPane.showMessageDialog(null,"Marks in Exam :"+mark+" out of 15.");
                        System.exit(0);
                        setVisible(false);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }


    public void answercheck(int q_num,String ans)
    {
        if(b1.isSelected())
        {
            stu_ans = b1.getText();
        }
        else if(b2.isSelected())
        {
            stu_ans = b2.getText();
        }
        else if(b3.isSelected())
        {
            stu_ans = b3.getText();
        }
        else if(b4.isSelected())
        {
            stu_ans = b4.getText();
        }

        if(stu_ans.equals(ans))
        {
            mark++;
        }

        if(q_num == 14)
            save_next.setVisible(false);
    }

}

public class Student_exampage {

    public static void main(String[] args) {

        int student_id=0,roll_no=10;
        String stu_name="";
        Student_exampage1 h1 = new Student_exampage1(student_id,roll_no,stu_name);
        h1.setSize(1000, 600);

    }
}