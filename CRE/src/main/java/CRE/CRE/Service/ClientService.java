package CRE.CRE.Service;

import CRE.CRE.Repository.ClientRepository;
import CRE.CRE.dto.*;
import CRE.CRE.dto.ClientPPDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Récupérer tous les clients PP
    public List<ClientPPDTO> getAllClientsPP() {
        return clientRepository.findAllClientsPP();
    }

    // Récupérer tous les clients PM
    public List<ClientPMDTO> getAllClientsPM() {
        return clientRepository.findAllClientsPM();
    }
    public List<ClientPPDTO> getClientsPPByOpeningDate(LocalDate startDate, LocalDate endDate) {
        return clientRepository.findClientsPPByOpeningDate(startDate, endDate);
    }

    public List<ClientPMDTO> getClientsPMByOpeningDate(LocalDate startDate, LocalDate endDate) {
        return clientRepository.findClientsPMByOpeningDate(startDate, endDate);
    }

    public ClientPPDTO getClientPPByCli(String cli) {
        return clientRepository.findClientPPByCli(cli);
    }

    public ClientPMDTO getClientPMByCli(String cli) {
        return clientRepository.findClientPMByCli(cli);
    }
}
