package sn.diamniadio.polytech.QueueManagement.model;

import java.util.List;

public class Service {
    private String name;
    private List<Location> locations;

    public Service(String name, List<Location> locations) {
        this.name = name;
        this.locations = locations;
    }

    public String getName() {
        return name;
    }

    public List<Location> getLocations() {
        return locations;
    }
}
