/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class Login implements ActionListener {

    private JFrame fr;
    private JPanel pl, pl2, pl3;
    private JTextField usernametf1, passwordtf2;
    private JButton but;
    private JLabel label1, label2, label3, laCon;

    public Login() {
        ImageIcon icon = null;
        URL imageURL = Login.class.getResource("icon.jpg");
        fr = new JFrame("Login");
        if (imageURL != null) {
            icon = new ImageIcon(imageURL);
        }
        laCon = new JLabel("", icon, JLabel.CENTER);
        pl = new JPanel();
        pl2 = new JPanel();
        pl3 = new JPanel();
        but = new JButton("Login");
        label1 = new JLabel("Cafe Manager System",  JLabel.CENTER);
        label2 = new JLabel("Username:",  JLabel.CENTER);
        label3 = new JLabel("Password:",  JLabel.CENTER);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        usernametf1 = new JTextField("", 15);
        passwordtf2 = new JTextField("", 15);
        but.addActionListener(this);
        pl2.setLayout(new GridLayout(4, 1));
        pl3.setLayout(new FlowLayout());
        pl.setLayout(new GridLayout(2, 2));
        pl.add(label2);
        pl.add(usernametf1);
        pl.add(label3);
        pl.add(passwordtf2);
        pl2.add(laCon);
        pl2.add(label1);
        pl2.add(pl);
        pl3.add(but);
        pl2.add(pl3);
        fr.add(pl2);
        
                
        fr.setSize(500, 300);
        fr.setLocation(600, 450);

        fr.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
