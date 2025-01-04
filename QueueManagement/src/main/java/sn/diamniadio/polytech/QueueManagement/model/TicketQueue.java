package sn.diamniadio.polytech.QueueManagement.model;

import java.util.LinkedList;
import java.util.Queue;

public class TicketQueue {
    private int currentTicketNumber = 0; // Le dernier ticket émis
    private int currentProcessedNumber = 0; // Le ticket actuellement traité
    private Queue<Ticket> tickets = new LinkedList<>();

    // Émettre un ticket
    public Ticket issueTicket() {
        Ticket newTicket = new Ticket(++currentTicketNumber);
        tickets.add(newTicket);
        return newTicket;
    }

    // Passer au client suivant
    public void nextClient() {
        if (!tickets.isEmpty()) {
            tickets.poll();
            currentProcessedNumber++;
        }
    }

    // Obtenir la position dans la file
    public int getPositionInQueue(Ticket ticket) {
        return tickets.size(); // Nombre de personnes encore dans la file
    }

    // Obtenir le nombre de personnes devant
    public int getPeopleAhead() {
        return tickets.size() - 1; // Exclut le ticket actuel
    }

    // Obtenir le ticket actuellement traité
    public int getCurrentProcessedNumber() {
        return currentProcessedNumber;
    }
}
