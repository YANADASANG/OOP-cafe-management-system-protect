/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import javax.swing.*;

public class Bill implements WindowListener{
    private JFrame fr;
    private JTextArea ta;
    private JPanel pl1, pl2;
    private JLabel  laCon, label1, label2, label3, label4;
    private JButton butprint, butback;
    public Bill(){
        ImageIcon icon = null;
        fr = new JFrame("Bill");
        fr.addWindowListener(this);
        pl1 = new JPanel();
        ta = new JTextArea("", 5, 30);
        butprint = new JButton("print");
        butback = new JButton("back");
        URL imageURL = Login.class.getResource("icon.jpg");
        if (imageURL != null) {
            icon = new ImageIcon(imageURL);
        }
        fr.setLayout(new BorderLayout());
        pl1.setLayout(new FlowLayout());
        pl1.add(butprint);
        pl1.add(butback);
        fr.add(ta, BorderLayout.CENTER);
        fr.add(pl1, BorderLayout.SOUTH);
        fr.setSize(500, 800);
        fr.setLocation(1200, 200);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fr.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
         File f = new File("test01.txt");
        if (f.exists()) {
            try {
            int ch;
            String text = "";
                System.out.println("nani");
            FileReader fr = new FileReader("test01.txt");
            while ((ch = fr.read()) != -1) {
                text += (char) ch;
            }
            ta.setText(text);
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
                String text = ta.getText();
        try (FileWriter fw = new FileWriter("test01.txt");) {
            for (int i = 0; i < text.length(); i++) {
                fw.write(text.charAt(i));
            }
            System.out.println("Writing successful");
        } catch (IOException ea) {
            System.out.print(ea);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
