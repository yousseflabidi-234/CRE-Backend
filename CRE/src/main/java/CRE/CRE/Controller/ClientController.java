package CRE.CRE.Controller;

import CRE.CRE.Exception.*;
import CRE.CRE.Service.ClientService;
import CRE.CRE.dto.ClientPPDTO;
import CRE.CRE.dto.ClientPMDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/pp/all")
    public List<ClientPPDTO> getAllClientsPP() {
        List<ClientPPDTO> clients = clientService.getAllClientsPP();
        if (clients.isEmpty()) {
            throw new ClientPPException("No PP clients found.");
        }
        return clients;

    }

    @GetMapping("/pm/all")
    public List<ClientPMDTO> getAllClientsPM() {
        List<ClientPMDTO> clients = clientService.getAllClientsPM();
        if (clients.isEmpty()) {
            throw new ClientPMException("No PM clients found.");
        }
        return clients;    }

    @GetMapping("/pp")
    public ResponseEntity<List<ClientPPDTO>> getClientsPPByOpeningDate(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<ClientPPDTO> clients = clientService.getClientsPPByOpeningDate(startDate, endDate);
        if (clients.isEmpty()) {
            throw new ClientPPException("No PP clients found between " + startDate + " and " + endDate + ".");
        }
        return ResponseEntity.ok(clients);

    }

    @GetMapping("/pm")
    public ResponseEntity<List<ClientPMDTO>> getClientsPMByOpeningDate(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<ClientPMDTO> clients = clientService.getClientsPMByOpeningDate(startDate, endDate);
        if (clients.isEmpty()) {
            throw new ClientPMException("No PM clients found between " + startDate + " and " + endDate + ".");
        }
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/pp/{cli}")
    public ResponseEntity<ClientPPDTO> getClientPPByCli(@PathVariable String cli) {
        ClientPPDTO client = clientService.getClientPPByCli(cli);
        if (client == null) {
            throw new ClientPPException("PP client with ID " + cli + " not found.");
        }
        return ResponseEntity.ok(client);
    }

    @GetMapping("/pm/{cli}")
    public ResponseEntity<ClientPMDTO> getClientPMByCli(@PathVariable String cli) {
        ClientPMDTO client = clientService.getClientPMByCli(cli);
        if (client == null) {
            throw new ClientPMException("PM client with ID " + cli + " not found.");
        }
        return ResponseEntity.ok(client);
    }
}
