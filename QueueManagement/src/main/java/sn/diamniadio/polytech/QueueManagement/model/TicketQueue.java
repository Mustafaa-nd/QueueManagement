package sn.diamniadio.polytech.QueueManagement.model;

import java.util.Queue;
import java.util.LinkedList;

public class TicketQueue {
    private int currentTicketNumber = 0; // Dernier ticket émis
    private int currentProcessedNumber = 0; // Ticket actuellement traité
    private Queue<Ticket> tickets = new LinkedList<>();

    // Émettre un ticket
    public Ticket issueTicket() {
        Ticket newTicket = new Ticket(++currentTicketNumber);
        tickets.add(newTicket);

        // Si c'est le premier ticket, il devient immédiatement celui en cours de traitement
        if (currentProcessedNumber == 0) {
            currentProcessedNumber = newTicket.getTicketNumber();
        }

        return newTicket;
    }

    // Passer au client suivant
    public void nextClient() {
        if (!tickets.isEmpty()) {
            tickets.poll(); // Retire le ticket de la tête de file
            if (!tickets.isEmpty()) {
                currentProcessedNumber = tickets.peek().getTicketNumber(); // Passe au suivant
            } else {
                currentProcessedNumber = 0; // Plus de clients à traiter
            }
        }
    }

    // Revenir au client précédent
    public void previousClient() {
        if (currentProcessedNumber > 1) {
            currentProcessedNumber--;
        }
    }

    // Obtenir le numéro actuellement traité
    public int getCurrentProcessedNumber() {
        return currentProcessedNumber;
    }

    // Obtenir la position dans la file pour un ticket spécifique
    public int getPositionInQueue(Ticket ticket) {
        int position = 1;
        for (Ticket t : tickets) {
            if (t.getTicketNumber() == ticket.getTicketNumber()) {
                return position;
            }
            position++;
        }
        return -1; // Ticket non trouvé
    }

    // Obtenir le nombre de personnes devant un ticket spécifique
    public int getPeopleAhead() {
        return tickets.size() - 1; // Exclut le ticket en cours
    }

    // Vérifier si la file est vide
    public boolean isQueueEmpty() {
        return tickets.isEmpty();
    }

    // Obtenir tous les tickets restants dans la file
    public Queue<Ticket> getTickets() {
        return tickets;
    }
}
