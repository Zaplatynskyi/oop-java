package ticketOffices;

import dateTimePackage.DateTime;
import tickets.CinemaTicket;
import tickets.Ticket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by john_ on 31.10.2016.
 */
public class CinemaTicketOffice extends TicketOffice {

    private HashSet<CinemaTicket> freeTickets;
    private HashSet<CinemaTicket> allTickets;

    public CinemaTicketOffice(HashSet<CinemaTicket> tickets) {
        freeTickets = tickets;
        allTickets=new HashSet<>(tickets);

    }

    public CinemaTicketOffice() {

    }

    public HashSet<CinemaTicket> getFreeTickets() {
        return freeTickets;
    }

    private boolean hasId(int id)
    {
        for (CinemaTicket ticket:freeTickets) {
            if(ticket.getId()==id)return true;
        }
        return false;
    }

    private boolean hasIdAll(int id)
    {
        for (CinemaTicket ticket:allTickets) {
            if(ticket.getId()==id)return true;
        }
        return false;
    }

    public CinemaTicket getById(int id)
    {
        for (CinemaTicket ticket:freeTickets) {
            if(ticket.getId()==id)return ticket;
        }
        return null;
    }

    public CinemaTicket getByIdAll(int id)
    {
        for (CinemaTicket ticket:allTickets) {
            if(ticket.getId()==id)return ticket;
        }
        return null;
    }



    @Override
    public void sellTicket(int id) {
        if(hasId(id)) {
            CinemaTicket current = getById(id);
            freeTickets.remove(current);
            current.setTimeSelling(DateTime.Now());
            System.out.println("You have just bought the ticket");
            System.out.println(current);
        }
        else
        {
            System.out.println("Sorry, but it ticket is busy");
        }
    }

    @Override
    public boolean returnTicket(int id) {
        if (hasId(id) || !hasIdAll(id)) {
            System.out.println("It is fake ticket");
        }  else {
            if(hasIdAll(id)) {
                CinemaTicket current = getByIdAll(id);
                if(current.isChecked()) {
                    System.out.println("This ticket was used. You cannot return it");
                    return false;
                }
                else {

                    if (current.getStart().isBigger(DateTime.Now())) {
                        current.setTimeSelling(null);
                        freeTickets.add(current);
                        System.out.println("You have already returned the ticket");
                        return true;
                    } else {
                        System.out.println("Sorry, but it's too late to return the ticket");
                    }
                }
            }
        }
        return false;
    }

    public void printFilms()
    {
        for (CinemaTicket film:freeTickets)
        {
            System.out.println(""+film.getId()+" "+film.getFilm()+" "+film.getStart());
        }
    }

    @Override
    public void printAvaibleTickets() {
        for(Ticket t:freeTickets)
        {
            System.out.println(t);
        }
        System.out.println();
    }
}
