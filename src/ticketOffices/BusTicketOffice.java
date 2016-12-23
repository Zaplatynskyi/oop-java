package ticketOffices;

import dateTimePackage.DateTime;
import tickets.BusTicket;
import tickets.Ticket;
import java.util.HashSet;

/**
 * Created by john_ on 31.10.2016.
 */
public class BusTicketOffice extends TicketOffice {

    private HashSet<Integer> routes;
    private HashSet<Integer> seats;
    private HashSet<BusTicket> freeTickets;
    private HashSet<BusTicket> allTickets;

    public BusTicketOffice(HashSet<BusTicket> tickets) {
        freeTickets = tickets;
        allTickets=new HashSet<>(tickets);
    }

    public BusTicketOffice() {
    }

    private boolean hasId(int id) {
        for (BusTicket ticket : freeTickets) {
            if (ticket.getId() == id) return true;
        }
        return false;
    }

    private boolean hasIdAll(int id) {
        for (BusTicket ticket : allTickets) {
            if (ticket.getId() == id) return true;
        }
        return false;
    }

    public BusTicket getById(int id) {
        for (BusTicket ticket : freeTickets) {
            if (ticket.getId() == id) return ticket;
        }
        return null;
    }

    public BusTicket getByIdAll(int id) {
        for (BusTicket ticket : allTickets) {
            if (ticket.getId() == id) return ticket;
        }
        return null;
    }

    @Override
    public void sellTicket(int id) {
        if (hasId(id)) {
            BusTicket current = getById(id);
            freeTickets.remove(current);
            current.setTimeSelling(DateTime.Now());
            System.out.println("You have just bought the ticket");
            System.out.println(current);
        } else {
            System.out.println("Sorry, but it ticket is busy");
        }
    }


    public void printRoutes()
    {
        for(BusTicket ticket:freeTickets)
        {
            System.out.println(ticket.getId()+" "+ticket.getStartPlace()+" "+ticket.getDeparture()+" "+ticket.getDestination());
        }
        System.out.println();
    }

    @Override
    public boolean returnTicket(int id)
    {
        if (hasId(id) || !hasIdAll(id)) {
            System.out.println("It is fake ticket");
        }  else {
            if(hasIdAll(id)) {
                BusTicket current = getByIdAll(id);
                if(current.isChecked()) {
                    System.out.println("This ticket was used. You cannot return it");
                    return false;
                }
                else {

                    if (current.getDeparture().isBigger(DateTime.Now())) {
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

    @Override
    public void printAvaibleTickets()
    {
        for(Ticket t:freeTickets)
        {
            System.out.println(t);
        }
    }
}
