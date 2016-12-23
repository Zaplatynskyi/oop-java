package dateTimePackage;


import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by john_ on 01.11.2016.
 */
public final class DateTime {

    private int year, month, day, hour, minute, second;

    public DateTime() {
        this(Now());
    }

    public DateTime(DateTime other)
    {
        year= other.getYear();
        month= other.getMonth();
        day= other.getDay();
        hour= other.getHour();
        minute= other.getMinute();
        second= other.getSecond();
    }

    public DateTime(String s) {
        StringTokenizer token = new StringTokenizer(s, "-: ");
        ArrayList<String> dateElem = new ArrayList<>();
        while (token.hasMoreTokens()) {
            dateElem.add(token.nextToken());
        }
        year = Integer.parseInt(dateElem.get(0));
        month = Integer.parseInt(dateElem.get(1));
        day = Integer.parseInt(dateElem.get(2));
        hour = Integer.parseInt(dateElem.get(3));
        minute = Integer.parseInt(dateElem.get(4));
        second = Integer.parseInt(dateElem.get(5));
    }

    public DateTime(int year, int month, int day, int hour, int minute, int second) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public static DateTime Now() {
        return new DateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
    }

    public void setDay(int day) {
        this.day = day;
    }

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

    public boolean isBigger(DateTime other) {
        if (this.year > other.year) return true;
        else {
            if (this.year == other.year) {
                if (this.month > other.month) return true;
                else if (this.month == other.month) {
                    if (this.day > other.day) return true;
                    else if (this.day == other.day) {
                        if (this.hour > other.hour) return true;
                        else return false;
                    }
                }
            } else return false;
            return false;
        }
    }

    @Override
    public String toString() {
        return ""+year+"-"+month+"-"+day+"  "+hour+":"+minute+":"+second;
    }


}