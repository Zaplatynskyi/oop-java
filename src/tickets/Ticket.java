package tickets;

import dateTimePackage.DateTime;
import sun.util.resources.LocaleData;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by john_ on 31.10.2016.
 */
public abstract class Ticket {

    private static int count=0;
    private int id;
    private boolean checked;
    private double price;
    private DateTime timeSelling;
    private int seat;


    public Ticket(){
        id=++count;
    }

    public Ticket(boolean checked, double price, DateTime timeSelling, int seat) {
        id=++count;
        this.checked = checked;
        this.price = price;
        this.timeSelling = timeSelling;
        this.setSeat(seat);
    }


    public int getId() {
        return id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DateTime getTimeSelling() {
        return timeSelling;
    }

    public void setTimeSelling(DateTime timeSelling) {
        this.timeSelling = timeSelling;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}
