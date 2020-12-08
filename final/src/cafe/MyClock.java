package cafe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;



public class MyClock extends JLabel implements Runnable {
    public void run() {
          
            try {
                while (true){
                    Calendar d = Calendar.getInstance();
                    int date = d.get(Calendar.DATE);
                    int month = d.get(Calendar.MONTH) + 1;
                    int year = d.get(Calendar.YEAR);
                    int sec = d.get(Calendar.SECOND);
                    int min = d.get(Calendar.MINUTE);
                    int hour = d.get(Calendar.HOUR_OF_DAY);
                    setFont(new Font("TimesRoman", Font.BOLD, 18));

                    if(Integer.toString(hour).length() == 1){
                        setText(" " + Integer.toString(date) + "/" + Integer.toString(month) + "/" + Integer.toString(year) + " " + "0" + Integer.toString(hour) + " : " + Integer.toString(min) + " : " + Integer.toString(sec));
                    }else if(Integer.toString(min).length() == 1){
                        setText(" " + Integer.toString(date) + "/" + Integer.toString(month) + "/" + Integer.toString(year) + "  " + Integer.toString(hour) + " : 0" + Integer.toString(min) + " : " + Integer.toString(sec));
                    }else if(Integer.toString(sec).length() == 1){
                        setText(" " + Integer.toString(date) + "/" + Integer.toString(month) + "/" + Integer.toString(year) +  "  " + Integer.toString(hour) + " : " + Integer.toString(min) + " : 0" + Integer.toString(sec));
                    }else{
                        setText(" " + Integer.toString(date) + "/" + Integer.toString(month) + "/" + Integer.toString(year) +  "  " + Integer.toString(hour) + " : " + Integer.toString(min) + " : " + Integer.toString(sec));
                    }
                    Thread.sleep(1000);
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(MyClock.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
}
