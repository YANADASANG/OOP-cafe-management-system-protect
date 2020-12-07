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

public class mainFrame extends Thread implements ActionListener, WindowListener {

    public int show;
    public int close = 0;
    private int sum;
    private JFrame fr;
    private JPanel title_bar, menu, cal, blank1, blank2, blank3, cal1, cal2, drink, dessert;
    private JTextField cal_drink, cal_dessert, vat7, last;
    private JButton logout, reset, confirm;
    private JScrollPane scroll_drink, scroll_dessert;
    private ImageIcon logo;
    private JLabel logo_label, cost_drink, cost_dessert, vat, total;
    private Dessert des;
    private Drink drinkmenu;

    private ArrayList<Dessert> showdes = new ArrayList<Dessert>();
    private ArrayList<Drink> showdrink = new ArrayList<Drink>();
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
    private JTextField text;

    public mainFrame(int show) {
        this.show = show;
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
        logout.addActionListener(this);
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
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        fr.addWindowListener(this);
        fr.pack();
        fr.setVisible(true);

    }

    public void addorder(JTextField menu) {
        if (menu.getText().isEmpty() == false && menu.getText().equals("0")==false&& isdigit(menu.getText())==true) {
            if (menu == ti) {
                Dessert des = new Dessert("Dessert", "Tiramisu\t", Integer.parseInt(menu.getText()), Integer.parseInt("60"), 1);
                deslist.add(des);
            } else if (menu == choc) {
                Dessert des = new Dessert("Dessert", "Chocolate Ball\t", Integer.parseInt(menu.getText()), Integer.parseInt("40"), 2);
                deslist.add(des);
            } else if (menu == ban) {
                Dessert des = new Dessert("Dessert", "Banoffee\t", Integer.parseInt(menu.getText()), Integer.parseInt("45"), 3);
                deslist.add(des);
            } else if (menu == str) {
                Dessert des = new Dessert("Dessert", "Strawberry Cheesecake", Integer.parseInt(menu.getText()), Integer.parseInt("70"), 4);
                deslist.add(des);
            } else if (menu == blu) {
                Dessert des = new Dessert("Dessert", "Blueberry Cheesecake", Integer.parseInt(menu.getText()), Integer.parseInt("60"), 5);
                deslist.add(des);
            } else if (menu == tof) {
                Dessert des = new Dessert("Dessert", "Toffee Nut\t", Integer.parseInt(menu.getText()), Integer.parseInt("80"), 6);
                deslist.add(des);
            } else if (menu == coco) {
                Dessert des = new Dessert("Dessert", "Coconut Layers", Integer.parseInt(menu.getText()), Integer.parseInt("60"), 7);
                deslist.add(des);
            } else if (menu == red) {
                Dessert des = new Dessert("Dessert", "Red Velvet\t", Integer.parseInt(menu.getText()), Integer.parseInt("80"), 8);
                deslist.add(des);
            } else if (menu == brown) {
                Dessert des = new Dessert("Dessert", "Brownie\t", Integer.parseInt(menu.getText()), Integer.parseInt("50"), 9);
                deslist.add(des);
            } else if (menu == eg) {
                Dessert des = new Dessert("Dessert", "Egg Tart\t", Integer.parseInt(menu.getText()), Integer.parseInt("55"), 10);
                deslist.add(des);
            } //dessert
            else if (menu == hess) {
                Drink drinkmenu = new Drink("Hot", "Esspresso\t", Integer.parseInt(menu.getText()), Integer.parseInt("40"), 11);
                drinklist.add(drinkmenu);
            } else if (menu == hlatt) {
                Drink drinkmenu = new Drink("Hot", "Latte\t", Integer.parseInt(menu.getText()), Integer.parseInt("40"), 12);
                drinklist.add(drinkmenu);
            } else if (menu == hcappu) {
                Drink drinkmenu = new Drink("Hot", "Cappucino\t", Integer.parseInt(menu.getText()), Integer.parseInt("40"), 13);
                drinklist.add(drinkmenu);
            } else if (menu == hamer) {
                Drink drinkmenu = new Drink("Hot", "Americano\t", Integer.parseInt(menu.getText()), Integer.parseInt("40"), 14);
                drinklist.add(drinkmenu);
            } else if (menu == hmoch) {
                Drink drinkmenu = new Drink("Hot", "Mocha\t", Integer.parseInt(menu.getText()), Integer.parseInt("40"), 15);
                drinklist.add(drinkmenu);
            } else if (menu == hmat) {
                Drink drinkmenu = new Drink("Hot", "Matcha\t", Integer.parseInt(menu.getText()), Integer.parseInt("50"), 16);
                drinklist.add(drinkmenu);
            } else if (menu == hblack) {
                Drink drinkmenu = new Drink("Hot", "Black Tea\t", Integer.parseInt(menu.getText()), Integer.parseInt("45"), 17);
                drinklist.add(drinkmenu);
            } else if (menu == hchoco) {
                Drink drinkmenu = new Drink("Hot", "Chocolate\t", Integer.parseInt(menu.getText()), Integer.parseInt("45"), 18);
                drinklist.add(drinkmenu);
            } else if (menu == hcaram) {
                Drink drinkmenu = new Drink("Hot", "Caramel Macchiato", Integer.parseInt(menu.getText()), Integer.parseInt("40"), 19);
                drinklist.add(drinkmenu);
            } else if (menu == hfruit) {
                Drink drinkmenu = new Drink("Hot", "Fruit Tea\t", Integer.parseInt(menu.getText()), Integer.parseInt("40"), 20);
                drinklist.add(drinkmenu);
            } //hotdrink
            else if (menu == iess) {
                Drink drinkmenu = new Drink("Ice", "Esspresso\t", Integer.parseInt(menu.getText()), Integer.parseInt("50"), 21);
                drinklist.add(drinkmenu);
            } else if (menu == ilatt) {
                Drink drinkmenu = new Drink("Ice", "Latte\t", Integer.parseInt(menu.getText()), Integer.parseInt("50"), 22);
                drinklist.add(drinkmenu);
            } else if (menu == icappu) {
                Drink drinkmenu = new Drink("Ice", "Cappucino\t", Integer.parseInt(menu.getText()), Integer.parseInt("50"), 23);
                drinklist.add(drinkmenu);
            } else if (menu == iamer) {
                Drink drinkmenu = new Drink("Ice", "Americano\t", Integer.parseInt(menu.getText()), Integer.parseInt("50"), 24);
                drinklist.add(drinkmenu);
            } else if (menu == imoch) {
                Drink drinkmenu = new Drink("Ice", "Mocha\t", Integer.parseInt(menu.getText()), Integer.parseInt("50"), 25);
                drinklist.add(drinkmenu);
            } else if (menu == imat) {
                Drink drinkmenu = new Drink("Ice", "Matcha\t", Integer.parseInt(menu.getText()), Integer.parseInt("55"), 26);
                drinklist.add(drinkmenu);
            } else if (menu == iblack) {
                Drink drinkmenu = new Drink("Ice", "Black Tea\t", Integer.parseInt(menu.getText()), Integer.parseInt("55"), 27);
                drinklist.add(drinkmenu);
            } else if (menu == ichoco) {
                Drink drinkmenu = new Drink("Ice", "Chocolate\t", Integer.parseInt(menu.getText()), Integer.parseInt("50"), 28);
                drinklist.add(drinkmenu);
            } else if (menu == icaram) {
                Drink drinkmenu = new Drink("Ice", "Caramel Macchiato", Integer.parseInt(menu.getText()), Integer.parseInt("40"), 29);
                drinklist.add(drinkmenu);
            } else if (menu == ifruit) {
                Drink drinkmenu = new Drink("Ice", "Fruit Tea\t", Integer.parseInt(menu.getText()), Integer.parseInt("50"), 30);
                drinklist.add(drinkmenu);
            } //icedrink
            else if (menu == fess) {
                Drink drinkmenu = new Drink("Frappe", "Esspresso\t", Integer.parseInt(menu.getText()), Integer.parseInt("55"), 31);
                drinklist.add(drinkmenu);
            } else if (menu == flatt) {
                Drink drinkmenu = new Drink("Frappe", "Latte\t", Integer.parseInt(menu.getText()), Integer.parseInt("55"), 32);
                drinklist.add(drinkmenu);
            } else if (menu == fcappu) {
                Drink drinkmenu = new Drink("Frappe", "Cappucino\t", Integer.parseInt(menu.getText()), Integer.parseInt("60"), 33);
                drinklist.add(drinkmenu);
            } else if (menu == famer) {
                Drink drinkmenu = new Drink("Frappe", "Americano\t", Integer.parseInt(menu.getText()), Integer.parseInt("60"), 34);
                drinklist.add(drinkmenu);
            } else if (menu == fmoch) {
                Drink drinkmenu = new Drink("Frappe", "Mocha\t", Integer.parseInt(menu.getText()), Integer.parseInt("60"), 35);
                drinklist.add(drinkmenu);
            } else if (menu == fmat) {
                Drink drinkmenu = new Drink("Frappe", "Matcha\t", Integer.parseInt(menu.getText()), Integer.parseInt("60"), 36);
                drinklist.add(drinkmenu);
            } else if (menu == fblack) {
                Drink drinkmenu = new Drink("Frappe", "Black Tea\t", Integer.parseInt(menu.getText()), Integer.parseInt("60"), 37);
                drinklist.add(drinkmenu);
            } else if (menu == fchoco) {
                Drink drinkmenu = new Drink("Frappe", "Chocolate\t", Integer.parseInt(menu.getText()), Integer.parseInt("60"), 38);
                drinklist.add(drinkmenu);
            } else if (menu == fcaram) {
                Drink drinkmenu = new Drink("Frappe", "Caramel Macchiato", Integer.parseInt(menu.getText()), Integer.parseInt("55"), 39);
                drinklist.add(drinkmenu);
            } else if (menu == ffruit) {
                Drink drinkmenu = new Drink("Frappe", "Fruit Tea\t", Integer.parseInt(menu.getText()), Integer.parseInt("55"), 40);
                drinklist.add(drinkmenu);
            }
        }//if
    }

