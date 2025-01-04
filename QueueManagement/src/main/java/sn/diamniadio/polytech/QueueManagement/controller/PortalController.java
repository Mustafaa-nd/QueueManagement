package sn.diamniadio.polytech.QueueManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sn.diamniadio.polytech.QueueManagement.model.Location;
import sn.diamniadio.polytech.QueueManagement.model.Service;
import sn.diamniadio.polytech.QueueManagement.model.Ticket;
import sn.diamniadio.polytech.QueueManagement.model.TicketQueue;
import sn.diamniadio.polytech.QueueManagement.service.QueueService;

@Controller
public class PortalController {
    private QueueService queueService = new QueueService();

    // Page d'accueil qui affiche tous les services
    @GetMapping("/")
    public String showPortal(Model model) {
        model.addAttribute("services", queueService.getServices());
        return "portal";
    }

    // Affiche les localisations d'un service sélectionné
    @PostMapping("/select-location")
    public String selectLocation(@RequestParam String serviceName, Model model) {
        Service selectedService = queueService.getServiceByName(serviceName);
        if (selectedService == null) {
            model.addAttribute("error", "Service introuvable !");
            return "error";
        }
        model.addAttribute("locations", selectedService.getLocations());
        return "locations";
    }

    // Génère un ticket pour une localisation donnée
    @PostMapping("/get-ticket")
    public String getTicket(@RequestParam String locationName, Model model) {
        Location location = queueService.getLocationByName(locationName);
        if (location == null) {
            model.addAttribute("error", "Localisation introuvable !");
            return "error";
        }

        TicketQueue queue = location.getQueue();
        Ticket ticket = queue.issueTicket();

        model.addAttribute("ticketNumber", ticket.getTicketNumber());
        model.addAttribute("position", queue.getPositionInQueue(ticket));
        model.addAttribute("peopleAhead", queue.getPeopleAhead());
        model.addAttribute("currentProcessed", queue.getCurrentProcessedNumber());

        return "ticket";
    }
}
