package cafe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class Login implements ActionListener {

    public int show = 0;
    private JFrame fr;
    private JPanel p1, p2, p3, p4, p5, p6, p7;
    private JTextField usernametf1, passwordtf2;
    private JButton but;
    private JLabel label1, label2, label3, laCon;
    private String username, password;

    public Login() {
        ImageIcon icon = null;
        URL imageURL = Login.class.getResource("logo.png");
        fr = new JFrame("Login");
        if (imageURL != null) {
            icon = new ImageIcon(imageURL);
        }
        laCon = new JLabel("", icon, JLabel.CENTER);
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();
        p7 = new JPanel();
        but = new JButton("Login");
        label1 = new JLabel("Cafe Manager System", JLabel.CENTER);
        label2 = new JLabel("Username:  ", JLabel.CENTER);
        label3 = new JLabel("Password:  ", JLabel.CENTER);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        usernametf1 = new JTextField("", 15);
        passwordtf2 = new JTextField("", 15);
        
        but.addActionListener(this);
        fr.setLayout(new GridLayout(7,1));
        p1.setLayout(new BorderLayout());
        p2.setLayout(new BorderLayout());
        p3.setLayout(new FlowLayout());
        p4.setLayout(new FlowLayout());
        p5.setLayout(new FlowLayout());
        
        label1.setFont(new Font("TimesRoman", Font.BOLD, 18));
        
        fr.add(p6);
        fr.add(p1);
        fr.add(p2);
        fr.add(p3);
        fr.add(p4);
        fr.add(p5);
        fr.add(p7);
        
        
        p1.add(laCon, BorderLayout.CENTER);
        p2.add(label1, BorderLayout.CENTER);
        p3.add(new JLabel());     p3.add(label2, BorderLayout.CENTER);    p3.add(usernametf1, BorderLayout.CENTER);   p3.add(new JLabel());
        p4.add(new JLabel());     p4.add(label3, BorderLayout.CENTER);    p4.add(passwordtf2, BorderLayout.CENTER);   p4.add(new JLabel());
        p5.add(but);
        
        fr.setSize(500, 300);
        fr.setResizable(false);
        fr.setLocation(600, 450);

        fr.setResizable(false);
        fr.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        username = "username";
        password = "password";
        if ((e.getSource().equals(but))) {
            if ((username.equals(usernametf1.getText() + "")) && (password.equals(passwordtf2.getText() + ""))) {
                mainFrame m = new mainFrame(0);
                m.start();
                fr.dispose();
            } else if (!(username.equals(usernametf1.getText() + ""))) {
                JOptionPane.showMessageDialog(null, "invalid username.", "", JOptionPane.WARNING_MESSAGE);
            } else if (!(password.equals(passwordtf2.getText() + ""))) {
                JOptionPane.showMessageDialog(null, "invalid password.", "", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
