package sn.diamniadio.polytech.QueueManagement.model;

public class Agent {
    private String name;
    private Service service;
    private Location location;

    public Agent(String name, Service service, Location location) {
        this.name = name;
        this.service = service;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Service getService() {
        return service;
    }

    public Location getLocation() {
        return location;
    }
}
