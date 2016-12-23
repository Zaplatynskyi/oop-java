package workWithFiles;

import dateTimePackage.DateTime;
import dateTimePackage.Time;
import javafx.beans.binding.DoubleBinding;
import org.jetbrains.annotations.NotNull;
import tickets.BusTicket;
import tickets.CinemaTicket;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by john_ on 01.11.2016.
 */
public final class Reader {

    public static HashSet<CinemaTicket> readCinemaTickets(@NotNull String fileName) {
        HashSet<CinemaTicket> tickets = new HashSet<>();
        File file = new File(fileName);
        try (FileReader reader = new FileReader(file)) {
            char[] charText = new char[(int) file.length()];
            reader.read(charText);
            String text = new String(charText);
            StringTokenizer tokenizer = new StringTokenizer(text, "\r\n");
            ArrayList<String> rows = new ArrayList<>();
            while (tokenizer.hasMoreTokens()) {
                rows.add(tokenizer.nextToken());
            }
            for (String s : rows) {
                tokenizer = new StringTokenizer(s, " ");
                ArrayList<String> ticketElem = new ArrayList<>();
                while (tokenizer.hasMoreTokens()) {
                    ticketElem.add(tokenizer.nextToken());
                }
                CinemaTicket ticket = new CinemaTicket(false, Double.parseDouble(ticketElem.get(1)), null, new DateTime(ticketElem.get(3) + " " + ticketElem.get(4)), ticketElem.get(2), ticketElem.get(0), new Time(ticketElem.get(5)),1);
                tickets.add(ticket);
                ticket = new CinemaTicket(false, Double.parseDouble(ticketElem.get(1)), null, new DateTime(ticketElem.get(3) + " " + ticketElem.get(4)), ticketElem.get(2), ticketElem.get(0), new Time(ticketElem.get(5)),2);
                tickets.add(ticket);
                ticket = new CinemaTicket(false, Double.parseDouble(ticketElem.get(1)), null, new DateTime(ticketElem.get(3) + " " + ticketElem.get(4)), ticketElem.get(2), ticketElem.get(0), new Time(ticketElem.get(5)),3);
                tickets.add(ticket);
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return tickets;
    }


    public static HashSet<BusTicket> readBusTickets(@NotNull String fileName)
    {
        HashSet<BusTicket> tickets = new HashSet<>();
        File file = new File(fileName);
        try (FileReader reader = new FileReader(file)) {
            char[] charText = new char[(int) file.length()];
            reader.read(charText);
            String text = new String(charText);
            StringTokenizer tokenizer = new StringTokenizer(text, "\r\n");
            ArrayList<String> rows = new ArrayList<>();
            while (tokenizer.hasMoreTokens()) {
                rows.add(tokenizer.nextToken());
            }
            for (String s : rows) {
                tokenizer = new StringTokenizer(s, " ");
                ArrayList<String> ticketElem = new ArrayList<>();
                while (tokenizer.hasMoreTokens()) {
                    ticketElem.add(tokenizer.nextToken());
                }

                BusTicket ticket = new BusTicket(false,Double.parseDouble(ticketElem.get(6)),null,new DateTime(ticketElem.get(1)+" "+ticketElem.get(2)),new DateTime(ticketElem.get(4)+" "+ticketElem.get(5)),Integer.parseInt(ticketElem.get(7)),ticketElem.get(0), ticketElem.get(3));

                tickets.add(ticket);
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return tickets;
    }

    public static void main(String[] args)
    {
        HashSet<CinemaTicket> cinemaTickets = readCinemaTickets("E:\\Music\\filmTicketsAvailable.txt");
        for (CinemaTicket ticket:cinemaTickets)
        {
            System.out.println(ticket);
        }
    }
}
