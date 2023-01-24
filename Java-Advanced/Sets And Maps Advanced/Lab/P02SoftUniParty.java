package setsAndMapsAdvanced.lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String ticket = scanner.nextLine();
        Set<String> ticketSet = new TreeSet<>();
        while (!ticket.equals("PARTY")) {
            ticketSet.add(ticket);

            ticket = scanner.nextLine();
        }

        String guest = scanner.nextLine();
        while (!guest.equals("END")) {
            ticketSet.remove(guest);
            guest = scanner.nextLine();
        }
        System.out.println(ticketSet.size());
        ticketSet.forEach(System.out::println);

    }
}
