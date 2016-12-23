package interactiveWithUser;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.org.apache.xpath.internal.patterns.ContextMatchStepPattern;
import controllers.Controller;
import ticketOffices.BusTicketOffice;
import ticketOffices.CinemaTicketOffice;
import tickets.BusTicket;
import tickets.CinemaTicket;
import workWithFiles.Reader;

import javax.swing.*;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by john_ on 02.11.2016.
 */
public class InteractiveConsole {



    public static void main(String[] args)
    {
        boolean exit =false;
        CinemaTicketOffice cinemaTicketOffice = new CinemaTicketOffice(Reader.readCinemaTickets("E:\\Music\\filmTicketsAvailable.txt"));
        BusTicketOffice busTicketOffice = new BusTicketOffice(Reader.readBusTickets("E:\\Music\\busTicketsAvailable.txt"));
        HashSet<CinemaTicket> cinemaTickets = new HashSet<>();
        HashSet<BusTicket> busTickets = new HashSet<>();
        while(exit==false)
        {
            System.out.println("What do you want to do:\n   1 - buy ticket \t 2 - return ticket \t 3 - use ticket");
            Scanner scanner = new Scanner(System.in);
            int choice1 = scanner.nextInt();
            switch (choice1)
            {
                case 1: {
                    int choice2 = Choice2();
                    switch (choice2)
                    {
                        case 1:
                        {
                            cinemaTicketOffice.printFilms();
                            System.out.println("Please enter the film you want to see");
                            int choice3 = scanner.nextInt();
                            if(cinemaTicketOffice.getById(choice3)!=null)cinemaTickets.add(cinemaTicketOffice.getById(choice3));
                            cinemaTicketOffice.sellTicket(choice3);
                            break;
                        }

                        case 2:
                        {
                            busTicketOffice.printRoutes();
                            System.out.println("Please enter the rout you want");
                            int choice3 = scanner.nextInt();
                            if(busTicketOffice.getById(choice3)!=null)busTickets.add(busTicketOffice.getById(choice3));
                            busTicketOffice.sellTicket(choice3);
                            break;
                        }
                        default:
                        {
                            System.out.println("Please enter correct choice");
                            break;
                        }
                    }
                    break;
                }
                case 2:
                {
                    int choice2 = Choice2();
                    switch (choice2)
                    {
                        case 1:
                        {
                            if(cinemaTickets.isEmpty())
                                System.out.println("You have no ticket to return");
                            else printCollection(cinemaTickets);
                            System.out.println("Please enter the ticket you want to return");
                            int choice3 = scanner.nextInt();
                            if(cinemaTicketOffice.returnTicket(choice3)) {
                                cinemaTickets.remove(cinemaTicketOffice.getById(choice3));
                            }
                            break;
                        }

                        case 2:
                        {
                            if(busTickets.isEmpty())
                                System.out.println("You have no ticket to return");
                            else printCollection(busTickets);
                            System.out.println("Please enter the ticket you want to return");
                            int choice3 = scanner.nextInt();
                           if(busTicketOffice.returnTicket(choice3))
                           {
                               busTickets.remove(busTicketOffice.getById(choice3));
                           }
                            break;
                        }
                        default:
                        {
                            System.out.println("Please enter correct choice");
                            break;
                        }
                    }

                    break;
                }
                case 3:
                {
                    int choice2 = Choice2();
                    switch (choice2)
                    {
                        case 1:
                        {
                            if(cinemaTickets.isEmpty())
                                System.out.println("You have no ticket to use");
                            else {
                                 printCollection(cinemaTickets);
                                System.out.println("Please enter the ticket you want to use");
                                int choice3 = scanner.nextInt();
                                Controller.check(cinemaTicketOffice.getByIdAll(choice3));
                            }
                            break;
                        }

                        case 2:
                        {
                            if(busTickets.isEmpty())
                                System.out.println("You have no ticket to use");
                            else {
                                printCollection(busTickets);
                                System.out.println("Please enter the ticket you want to use");
                                int choice3 = scanner.nextInt();
                                Controller.check(busTicketOffice.getByIdAll(choice3));
                            }
                            break;
                        }
                        default:
                        {
                            System.out.println("Please enter correct choice");
                            break;
                        }
                    }

                    break;
                }
                default:
                {
                    System.out.println("Please enter correct choice");
                    break;
                }
            }
            System.out.println("If you want to exit enter \n 1 - no \t  2 - yes");
            int choice = scanner.nextInt();
            if(choice==2)exit=true;

        }
    }


    static int Choice2()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wich kind of tickets \n 1 - cinema \t 2 - bus");
        return scanner.nextInt();
    }

    static <T> void printCollection(HashSet<T> items)
    {
        for(T it:items)
        {
            System.out.println(it);
        }
    }
}

