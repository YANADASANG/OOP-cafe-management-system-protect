package cafe;

import java.awt.*;
import java.awt.event.*;
import java.awt.Font.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*;

public class mainFrame implements ActionListener {

    private JFrame fr;
    private JPanel title_bar, menu, cal, blank1, blank2, blank3, cal1, cal2, drink, dessert;
    private JTextField cal_drink, cal_dessert, vat7, last;
    private JButton logout, reset, confirm;
    private JScrollPane scroll_drink, scroll_dessert;
    private ImageIcon logo;
    private JLabel logo_label, cost_drink, cost_dessert, vat, total;
    private Dessert des;
    private Drink drinkmenu;
    private ArrayList<Dessert> deslist = new ArrayList<Dessert>();
    private ArrayList<Drink> drinklist = new ArrayList<Drink>();

    //dessert
    private JPanel dessert0, dessert1, dessert2, dessert3, dessert4, dessert5, dessert6, dessert7, dessert8, dessert9, dessert10;
    private JLabel desserts, tiramisu, chocBall, banoffee, straw, blue, toffee, coconut, redvelvet, brownie, egg;
    private JTextField ti, choc, ban, str, blu, tof, coco, red, brown, eg;

    //drink
    private JPanel drink01, drink02, drink1, drink2, drink3, drink4, drink5, drink6, drink7, drink8, drink9, drink10;
    private JLabel drinks, esspresso, latte, cappucino, americano, mocha, matcha, blacktea, chocolate, caramel, fruittea, hot, ice, frap;
    private JTextField hess, hlatt, hcappu, hamer, hmoch, hmat, hblack, hchoco, hcaram, hfruit;
    private JTextField iess, ilatt, icappu, iamer, imoch, imat, iblack, ichoco, icaram, ifruit;
    private JTextField fess, flatt, fcappu, famer, fmoch, fmat, fblack, fchoco, fcaram, ffruit;

