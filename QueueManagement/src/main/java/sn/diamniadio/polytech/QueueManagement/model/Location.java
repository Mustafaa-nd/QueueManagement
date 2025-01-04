package sn.diamniadio.polytech.QueueManagement.model;

public class Location {
    private String name;
    private TicketQueue queue;

    public Location(String name) {
        this.name = name;
        this.queue = new TicketQueue();
    }

    public String getName() {
        return name;
    }

    public TicketQueue getQueue() {
        return queue;
    }
}
