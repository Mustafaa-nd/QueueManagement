package sn.diamniadio.polytech.QueueManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sn.diamniadio.polytech.QueueManagement.model.Agent;
import sn.diamniadio.polytech.QueueManagement.model.Service;
import sn.diamniadio.polytech.QueueManagement.model.TicketQueue;
import sn.diamniadio.polytech.QueueManagement.service.QueueService;

@Controller
public class AgentController {
    private QueueService queueService = new QueueService();

    // Affiche le tableau de bord de l'agent pour un service et une localisation
    @GetMapping("/agent-dashboard")
    public String agentDashboard(@RequestParam String serviceName, @RequestParam String locationName, Model model) {
        Service service = queueService.getServiceByName(serviceName);
        if (service == null) {
            model.addAttribute("error", "Service introuvable");
            return "error";
        }

        Agent agent = queueService.getAgentByServiceAndLocation(serviceName, locationName);
        if (agent == null) {
            model.addAttribute("error", "Agent introuvable pour cette localisation et ce service");
            return "error";
        }

        TicketQueue queue = agent.getLocation().getQueue();

        model.addAttribute("agentName", agent.getName());
        model.addAttribute("serviceName", agent.getService().getName());
        model.addAttribute("locationName", agent.getLocation().getName());
        model.addAttribute("currentProcessed", queue.getCurrentProcessedNumber());
        model.addAttribute("tickets", queue.getTickets());
        return "select-agent";
    }
}
