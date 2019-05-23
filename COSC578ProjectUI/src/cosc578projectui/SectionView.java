package cosc578projectui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class SectionView extends JFrame implements ActionListener {
	//Initializing Components
    JLabel lb, lb1, lb2, lb3, lb4, lb5;
    JTextField tf5;
    JTextArea tf4;
    JTable table;
    JButton btn;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
 
    //Creating Constructor for initializing JFrame components
    SectionView() {
        
        //Providing Title
        super("Fetching Section Information");
        
        lb5 = new JLabel("Enter Section ID:");
        lb5.setBounds(20, 50, 200, 20);
        tf5 = new JTextField(20);
        tf5.setBounds(210, 50, 250, 20);
 
        btn = new JButton("Submit");
        btn.setBounds(20, 80, 100, 20);
        button1 = new JButton("Classroom");
        button1.setBounds(0, 0, 100, 20);
        button2 = new JButton("Employee");
        button2.setBounds(100, 0, 100, 20);
        button3 = new JButton("Student");
        button3.setBounds(200, 0, 100, 20);
        button4 = new JButton("Section");
        button4.setBounds(300, 0, 100, 20);
        button5 = new JButton("Subsection");
        button5.setBounds(400, 0, 100, 20);
        button6 = new JButton("Skills");
        button6.setBounds(500, 0, 100, 20);
        button7 = new JButton("Legal Guardian");
        button7.setBounds(600, 0, 100, 20);
        
        
        btn.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
 
        lb = new JLabel("Section Info:");
        lb.setBounds(300, 110, 450, 30);
        lb.setForeground(Color.red);
        lb.setFont(new Font("Serif", Font.BOLD, 20));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
 
        tf4 = new JTextArea(5, 20);
        tf4.setBounds(100, 150, 500, 500);
        JScrollPane scrollpane = new JScrollPane(tf4);
        setLayout(null);
 
        //Add components to the JFrame
        add(lb5);
        add(tf5);
        add(tf4);
        add(btn);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        add(button7);
        add(lb);
        add(lb1);
        add(lb2);
        add(lb3);
        add(lb4);
        add(table);
        add(scrollpane);
    }
 
    public void actionPerformed(ActionEvent e) {
        //Create DataBase Connection and Fetching Records
        if(e.getActionCommand().equals("Classroom"))
        {
            ClassroomView obj = new ClassroomView();
            obj.setVisible(true);
            //obj.setSize(400,400);
            //obj.setTitle("New");
            this.setVisible(false);
        }
        if(e.getActionCommand().equals("Employee"))
        {
            Employee emp = new Employee();
            emp.setVisible(true);
            //obj.setSize(400,400);
            //obj.setTitle("New");
            this.setVisible(false);
        }
        if(e.getActionCommand().equals("Student"))
        {
            StudentView stud = new StudentView();
            stud.setVisible(true);
            //obj.setSize(400,400);
            //obj.setTitle("New");
            this.setVisible(false);
        }
        if(e.getActionCommand().equals("Section"))
        {
            SectionView sec = new SectionView();
            sec.setVisible(true);
            //obj.setSize(400,400);
            //obj.setTitle("New");
            this.setVisible(false);
        }
        if(e.getActionCommand().equals("Subsection"))
        {
            SubsectionView sub = new SubsectionView();
            sub.setVisible(true);
            //obj.setSize(400,400);
            //obj.setTitle("New");
            this.setVisible(false);
        }
        if(e.getActionCommand().equals("Skills"))
        {
           SkillsView skill = new SkillsView();
            skill.setVisible(true);
            //obj.setSize(400,400);
            //obj.setTitle("New");
            this.setVisible(false);
        }
        if(e.getActionCommand().equals("Legal Guardian"))
        {
            GuardianView guard = new GuardianView();
            guard.setVisible(true);
            //obj.setSize(400,400);
            //obj.setTitle("New");
            this.setVisible(false);
        }
        
        try {
            String str = tf5.getText();
 
            String url = "jdbc:mysql://triton:3360/mriver15db";
            String username = "mriver15";
            String password = "Cosc*yprd";
            Connection con = DriverManager.getConnection( url, username, password );
            PreparedStatement st = con.prepareStatement("SELECT s.FNAME, t.FNAME , ss.NAME from CLASSROOM_TEACHER t INNER JOIN CLASSROOM c on c.responsible = t.CT_SSN INNER JOIN SUB_SECTION ss on s.CLASSROOM_NO = c.NUMBER INNER JOIN STUDENT s on s.MAIN_CLASSROOM = c.NUMBER where c.number = ?;");
            st.setInt(1, Integer.getInteger(str));

 
            //Excuting Query
            ResultSet rs = st.executeQuery();
            
            if (rs.wasNull()) {
                JOptionPane.showMessageDialog(null, "Secton not Found");
            }
 
            String res = "";

            while (rs.next())
            {
                String s = rs.getString(1);
                String s1 = rs.getString(2);
                String s2 = rs.getString(3);
                res += s + " " + s1 + " " + s2 + "\n";
 
            }
            tf4.setText(res);
            tf4.setEditable(false);
            } catch (Exception ex) {
 
            System.out.println(ex);
        }
    }
//Running Constructor

}
