package cafe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Final_Bill implements ActionListener, WindowListener {

    private JFrame fr;
    private JTextArea ta;
    private JPanel pn, pn2;
    private JButton bn1,bn2;
    private ArrayList<Dessert> deslist = new ArrayList<Dessert>();
    private ArrayList<Drink> drinklist = new ArrayList<Drink>();
    private Dessert des;
    private Drink drinkmenu;
    private double calcu;

    public Final_Bill() {
        fr = new JFrame("TOTAL");
        fr.addWindowListener(this);
        bn1 = new JButton("BACK");
        bn1.addActionListener(this);
        bn2 = new JButton("CLOSE");
        bn2.addActionListener(this);
        ta = new JTextArea("", 45, 45);
        ta.setEditable(false);

        pn = new JPanel();
        pn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pn.setLayout(new GridLayout(1, 1));
        pn.add(ta);

        pn2 = new JPanel();
        pn2.setLayout(new FlowLayout());
        pn2.add(bn1); pn2.add(bn2);

        fr.setLayout(new BorderLayout());
        fr.add(pn, BorderLayout.CENTER);
        fr.add(pn2, BorderLayout.SOUTH);

        fr.setVisible(true);
        fr.setSize(430, 700);
        fr.setLocation(600, 100);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(bn1)) {
            fr.dispose();
            new mainFrame();
        }
        if(ae.getSource().equals(bn2)){
            fr.dispose();
            new Printed();
        }
    }

    public void windowOpened(WindowEvent e) {
        ta.append("\t*****CAFE MANAGEMENT SYSTEM*****\n\n");
        File f = new File("DrinkData.data");
        if (f.exists()) {
            try {
                FileInputStream fin = new FileInputStream("DrinkData.data");
                ObjectInputStream in = new ObjectInputStream(fin);
                drinklist = (ArrayList<Drink>) in.readObject();
                in.close();
                fin.close();
                for (int i = 0; i < drinklist.size(); i++) {//for check
                    drinkmenu = (Drink) drinklist.get(i);
                    calcu += drinkmenu.getPrices();
                    ta.append(" "+drinkmenu.getName() + "\t" + drinkmenu.getType() + "\t" + drinkmenu.getNumbers()+ "\t" +drinkmenu.getPrices() + "\n");
                    System.out.println(drinkmenu.getName() + " " + drinkmenu.getType() + " " + drinkmenu.getNumbers()+ " " + drinkmenu.getPrices());
                }
            } catch (IOException i) {
                i.printStackTrace();
            } catch (ClassNotFoundException c) { // จะเกิดขึ้นในกรณีที่ตอนอ่านไฟล์แล้ว ไม่พบคลาส Student c.printStackTrace();
                System.out.println("no data");
            }
        }
        File f2 = new File("DessertData.data");
        if (f2.exists()) {
            try {
                FileInputStream fin = new FileInputStream("DessertData.data");
                ObjectInputStream in = new ObjectInputStream(fin);
                deslist = (ArrayList<Dessert>) in.readObject();
                in.close();
                fin.close();
                for (int i = 0; i < deslist.size(); i++) {//for check
                    des = (Dessert) deslist.get(i);
                    calcu += des.getPrices();
                    ta.append(" "+des.getName() + "\t" + des.getType() + "\t" + des.getNumbers()+ "\t" +des.getPrices() +"\n");
                    System.out.println(des.getName() + " " + des.getType() + " " + des.getNumbers() + " " + des.getPrices());
                }
                ta.append("\t\t\tTotal\t"+String.valueOf(calcu)+"\n");

            } catch (IOException i) {
                i.printStackTrace();
            } catch (ClassNotFoundException c) { // จะเกิดขึ้นในกรณีที่ตอนอ่านไฟล์แล้ว ไม่พบคลาส Student c.printStackTrace();
                System.out.println("no data");
            }
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("\t        dd/MM/yyyy                     HH:mm:ss");
        ta.append("=======================================================\n\n");
        ta.append("For Price Calculate\n");
        ta.append("=======================================================\n");
        ta.append("\n\n"+dtf.format(LocalDateTime.now())+"\n\n");
        ta.append("\t\tTHANK YOU");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        String text = ta.getText();
        try (FileWriter fw = new FileWriter("File.txt");) {
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
    }

    public static void main(String[] args) {
        new Final_Bill();
    }
}
