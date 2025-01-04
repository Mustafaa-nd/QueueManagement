package sn.diamniadio.polytech.QueueManagement.service;

import sn.diamniadio.polytech.QueueManagement.model.Agent;
import sn.diamniadio.polytech.QueueManagement.model.Location;
import sn.diamniadio.polytech.QueueManagement.model.Service;

import java.util.ArrayList;
import java.util.List;

public class QueueService {
    private final List<Service> services = new ArrayList<>();
    private final List<Agent> agents = new ArrayList<>();

    public QueueService() {
        initializeServices();
        initializeAgents();
    }

    // Initialise les services et leurs localisations
    private void initializeServices() {
        List<Location> senelecLocations = List.of(
                new Location("Pikine"),
                new Location("Guédiawaye")
        );
        List<Location> freeLocations = List.of(
                new Location("Rufisque"),
                new Location("Grand-Yoff")
        );

        services.add(new Service("Senelec", senelecLocations));
        services.add(new Service("Free", freeLocations));
    }

    // Initialise les agents
    private void initializeAgents() {
        for (Service service : services) {
            for (Location location : service.getLocations()) {
                // Chaque service et localisation reçoit un agent unique
                agents.add(new Agent("Agent - " + service.getName() + " - " + location.getName(), service, location));
            }
        }
    }

    public Agent getAgentByServiceAndLocation(String serviceName, String locationName) {
        for (Agent agent : agents) {
            if (agent.getService().getName().equalsIgnoreCase(serviceName) &&
                    agent.getLocation().getName().equalsIgnoreCase(locationName)) {
                return agent;
            }
        }
        return null;
    }

    // Retourne tous les services
    public List<Service> getServices() {
        return services;
    }

    // Trouve un service par son nom
    public Service getServiceByName(String serviceName) {
        for (Service service : services) {
            if (service.getName().equalsIgnoreCase(serviceName)) {
                return service;
            }
        }
        return null; // Retourne null si aucun service ne correspond
    }

    // Trouve une localisation par son nom
    public Location getLocationByName(String locationName) {
        for (Service service : services) {
            for (Location location : service.getLocations()) {
                if (location.getName().equalsIgnoreCase(locationName)) {
                    return location;
                }
            }
        }
        return null; // Retourne null si aucune localisation ne correspond
    }

    // Retourne tous les agents
    public List<Agent> getAgents() {
        return agents;
    }

    // Retourne un agent par son nom
    public Agent getAgentByName(String name) {
        for (Agent agent : agents) {
            if (agent.getName().equalsIgnoreCase(name)) {
                return agent;
            }
        }
        return null; // Retourne null si aucun agent ne correspond
    }
}