    public void keeporder(JTextField menu) {
        int number;
        if (menu.getText().isEmpty() == false && isdigit(menu.getText())==true) {
            number = Integer.parseInt(menu.getText());
        } else {
            number = 0;
        }
        if (menu == ti) {
            Dessert des = new Dessert("Dessert", "Tiramisu\t", number, Integer.parseInt("60"), 1);
            if (checkDes(des) == 1) {
                showdes.add(des);
            }
        } else if (menu == choc) {
            Dessert des = new Dessert("Dessert", "Chocolate Ball\t", number, Integer.parseInt("40"), 2);
            if (checkDes(des) == 1) {
                showdes.add(des);
            }
        } else if (menu == ban) {
            Dessert des = new Dessert("Dessert", "Banoffee\t", number, Integer.parseInt("45"), 3);
            if (checkDes(des) == 1) {
                showdes.add(des);
            }
        } else if (menu == str) {
            Dessert des = new Dessert("Dessert", "Strawberry Cheesecake", number, Integer.parseInt("70"), 4);
            if (checkDes(des) == 1) {
                showdes.add(des);
            }
        } else if (menu == blu) {
            Dessert des = new Dessert("Dessert", "Blueberry Cheesecake", number, Integer.parseInt("60"), 5);
            if (checkDes(des) == 1) {
                showdes.add(des);
            }
        } else if (menu == tof) {
            Dessert des = new Dessert("Dessert", "Toffee Nut\t", number, Integer.parseInt("80"), 6);
            if (checkDes(des) == 1) {
                showdes.add(des);
            }
        } else if (menu == coco) {
            Dessert des = new Dessert("Dessert", "Coconut Layers", number, Integer.parseInt("60"), 7);
            if (checkDes(des) == 1) {
                showdes.add(des);
            }
        } else if (menu == red) {
            Dessert des = new Dessert("Dessert", "Red Velvet\t", number, Integer.parseInt("80"), 8);
            if (checkDes(des) == 1) {
                showdes.add(des);
            }
        } else if (menu == brown) {
            Dessert des = new Dessert("Dessert", "Brownie\t", number, Integer.parseInt("50"), 9);
            if (checkDes(des) == 1) {
                showdes.add(des);
            }
        } else if (menu == eg) {
            Dessert des = new Dessert("Dessert", "Egg Tart\t", number, Integer.parseInt("55"), 10);
            if (checkDes(des) == 1) {
                showdes.add(des);
            }
        } //dessert
        else if (menu == hess) {
            Drink drinkmenu = new Drink("Hot", "Esspresso\t", number, Integer.parseInt("40"), 11);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == hlatt) {
            Drink drinkmenu = new Drink("Hot", "Latte\t", number, Integer.parseInt("40"), 12);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == hcappu) {
            Drink drinkmenu = new Drink("Hot", "Cappucino\t", number, Integer.parseInt("40"), 13);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == hamer) {
            Drink drinkmenu = new Drink("Hot", "Americano\t", number, Integer.parseInt("40"), 14);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == hmoch) {
            Drink drinkmenu = new Drink("Hot", "Mocha\t", number, Integer.parseInt("40"), 15);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == hmat) {
            Drink drinkmenu = new Drink("Hot", "Matcha\t", number, Integer.parseInt("50"), 16);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == hblack) {
            Drink drinkmenu = new Drink("Hot", "Black Tea\t", number, Integer.parseInt("45"), 17);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == hchoco) {
            Drink drinkmenu = new Drink("Hot", "Chocolate\t", number, Integer.parseInt("45"), 18);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == hcaram) {
            Drink drinkmenu = new Drink("Hot", "Caramel Macchiato", number, Integer.parseInt("40"), 19);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == hfruit) {
            Drink drinkmenu = new Drink("Hot", "Fruit Tea\t", number, Integer.parseInt("40"), 20);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } //hotdrink
        else if (menu == iess) {
            Drink drinkmenu = new Drink("Ice", "Esspresso\t", number, Integer.parseInt("50"), 21);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == ilatt) {
            Drink drinkmenu = new Drink("Ice", "Latte\t", number, Integer.parseInt("50"), 22);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == icappu) {
            Drink drinkmenu = new Drink("Ice", "Cappucino\t", number, Integer.parseInt("50"), 23);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == iamer) {
            Drink drinkmenu = new Drink("Ice", "Americano\t", number, Integer.parseInt("50"), 24);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == imoch) {
            Drink drinkmenu = new Drink("Ice", "Mocha\t", number, Integer.parseInt("50"), 25);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == imat) {
            Drink drinkmenu = new Drink("Ice", "Matcha\t", number, Integer.parseInt("55"), 26);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == iblack) {
            Drink drinkmenu = new Drink("Ice", "Black Tea\t", number, Integer.parseInt("55"), 27);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == ichoco) {
            Drink drinkmenu = new Drink("Ice", "Chocolate\t", number, Integer.parseInt("50"), 28);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == icaram) {
            Drink drinkmenu = new Drink("Ice", "Caramel Macchiato", number, Integer.parseInt("40"), 29);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == ifruit) {
            Drink drinkmenu = new Drink("Ice", "Fruit Tea\t", number, Integer.parseInt("50"), 30);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } //icedrink
        else if (menu == fess) {
            Drink drinkmenu = new Drink("Frappe", "Esspresso\t", number, Integer.parseInt("55"), 31);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == flatt) {
            Drink drinkmenu = new Drink("Frappe", "Latte\t", number, Integer.parseInt("55"), 32);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == fcappu) {
            Drink drinkmenu = new Drink("Frappe", "Cappucino\t", number, Integer.parseInt("60"), 33);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == famer) {
            Drink drinkmenu = new Drink("Frappe", "Americano\t", number, Integer.parseInt("60"), 34);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == fmoch) {
            Drink drinkmenu = new Drink("Frappe", "Mocha\t", number, Integer.parseInt("60"), 35);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == fmat) {
            Drink drinkmenu = new Drink("Frappe", "Matcha\t", number, Integer.parseInt("60"), 36);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == fblack) {
            Drink drinkmenu = new Drink("Frappe", "Black Tea\t", number, Integer.parseInt("60"), 37);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == fchoco) {
            Drink drinkmenu = new Drink("Frappe", "Chocolate\t", number, Integer.parseInt("60"), 38);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == fcaram) {
            Drink drinkmenu = new Drink("Frappe", "Caramel Macchiato", number, Integer.parseInt("55"), 39);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        } else if (menu == ffruit) {
            Drink drinkmenu = new Drink("Frappe", "Fruit Tea\t", number, Integer.parseInt("55"), 40);
            if (checkDrink(drinkmenu) == 1) {
                showdrink.add(drinkmenu);
            }
        }//lastelse
    }

