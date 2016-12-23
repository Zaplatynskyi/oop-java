package tickets;

import dateTimePackage.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by john_ on 31.10.2016.
 */
public class BusTicket extends Ticket {

    private DateTime departure;
    private DateTime arrival;
    private String startPlace;
    private String destination;

    public BusTicket(){super();}

    public BusTicket(boolean checked, double price, DateTime timeSelling, DateTime departure, DateTime arrival, int seat, String startPlace, String destination) {
        super(checked, price, timeSelling,seat);
        this.departure = departure;
        this.arrival = arrival;
        this.startPlace = startPlace;
        this.destination = destination;
    }

    public DateTime getDeparture() {
        return departure;
    }

    @Override
    public int hashCode() {
        return getId();
    }

    public void setDeparture(DateTime departure) {
        this.departure = departure;
    }

    public DateTime getArrival() {
        return arrival;
    }

    public void setArrival(DateTime arrival) {
        this.arrival = arrival;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return ""+getId()+" "+getStartPlace()+" "+getDeparture()+" "+getDestination()+" "+getArrival()+ " "+getPrice()+" "+getSeat()+" "+(getTimeSelling()==null?"":getTimeSelling());
    }
}
