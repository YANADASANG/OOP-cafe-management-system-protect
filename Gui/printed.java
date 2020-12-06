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

public class printed implements ActionListener{
    private JFrame fr;
    private JPanel pl;
    private JLabel label;
    private JButton but;
    public printed(){
        fr = new JFrame("");
        pl = new JPanel();
        but = new JButton("Back");
        but.addActionListener(this);
        label = new JLabel("Printing Complete!", JLabel.CENTER);
        label.setFont(new Font("", Font.PLAIN, 20));
        fr.setLayout(new GridLayout(2, 1));
        fr.add(label);
        pl.setLayout(new FlowLayout());
        pl.add(but);
        fr.add(pl);
        fr.setSize(400, 200);
        fr.setLocation(800, 450);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fr.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fr.dispose();
        new mainFrame();
    }
}
