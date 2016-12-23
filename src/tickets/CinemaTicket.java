package tickets;

import dateTimePackage.DateTime;
import dateTimePackage.Time;


/**
 * Created by john_ on 31.10.2016.
 */
public class CinemaTicket extends Ticket {

    private DateTime start;
    private String place;
    private String film;
    private Time duration;

    public CinemaTicket(){super();}

    public CinemaTicket(boolean checked, double price, DateTime timeSelling, DateTime start, String place, String film, Time duration, int seat) {
        super(checked, price, timeSelling,seat);
        this.start = start;
        this.place = place;
        this.film = film;
        this.duration = duration;
    }

    @Override
    public int hashCode() {
        return getId();
    }

    public DateTime getStart() {
        return start;
    }

    public void setStart(DateTime start) {
        this.start = start;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return ""+getId()+" "+getFilm()+" "+getStart()+" "+getPlace()+" "+getSeat()+" "+getDuration()+" "+getPrice()+" "+(getTimeSelling()==null?"":getTimeSelling());
    }
}
