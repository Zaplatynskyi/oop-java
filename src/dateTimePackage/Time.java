package dateTimePackage;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by john_ on 01.11.2016.
 */
public class Time {
    private int hour, minute, second;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public Time(){}

    public Time(Time other)
    {

        hour= other.getHour();
        minute= other.getMinute();
        second= other.getSecond();
    }

    public Time(String s) {
        StringTokenizer token = new StringTokenizer(s, ":");
        ArrayList<String> dateElem = new ArrayList<>();
        while (token.hasMoreTokens()) {
            dateElem.add(token.nextToken());
        }
        hour = Integer.parseInt(dateElem.get(0));
        minute = Integer.parseInt(dateElem.get(1));
        second = Integer.parseInt(dateElem.get(2));
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public String toString() {
        return ""+hour+":"+minute+":"+second;
    }
}