    public int checkDes(Dessert des) {
        int keep = 1;
        for (int i = 0; i < showdes.size(); i++) {//for check
            Dessert check = (Dessert) showdes.get(i);
            if (check.getPosition() == des.getPosition()) {
                if (check.getNumbers() != des.getNumbers()) {
                    showdes.remove(i);
                    showdes.add(des);
                }
                keep = 0;
                break;
            }
        }
        return keep;
    }

    public int checkDrink(Drink drinkmenu) {
        int keep = 1;
        for (int i = 0; i < showdrink.size(); i++) {//for check
            Drink check = (Drink) showdrink.get(i);
            if (check.getPosition() == drinkmenu.getPosition()) {
                if (check.getNumbers() != drinkmenu.getNumbers()) {
                    showdrink.remove(i);
                    showdrink.add(drinkmenu);
                }
                keep = 0;
                break;
            }
        }
        return keep;
    }

    public void saveDessertdata() {
        File f = new File("DessertData.data");
        if (f.exists()) {
            f.delete();
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
        File f = new File("DrinkData.data");
        if (f.exists()) {
            f.delete();
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

    public void reviveDes(Dessert des) {
        switch (des.getPosition()) {
            case 1:
                ti.setText(Integer.toString(des.getNumbers()));
                break;
            case 2:
                choc.setText(Integer.toString(des.getNumbers()));
                break;
            case 3:
                ban.setText(Integer.toString(des.getNumbers()));
                break;
            case 4:
                str.setText(Integer.toString(des.getNumbers()));
                break;
            case 5:
                blu.setText(Integer.toString(des.getNumbers()));
                break;
            case 6:
                tof.setText(Integer.toString(des.getNumbers()));
                break;
            case 7:
                coco.setText(Integer.toString(des.getNumbers()));
                break;
            case 8:
                red.setText(Integer.toString(des.getNumbers()));
                break;
            case 9:
                brown.setText(Integer.toString(des.getNumbers()));
                break;
            case 10:
                eg.setText(Integer.toString(des.getNumbers()));
            default:
                System.out.print("");
        }//switch
    }

    public void reviveDrink(Drink drinmenu) {
        switch (drinkmenu.getPosition()) {
            case 11:
                hess.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 12:
                hlatt.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 13:
                hcappu.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 14:
                hamer.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 15:
                hmoch.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 16:
                hmat.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 17:
                hblack.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 18:
                hchoco.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 19:
                hcaram.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 20:
                hfruit.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            //hotdrink
            case 21:
                iess.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 22:
                ilatt.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 23:
                hcappu.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 24:
                iamer.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 25:
                imoch.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 26:
                imat.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 27:
                iblack.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 28:
                ichoco.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 29:
                icaram.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 30:
                ifruit.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            //icedrink
            case 31:
                fess.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 32:
                flatt.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 33:
                fcappu.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 34:
                famer.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 35:
                fmoch.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 36:
                fmat.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 37:
                fblack.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 38:
                fchoco.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 39:
                fcaram.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            case 40:
                ffruit.setText(Integer.toString(drinkmenu.getNumbers()));
                break;
            default:
                System.out.print("");

        }//switch   
    }
    
    public boolean isdigit(String check){
        boolean numeric = true;
        try {
            Double num = Double.parseDouble(check);
        } catch (NumberFormatException e) {
            numeric = false;
        }
        return numeric;
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
            saveDessertdata();
            saveDrinkdata();
            deslist = new ArrayList<Dessert>();//เคลียข้อมูลในlistใหม่
            drinklist = new ArrayList<Drink>();//เคลียข้อมูลในlistใหม่
            if (sum > 0) {
                fr.dispose();
                new Final_Bill();
            }
        }
        if (ae.getSource().equals(logout)) {
            fr.dispose();
            new Login();
        }
        if (ae.getSource().equals(reset)) {
            ti.setText(null);
            choc.setText(null);
            ban.setText(null);
            str.setText(null);
            blu.setText(null);
            tof.setText(null);
            coco.setText(null);
            red.setText(null);
            brown.setText(null);
            eg.setText(null);
            hess.setText(null);
            hlatt.setText(null);
            hcappu.setText(null);
            hamer.setText(null);
            hmoch.setText(null);
            hmat.setText(null);
            hblack.setText(null);
            hchoco.setText(null);
            hcaram.setText(null);
            hfruit.setText(null);
            iess.setText(null);
            ilatt.setText(null);
            icappu.setText(null);
            iamer.setText(null);
            imoch.setText(null);
            imat.setText(null);
            iblack.setText(null);
            ichoco.setText(null);
            icaram.setText(null);
            ifruit.setText(null);
            fess.setText(null);
            flatt.setText(null);
            fcappu.setText(null);
            famer.setText(null);
            fmoch.setText(null);
            fmat.setText(null);
            fblack.setText(null);
            fchoco.setText(null);
            fcaram.setText(null);
            ffruit.setText(null);
            cal_drink.setText(null);
            cal_dessert.setText(null);
            vat7.setText(null);
            last.setText(null);
            showdes = new ArrayList<Dessert>();
            showdrink = new ArrayList<Drink>();
        }
    }

    @Override
    public void run() {
        try {
            while (close == 0) {
                keeporder(ti);
                keeporder(choc);
                keeporder(ban);
                keeporder(str);
                keeporder(blu);
                keeporder(tof);
                keeporder(coco);
                keeporder(red);
                keeporder(brown);
                keeporder(eg); //dessert
                keeporder(hess);
                keeporder(hlatt);
                keeporder(hcappu);
                keeporder(hamer);
                keeporder(hmoch);
                keeporder(hmat);
                keeporder(hblack);
                keeporder(hchoco);
                keeporder(hcaram);
                keeporder(hfruit); //hotdrink
                keeporder(iess);
                keeporder(ilatt);
                keeporder(icappu);
                keeporder(iamer);
                keeporder(imoch);
                keeporder(imat);
                keeporder(iblack);
                keeporder(ichoco);
                keeporder(icaram);
                keeporder(ifruit); //icedrink
                keeporder(fess);
                keeporder(flatt);
                keeporder(fcappu);
                keeporder(famer);
                keeporder(fmoch);
                keeporder(fmat);
                keeporder(fblack);
                keeporder(fchoco);
                keeporder(fcaram);
                keeporder(ffruit); //frappedrink
                int calcu = 0;
                for (int i = 0; i < showdes.size(); i++) {//for check
                    des = (Dessert) showdes.get(i);
                    calcu += des.getPrices() * des.getNumbers();
                }
                cal_dessert.setText(Integer.toString(calcu));
                int save = calcu;
                for (int i = 0; i < showdrink.size(); i++) {//for check
                    drinkmenu = (Drink) showdrink.get(i);
                    calcu += drinkmenu.getPrices() * drinkmenu.getNumbers();
                }
                sum = calcu;
                cal_drink.setText(Integer.toString(calcu - save));
                vat7.setText(Integer.toString(calcu * 7 / 100));
                last.setText(Integer.toString(calcu + (calcu * 7 / 100)));
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
        }

    }

    @Override
    public void windowOpened(WindowEvent we) {

        if (show == 1) {
            try {
                FileInputStream fin = new FileInputStream("DrinkData.data");
                ObjectInputStream in = new ObjectInputStream(fin);
                drinklist = (ArrayList<Drink>) in.readObject();
                in.close();
                fin.close();
            } catch (IOException i) {
                System.out.println("create drink data");
            } catch (ClassNotFoundException c) {
                System.out.println("create drink data");
            }
            try {
                FileInputStream fin = new FileInputStream("DessertData.data");
                ObjectInputStream in = new ObjectInputStream(fin);
                deslist = (ArrayList<Dessert>) in.readObject();
                in.close();
                fin.close();
            } catch (IOException i) {
                System.out.println("create drink data");
            } catch (ClassNotFoundException c) {
                System.out.println("create drink data");
            }
            for (int i = 0; i < deslist.size(); i++) {//for check
                des = (Dessert) deslist.get(i);
                reviveDes(des);
            }
            for (int i = 0; i < drinklist.size(); i++) {//for check
                drinkmenu = (Drink) drinklist.get(i);
                reviveDrink(drinkmenu);
            }
            deslist = new ArrayList<Dessert>();//เคลียข้อมูลในlistใหม่
            drinklist = new ArrayList<Drink>();//เคลียข้อมูลในlistใหม่
        }

    }

    @Override
    public void windowClosed(WindowEvent we) {
        close = 1;
    }

    @Override
    public void windowClosing(WindowEvent we) {

    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }

}
