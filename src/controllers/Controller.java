package controllers;

import tickets.Ticket;

/**
 * Created by john_ on 02.11.2016.
 */
public final class Controller {

    public static void check(Ticket ticket)
    {
        if(ticket==null)
        {
            System.out.println("The ticket is fake");
            return;
        }
        if(ticket.isChecked())
        {
            System.out.println("This ticket was checked. You cannot use it again.");
        }
        else
        {
            ticket.setChecked(true);
            System.out.println("All right. Ticket has just been checked");
        }
    }
}
