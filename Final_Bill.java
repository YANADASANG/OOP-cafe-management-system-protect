package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Final_Bill implements ActionListener, WindowListener {
    private JFrame fr;
    private JTextArea ta;
    private JPanel pn,pn2;
    private JButton bn1,bn2;

    public Final_Bill(){
        fr = new JFrame("TOTAL");
        fr.addWindowListener(this);
        bn1 = new JButton("RESET BILL");
        bn1.addActionListener(this);
        bn2 = new JButton("PRINT BILL");
        bn2.addActionListener(this);
        ta = new JTextArea("",45,45);
        ta.setEditable(false);

        pn = new JPanel();
        pn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pn.setLayout(new GridLayout(1,1));
        pn.add(ta);

        pn2 = new JPanel();
        pn2.setLayout(new FlowLayout());
        pn2.add(bn2); pn2.add(bn1);

        fr.setLayout(new BorderLayout());
        fr.add(pn,BorderLayout.CENTER);
        fr.add(pn2,BorderLayout.SOUTH);


        fr.setVisible(true);
        fr.setSize(500,700);
        fr.setLocation(600,100);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(bn1)){
            ta.setText("");
        }
        if(ae.getSource().equals(bn2)){
        }
    }

    public void windowOpened(WindowEvent e) {
        File f = new File("File.txt");
        if (f.exists()) {
            try {
                int ch;
                String text = "";
                System.out.println("Process");
                FileReader fr = new FileReader("File.txt");
                while ((ch = fr.read()) != -1) {
                    text += (char) ch;
                }
                ta.setText(text);
                fr.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        String text = ta.getText();
        try (FileWriter fw = new FileWriter("File.txt");) {
            for (int i = 0; i < text.length(); i++) {
                fw.write(text.charAt(i));
            }
            System.out.println("Writing successful");
        }

        catch (IOException ea) {
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
    }

    public static void main(String[] args) {
        new Final_Bill();
    }
}
