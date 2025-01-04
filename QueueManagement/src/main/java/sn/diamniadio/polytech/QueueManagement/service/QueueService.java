package sn.diamniadio.polytech.QueueManagement.service;

import sn.diamniadio.polytech.QueueManagement.model.Location;
import sn.diamniadio.polytech.QueueManagement.model.Service;

import java.util.ArrayList;
import java.util.List;

public class QueueService {
    private List<Service> services = new ArrayList<>();

    public QueueService() {
        initializeServices();
    }

    // Initialise les services et localisations
    private void initializeServices() {
        // Localisations pour chaque service
        List<Location> seneauLocations = List.of(
                new Location("Dakar"), new Location("Thiès")
        );
        List<Location> orangeLocations = List.of(
                new Location("Dakar"), new Location("Saint-Louis")
        );
        List<Location> senelecLocations = List.of(
                new Location("Pikine"), new Location("Guediawaye"), new Location("Rufisque")
        );
        List<Location> freeLocations = List.of(
                new Location("Grand-Yoff"), new Location("Mariste"), new Location("Golf")
        );
        List<Location> proMobileLocations = List.of(
                new Location("Sacre-Cœur"), new Location("Golf"), new Location("Grand-Yoff")
        );
        List<Location> expressoLocations = List.of(
                new Location("Mariste"), new Location("Pikine"), new Location("Guediawaye")
        );

        // Ajout des services avec leurs localisations respectives
        services.add(new Service("Seneau", seneauLocations));
        services.add(new Service("Orange", orangeLocations));
        services.add(new Service("Senelec", senelecLocations));
        services.add(new Service("Free", freeLocations));
        services.add(new Service("ProMobile", proMobileLocations));
        services.add(new Service("Expresso", expressoLocations));
    }

    // Retourne tous les services
    public List<Service> getServices() {
        return services;
    }

    // Retourne un service par son nom
    public Service getServiceByName(String serviceName) {
        for (Service service : services) {
            if (service.getName().equalsIgnoreCase(serviceName)) {
                return service;
            }
        }
        return null;
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
        return null;
    }
}
