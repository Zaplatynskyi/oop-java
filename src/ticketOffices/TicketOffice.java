package ticketOffices;

import tickets.Ticket;

/**
 * Created by john_ on 31.10.2016.
 */
public abstract class TicketOffice {

    public abstract void sellTicket(int id);

    public abstract boolean returnTicket(int id);

    public abstract void printAvaibleTickets();
}