    public mainFrame() {
        fr = new JFrame();
        title_bar = new JPanel();
        menu = new JPanel();
        cal = new JPanel();
        blank1 = new JPanel();
        blank2 = new JPanel();
        blank3 = new JPanel();
        cal1 = new JPanel();
        cal2 = new JPanel();
        drink = new JPanel();
        dessert = new JPanel();
        cal_drink = new JTextField();
        cal_dessert = new JTextField();
        vat7 = new JTextField();
        last = new JTextField();
        logout = new JButton("Log out");
        reset = new JButton("Reset");
        confirm = new JButton("Confirm");
        reset.addActionListener(this);
        confirm.addActionListener(this);
        logo = new ImageIcon("logo.png");
        logo_label = new JLabel(logo);
        cost_drink = new JLabel(" Cost Drink");
        cost_dessert = new JLabel(" Cost Dessert");
        vat = new JLabel(" Vat 7%");
        total = new JLabel(" Total");

        //dessert
        desserts = new JLabel("Desserts");
        tiramisu = new JLabel("Tiramisu");
        chocBall = new JLabel("Chocolate Ball");
        banoffee = new JLabel("Banoffee");
        straw = new JLabel("Strawberry Cheesecake");
        blue = new JLabel("Blueberry Cheesecake");
        toffee = new JLabel("Toffee Nut");
        coconut = new JLabel("Coconut Layers");
        redvelvet = new JLabel("Red Velvet");
        brownie = new JLabel("Brownie");
        egg = new JLabel("Egg Tart");

        dessert0 = new JPanel();
        dessert1 = new JPanel();
        dessert2 = new JPanel();
        dessert3 = new JPanel();
        dessert4 = new JPanel();
        dessert5 = new JPanel();
        dessert6 = new JPanel();
        dessert7 = new JPanel();
        dessert8 = new JPanel();
        dessert9 = new JPanel();
        dessert10 = new JPanel();

        ti = new JTextField();
        choc = new JTextField();
        ban = new JTextField();
        str = new JTextField();
        blu = new JTextField();
        tof = new JTextField();
        coco = new JTextField();
        red = new JTextField();
        brown = new JTextField();
        eg = new JTextField();

        //drink
        drinks = new JLabel("Drinks");
        hot = new JLabel("HOT");
        ice = new JLabel("ICED");
        frap = new JLabel("FRAPPE");
        esspresso = new JLabel("Esspresso");
        latte = new JLabel("Latte");
        cappucino = new JLabel("Cappucino");
        americano = new JLabel("Americano");
        mocha = new JLabel("Mocha");
        blacktea = new JLabel("Black Tea");
        chocolate = new JLabel("Chocolate");
        caramel = new JLabel("Caramel Macchiato");
        matcha = new JLabel("Matcha");
        fruittea = new JLabel("Fruit Tea");

        drink01 = new JPanel();
        drink02 = new JPanel();
        drink1 = new JPanel();
        drink2 = new JPanel();
        drink3 = new JPanel();
        drink4 = new JPanel();
        drink5 = new JPanel();
        drink6 = new JPanel();
        drink7 = new JPanel();
        drink8 = new JPanel();
        drink9 = new JPanel();
        drink10 = new JPanel();

        hess = new JTextField();
        iess = new JTextField();
        fess = new JTextField();
        hlatt = new JTextField();
        ilatt = new JTextField();
        flatt = new JTextField();
        hcappu = new JTextField();
        icappu = new JTextField();
        fcappu = new JTextField();
        hamer = new JTextField();
        iamer = new JTextField();
        famer = new JTextField();
        hmoch = new JTextField();
        imoch = new JTextField();
        fmoch = new JTextField();
        hblack = new JTextField();
        iblack = new JTextField();
        fblack = new JTextField();
        hchoco = new JTextField();
        ichoco = new JTextField();
        fchoco = new JTextField();
        hcaram = new JTextField();
        icaram = new JTextField();
        fcaram = new JTextField();
        hfruit = new JTextField();
        ifruit = new JTextField();
        ffruit = new JTextField();
        hmat = new JTextField();
        imat = new JTextField();
        fmat = new JTextField();

        MyClock clock = new MyClock();
        Thread t = new Thread(clock);

        t.start();

        scroll_drink = new JScrollPane(drink, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll_dessert = new JScrollPane(dessert, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        fr.setTitle("Cafe Management System");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fr.setPreferredSize(new Dimension(1500, 1000));
        title_bar.setPreferredSize(new Dimension(1500, 50));
        menu.setPreferredSize(new Dimension(1500, 750));
        cal.setPreferredSize(new Dimension(1500, 200));
        drink.setPreferredSize(new Dimension(720, 700));
        dessert.setPreferredSize(new Dimension(720, 700));
        logout.setPreferredSize(new Dimension(100, 30));
        logo_label.setPreferredSize(new Dimension(30, 30));
        cal_drink.setEditable(false);
        cal_drink.setBackground(Color.WHITE);
        cal_dessert.setEditable(false);
        cal_dessert.setBackground(Color.WHITE);
        vat7.setEditable(false);
        vat7.setBackground(Color.WHITE);
        last.setEditable(false);
        last.setBackground(Color.WHITE);
        cost_drink.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        cost_dessert.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        vat.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        total.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        desserts.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        drinks.setFont(new Font("Helvetica Neue", Font.BOLD, 20));

        fr.setLayout(new BorderLayout());
        fr.add(title_bar, BorderLayout.NORTH);
        fr.add(menu, BorderLayout.CENTER);
        fr.add(cal, BorderLayout.SOUTH);

        //Title Bar Zone
        title_bar.setLayout(new BorderLayout());
        title_bar.add(clock, BorderLayout.WEST);
        title_bar.add(logo_label, BorderLayout.CENTER);
        title_bar.add(logout, BorderLayout.EAST);

        //Menu Zone
        menu.setLayout(new BorderLayout());
        //Drinks
        menu.add(scroll_drink, BorderLayout.WEST);
        drink.setLayout(new GridLayout(13, 1));
        drink.add(drink01);
        drink01.setLayout(new GridLayout(1, 9));
        drink.add(drink02);
        drink02.setLayout(new GridLayout(1, 9));
        drink.add(drink1);
        drink1.setLayout(new GridLayout(1, 9));
        drink.add(drink2);
        drink2.setLayout(new GridLayout(1, 9));
        drink.add(drink3);
        drink3.setLayout(new GridLayout(1, 9));
        drink.add(drink4);
        drink4.setLayout(new GridLayout(1, 9));
        drink.add(drink5);
        drink5.setLayout(new GridLayout(1, 9));
        drink.add(drink6);
        drink6.setLayout(new GridLayout(1, 9));
        drink.add(drink7);
        drink7.setLayout(new GridLayout(1, 9));
        drink.add(drink8);
        drink8.setLayout(new GridLayout(1, 9));
        drink.add(drink9);
        drink9.setLayout(new GridLayout(1, 9));
        drink.add(drink10);
        drink10.setLayout(new GridLayout(1, 9));

        drink01.add(new JLabel());
        drink01.add(new JLabel());
        drink01.add(new JLabel());
        drink01.add(new JLabel());
        drink01.add(drinks);
        drink01.add(new JLabel());
        drink01.add(new JLabel());
        drink01.add(new JLabel());
        drink01.add(new JLabel());
        drink02.add(new JLabel());
        drink02.add(new JLabel());
        drink02.add(new JLabel());
        drink02.add(hot);
        drink02.add(new JLabel());
        drink02.add(ice);
        drink02.add(new JLabel());
        drink02.add(frap);
        drink02.add(new JLabel());
        drink1.add(new JLabel());
        drink1.add(esspresso);
        drink1.add(new JLabel());
        drink1.add(hess);
        drink1.add(new JLabel());
        drink1.add(iess);
        drink1.add(new JLabel());
        drink1.add(fess);
        drink1.add(new JLabel());
        drink2.add(new JLabel());
        drink2.add(latte);
        drink2.add(new JLabel());
        drink2.add(hlatt);
        drink2.add(new JLabel());
        drink2.add(ilatt);
        drink2.add(new JLabel());
        drink2.add(flatt);
        drink2.add(new JLabel());
        drink3.add(new JLabel());
        drink3.add(cappucino);
        drink3.add(new JLabel());
        drink3.add(hcappu);
        drink3.add(new JLabel());
        drink3.add(icappu);
        drink3.add(new JLabel());
        drink3.add(fcappu);
        drink3.add(new JLabel());
        drink4.add(new JLabel());
        drink4.add(americano);
        drink4.add(new JLabel());
        drink4.add(hamer);
        drink4.add(new JLabel());
        drink4.add(iamer);
        drink4.add(new JLabel());
        drink4.add(famer);
        drink4.add(new JLabel());
        drink5.add(new JLabel());
        drink5.add(mocha);
        drink5.add(new JLabel());
        drink5.add(hmoch);
        drink5.add(new JLabel());
        drink5.add(imoch);
        drink5.add(new JLabel());
        drink5.add(fmoch);
        drink5.add(new JLabel());
        drink6.add(new JLabel());
        drink6.add(matcha);
        drink6.add(new JLabel());
        drink6.add(hmat);
        drink6.add(new JLabel());
        drink6.add(imat);
        drink6.add(new JLabel());
        drink6.add(fmat);
        drink6.add(new JLabel());
        drink7.add(new JLabel());
        drink7.add(blacktea);
        drink7.add(new JLabel());
        drink7.add(hblack);
        drink7.add(new JLabel());
        drink7.add(iblack);
        drink7.add(new JLabel());
        drink7.add(fblack);
        drink7.add(new JLabel());
        drink8.add(new JLabel());
        drink8.add(chocolate);
        drink8.add(new JLabel());
        drink8.add(hchoco);
        drink8.add(new JLabel());
        drink8.add(ichoco);
        drink8.add(new JLabel());
        drink8.add(fchoco);
        drink8.add(new JLabel());
        drink9.add(new JLabel());
        drink9.add(caramel);
        drink9.add(new JLabel());
        drink9.add(hcaram);
        drink9.add(new JLabel());
        drink9.add(icaram);
        drink9.add(new JLabel());
        drink9.add(fcaram);
        drink9.add(new JLabel());
        drink10.add(new JLabel());
        drink10.add(fruittea);
        drink10.add(new JLabel());
        drink10.add(hfruit);
        drink10.add(new JLabel());
        drink10.add(ifruit);
        drink10.add(new JLabel());
        drink10.add(ffruit);
        drink10.add(new JLabel());

        //Desserts
        menu.add(scroll_dessert, BorderLayout.EAST);
        dessert.setLayout(new GridLayout(12, 1));
        dessert.add(dessert0);
        dessert0.setLayout(new GridLayout(1, 5));
        dessert.add(dessert1);
        dessert1.setLayout(new GridLayout(1, 5));
        dessert.add(dessert2);
        dessert2.setLayout(new GridLayout(1, 5));
        dessert.add(dessert3);
        dessert3.setLayout(new GridLayout(1, 5));
        dessert.add(dessert4);
        dessert4.setLayout(new GridLayout(1, 5));
        dessert.add(dessert5);
        dessert5.setLayout(new GridLayout(1, 5));
        dessert.add(dessert6);
        dessert6.setLayout(new GridLayout(1, 5));
        dessert.add(dessert7);
        dessert7.setLayout(new GridLayout(1, 5));
        dessert.add(dessert8);
        dessert8.setLayout(new GridLayout(1, 5));
        dessert.add(dessert9);
        dessert9.setLayout(new GridLayout(1, 5));
        dessert.add(dessert10);
        dessert10.setLayout(new GridLayout(1, 5));

        dessert0.add(new JLabel());
        dessert0.add(new JLabel());
        dessert0.add(desserts);
        dessert0.add(new JLabel());
        dessert0.add(new JLabel());
        dessert1.add(new JLabel());
        dessert1.add(tiramisu);
        dessert1.add(new JLabel());
        dessert1.add(ti);
        dessert1.add(new JLabel());
        dessert2.add(new JLabel());
        dessert2.add(chocBall);
        dessert2.add(new JLabel());
        dessert2.add(choc);
        dessert2.add(new JLabel());
        dessert3.add(new JLabel());
        dessert3.add(banoffee);
        dessert3.add(new JLabel());
        dessert3.add(ban);
        dessert3.add(new JLabel());
        dessert4.add(new JLabel());
        dessert4.add(straw);
        dessert4.add(new JLabel());
        dessert4.add(str);
        dessert4.add(new JLabel());
        dessert5.add(new JLabel());
        dessert5.add(blue);
        dessert5.add(new JLabel());
        dessert5.add(blu);
        dessert5.add(new JLabel());
        dessert6.add(new JLabel());
        dessert6.add(toffee);
        dessert6.add(new JLabel());
        dessert6.add(tof);
        dessert6.add(new JLabel());
        dessert7.add(new JLabel());
        dessert7.add(coconut);
        dessert7.add(new JLabel());
        dessert7.add(coco);
        dessert7.add(new JLabel());
        dessert8.add(new JLabel());
        dessert8.add(redvelvet);
        dessert8.add(new JLabel());
        dessert8.add(red);
        dessert8.add(new JLabel());
        dessert9.add(new JLabel());
        dessert9.add(brownie);
        dessert9.add(new JLabel());
        dessert9.add(brown);
        dessert9.add(new JLabel());
        dessert10.add(new JLabel());
        dessert10.add(egg);
        dessert10.add(new JLabel());
        dessert10.add(eg);
        dessert10.add(new JLabel());

        //Calculate Zone
        cal.setLayout(new GridLayout(5, 1));
        cal.add(blank1);
        cal.add(cal1);
        cal.add(blank2);
        cal.add(cal2);
        cal.add(blank3);
        cal1.setLayout(new GridLayout(1, 9));
        cal1.add(new JLabel());
        cal1.add(cost_drink);
        cal1.add(cal_drink);
        cal1.add(new JLabel());
        cal1.add(vat);
        cal1.add(vat7);
        cal1.add(new JLabel());
        cal1.add(reset);
        cal1.add(new JLabel());
        cal2.setLayout(new GridLayout(1, 9));
        cal2.add(new JLabel());
        cal2.add(cost_dessert);
        cal2.add(cal_dessert);
        cal2.add(new JLabel());
        cal2.add(total);
        cal2.add(last);
        cal2.add(new JLabel());
        cal2.add(confirm);
        cal2.add(new JLabel());

        fr.pack();
        fr.setVisible(true);

    }

    public void addorder(JTextField menu) {
        if (menu.getText().isEmpty() == false) {
            if (menu == ti) {
                Dessert des = new Dessert("Dessert", "Tiramisu", Integer.parseInt(menu.getText()));
                if(deslist.contains(des)==false)
                    deslist.add(des);
            } else if (menu == choc) {
                Dessert des = new Dessert("Dessert", "Chocolate Ball", Integer.parseInt(menu.getText()));
                deslist.add(des);
            } else if (menu == ban) {
                Dessert des = new Dessert("Dessert", "Banoffee", Integer.parseInt(menu.getText()));
                deslist.add(des);
            } else if (menu == str) {
                Dessert des = new Dessert("Dessert", "Strawberry Cheesecake", Integer.parseInt(menu.getText()));
                deslist.add(des);
            } else if (menu == blu) {
                Dessert des = new Dessert("Dessert", "Blueberry Cheesecake", Integer.parseInt(menu.getText()));
                deslist.add(des);
            } else if (menu == tof) {
                Dessert des = new Dessert("Dessert", "Toffee Nut", Integer.parseInt(menu.getText()));
                deslist.add(des);
            } else if (menu == coco) {
                Dessert des = new Dessert("Dessert", "Coconut Layers", Integer.parseInt(menu.getText()));
                deslist.add(des);
            } else if (menu == red) {
                Dessert des = new Dessert("Dessert", "Red Velvet", Integer.parseInt(menu.getText()));
                deslist.add(des);
            } else if (menu == brown) {
                Dessert des = new Dessert("Dessert", "Brownie", Integer.parseInt(menu.getText()));
                deslist.add(des);
            } else if (menu == eg) {
                Dessert des = new Dessert("Dessert", "Egg Tart", Integer.parseInt(menu.getText()));
                deslist.add(des);
            } //dessert
            else if (menu == hess) {
                Drink drinkmenu = new Drink("Hot", "Esspresso", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == hlatt) {
                Drink drinkmenu = new Drink("Hot", "Latte", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == hcappu) {
                Drink drinkmenu = new Drink("Hot", "Cappucino", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == hamer) {
                Drink drinkmenu = new Drink("Hot", "Americano", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == hmoch) {
                Drink drinkmenu = new Drink("Hot", "Mocha", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == hmat) {
                Drink drinkmenu = new Drink("Hot", "Matcha", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == hblack) {
                Drink drinkmenu = new Drink("Hot", "Black Tea", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == hchoco) {
                Drink drinkmenu = new Drink("Hot", "Chocolate", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == hcaram) {
                Drink drinkmenu = new Drink("Hot", "Caramel Macchiato", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == hfruit) {
                Drink drinkmenu = new Drink("Hot", "Fruit Tea", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } //hotdrink
            else if (menu == iess) {
                Drink drinkmenu = new Drink("Ice", "Esspresso", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == ilatt) {
                Drink drinkmenu = new Drink("Ice", "Latte", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == icappu) {
                Drink drinkmenu = new Drink("Ice", "Cappucino", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == iamer) {
                Drink drinkmenu = new Drink("Ice", "Americano", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == imoch) {
                Drink drinkmenu = new Drink("Ice", "Mocha", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == imat) {
                Drink drinkmenu = new Drink("Ice", "Matcha", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == iblack) {
                Drink drinkmenu = new Drink("Ice", "Black Tea", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == ichoco) {
                Drink drinkmenu = new Drink("Ice", "Chocolate", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == icaram) {
                Drink drinkmenu = new Drink("Ice", "Caramel Macchiato", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == ifruit) {
                Drink drinkmenu = new Drink("Ice", "Fruit Tea", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } //icedrink
            else if (menu == fess) {
                Drink drinkmenu = new Drink("Frappe", "Esspresso", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == flatt) {
                Drink drinkmenu = new Drink("Frappe", "Latte", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == fcappu) {
                Drink drinkmenu = new Drink("Frappe", "Cappucino", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == famer) {
                Drink drinkmenu = new Drink("Frappe", "Americano", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == fmoch) {
                Drink drinkmenu = new Drink("Frappe", "Mocha", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == fmat) {
                Drink drinkmenu = new Drink("Frappe", "Matcha", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == fblack) {
                Drink drinkmenu = new Drink("Frappe", "Black Tea", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == fchoco) {
                Drink drinkmenu = new Drink("Frappe", "Chocolate", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == fcaram) {
                Drink drinkmenu = new Drink("Frappe", "Caramel Macchiato", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            } else if (menu == ffruit) {
                Drink drinkmenu = new Drink("Frappe", "Fruit Tea", Integer.parseInt(menu.getText()));
                drinklist.add(drinkmenu);
            }
        }//if
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(confirm)) {
            addorder(ti);
            addorder(choc);
            addorder(ban);
            addorder(str);
            addorder(blu);
            addorder(tof);
            addorder(coco);
            addorder(red);
            addorder(brown);
            addorder(eg); //dessert
            addorder(hess);
            addorder(hlatt);
            addorder(hcappu);
            addorder(hamer);
            addorder(hmoch);
            addorder(hmat);
            addorder(hblack);
            addorder(hchoco);
            addorder(hcaram);
            addorder(hfruit); //hotdrink
            addorder(iess);
            addorder(ilatt);
            addorder(icappu);
            addorder(iamer);
            addorder(imoch);
            addorder(imat);
            addorder(iblack);
            addorder(ichoco);
            addorder(icaram);
            addorder(ifruit); //icedrink
            addorder(fess);
            addorder(flatt);
            addorder(fcappu);
            addorder(famer);
            addorder(fmoch);
            addorder(fmat);
            addorder(fblack);
            addorder(fchoco);
            addorder(fcaram);
            addorder(ffruit); //frappedrink
            System.out.println("before des" + deslist.size());
            System.out.println("before drink" + drinklist.size());
            saveDessertdata();
            saveDrinkdata();
        }
    }

    public void saveDessertdata() {
        try {
            FileInputStream fin = new FileInputStream("DessertData.data");
            ObjectInputStream in = new ObjectInputStream(fin);
            deslist = (ArrayList<Dessert>) in.readObject();
            in.close();
            fin.close();

        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }

        try {
            FileOutputStream fOut = new FileOutputStream("DessertData.data");
            ObjectOutputStream oout = new ObjectOutputStream(fOut);
            oout.writeObject(deslist);
            fOut.close();
        } catch (Exception i) {
            i.printStackTrace();
        }
    }

    public void saveDrinkdata() {

        try {
            FileInputStream fin = new FileInputStream("DrinkData.data");
            ObjectInputStream in = new ObjectInputStream(fin);
            drinklist = (ArrayList<Drink>) in.readObject();
            in.close();
            fin.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }

        try {
            FileOutputStream fOut = new FileOutputStream("DrinkData.data");
            ObjectOutputStream oout = new ObjectOutputStream(fOut);
            oout.writeObject(drinklist);
            fOut.close();
        } catch (Exception i) {
            i.printStackTrace();
        }
    }

}
