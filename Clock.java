package Clock;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock extends JFrame {

    Calendar calendar; //this calendar object is not needed, just to make it intuitive
    SimpleDateFormat timeFormat, dayFormat, dateFormat;
    JLabel timeLabel, dayLabel, dateLabel;
    String time, day, date; 

    Clock() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("CLOCK GOES TICTACRRRR");
        this.setLayout(null);
        this.setSize(360, 390);
        this.setResizable(false);

        timeFormat = new SimpleDateFormat("kk:mm:ss"); // Setting the time format
        dayFormat = new SimpleDateFormat("E"); // learn how: https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html#year
        dateFormat = new SimpleDateFormat("dd/MM/yy");

        timeLabel = new JLabel("", JLabel.CENTER); // timeLabel Styiling
        timeLabel.setFont(new Font("Montserrat",Font.PLAIN,50));
        timeLabel.setBounds(0,0,360,120);
        timeLabel.setBackground(new Color(237,34,38));
        timeLabel.setForeground(new Color(238,233,233));
        timeLabel.setOpaque(true);

        dayLabel = new JLabel("", JLabel.CENTER); // dayLabel Styiling
        dayLabel.setFont(new Font("Montserrat",Font.PLAIN,50));
        dayLabel.setBounds(0,120,360,120);
        dayLabel.setBackground(new Color(14,17,23));
        dayLabel.setForeground(new Color(238,233,233));
        dayLabel.setOpaque(true);

        dateLabel = new JLabel("", JLabel.CENTER); // dateLabel Styiling
        dateLabel.setFont(new Font("Montserrat",Font.PLAIN,80));
        dateLabel.setBounds(0,240,360,160);
        dateLabel.setBackground(new Color(237,34,38));
        dateLabel.setForeground(new Color(238,233,233));
        dateLabel.setVerticalAlignment(JLabel.TOP);;
        dateLabel.setOpaque(true);

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        setTime();
    }

    public void setTime() {
        while(true){

            time = timeFormat.format(Calendar.getInstance().getTime()); //Setting timeFormat (aka hh.mm.ss) into a String
            timeLabel.setText(time); // Setting said String into the Label Text

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try {
                Thread.sleep(1000); //Uptading the getTime every 1000 milliseconds
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}