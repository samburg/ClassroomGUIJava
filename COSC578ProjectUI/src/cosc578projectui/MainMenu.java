/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc578projectui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.FlowLayout;

/**
 *
 * @author admin
 */
public class MainMenu extends JFrame implements ActionListener {
    
    
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    
    MainMenu() {
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        
        setLayout(new FlowLayout());
        
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
    }
    
    
    /*public static void main(String args[]) {

        MainMenu menu = new MainMenu();
        menu.setVisible(true);
        menu.setSize(400,400);
        menu.setTitle("Title");
    }*/
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equals("1"))
        {
            ClassroomView obj = new ClassroomView();
            obj.setVisible(true);
            //obj.setSize(400,400);
            //obj.setTitle("New");
            this.setVisible(false);
        }
        if(event.getActionCommand().equals("2"))
        {
            ClassroomView obj = new ClassroomView();
            obj.setVisible(true);
            //obj.setSize(400,400);
            //obj.setTitle("New");
            this.setVisible(false);
        }
        if(event.getActionCommand().equals("3"))
        {
            ClassroomView obj = new ClassroomView();
            obj.setVisible(true);
            //obj.setSize(400,400);
            //obj.setTitle("New");
            this.setVisible(false);
        }
        if(event.getActionCommand().equals("4"))
        {
            ClassroomView obj = new ClassroomView();
            obj.setVisible(true);
            //obj.setSize(400,400);
            //obj.setTitle("New");
            this.setVisible(false);
        }
        
          
    }
        
        //new COSC578ProjectUI();
        //COSC578ProjectUI().setVisible(false);
        //Runnable r = new Runnable() {
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // the GUI as seen by the user (without frame)
                JPanel gui = new JPanel(new BorderLayout());
                gui.setBorder(new EmptyBorder(2, 3, 2, 3));

                JPanel textPanel = new JPanel(new BorderLayout(5,5));
                textPanel.add(new JScrollPane(new JTextArea("Top Text",3,20)), 
                        BorderLayout.PAGE_START);
                textPanel.add(new JScrollPane(new JTextArea("Main Text",10,10)));
                gui.add(textPanel, BorderLayout.CENTER);

                JPanel buttonCenter = new JPanel(new GridBagLayout());
                buttonCenter.setBorder(new EmptyBorder(5,5,5,5));
                JPanel buttonPanel = new JPanel(new GridLayout(0,1,5,5));
                for (int ii=1; ii<6; ii++) {
                    buttonPanel.add(new JButton("Button " + ii));
                }
                // a component added to a GBL with no constraint will be centered
                buttonCenter.add(buttonPanel);

                gui.add(buttonCenter, BorderLayout.LINE_END);

                JFrame f = new JFrame("Demo");
                f.add(gui);
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See http://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // should be done last, to avoid flickering, moving,
                // resizing artifacts.
                f.setVisible(true);
            }
        });
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
       //SwingUtilities.invokeLater(r);*/
}
