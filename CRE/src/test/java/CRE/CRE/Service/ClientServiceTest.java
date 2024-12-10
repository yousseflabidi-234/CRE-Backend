package CRE.CRE.Service;

import CRE.CRE.Repository.ClientRepository;
import CRE.CRE.dto.ClientPPDTO;
import CRE.CRE.dto.ClientPMDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService1;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    // Test pour getAllClientsPP
    @Test
    public void testGetAllClientsPP() {
        List<ClientPPDTO> mockClients = List.of(new ClientPPDTO("a", "1", "Cin", "14461053", LocalDate.of(2022, 9, 15), "Siliana", LocalDate.of(2032, 9, 7), "djo", "Djo", "M", LocalDate.of(2004, 3, 2), "Marsa", "216", "x"));
        when(clientRepository.findAllClientsPP()).thenReturn(mockClients);

        List<ClientPPDTO> clients = clientService1.getAllClientsPP();

        assertNotNull(clients);
        assertEquals(1, clients.size());
        assertEquals("a", clients.get(0).getCli());

        System.out.println("Done");
    }

    // Test pour getAllClientsPM
    @Test
    public void testGetAllClientsPM() {
        List<ClientPMDTO> mockClients = List.of(new ClientPMDTO("b", "Labidi", "09952351", "", "1111222233332", "xxx", "xx", "Tun", "216", "two", "EI", LocalDate.of(2024, 8, 1), LocalDate.of(2024, 6, 22)));
        when(clientRepository.findAllClientsPM()).thenReturn(mockClients);

        List<ClientPMDTO> clients = clientService1.getAllClientsPM();

        assertNotNull(clients);
        assertEquals(1, clients.size());
        assertEquals("b", clients.get(0).getCli());

        System.out.println("Done");
    }

    // Test pour getClientsPPByOpeningDate
    @Test
    public void testGetClientsPPByOpeningDate() {
        List<ClientPPDTO> mockClients = List.of(new ClientPPDTO("a", "1", "Cin", "14461053", LocalDate.of(2022, 9, 15), "Siliana", LocalDate.of(2032, 9, 7), "djo", "Djo", "M", LocalDate.of(2004, 3, 2), "Marsa", "216", "x"));
        when(clientRepository.findClientsPPByOpeningDate(any(LocalDate.class), any(LocalDate.class))).thenReturn(mockClients);

        List<ClientPPDTO> clients = clientService1.getClientsPPByOpeningDate(LocalDate.of(2010, 1, 1), LocalDate.of(2023, 12, 31));

        assertNotNull(clients);
        assertEquals(1, clients.size());
        assertEquals("a", clients.get(0).getCli());

        System.out.println("Done");
    }

    // Test pour getClientsPMByOpeningDate
    @Test
    public void testGetClientsPMByOpeningDate() {
        List<ClientPMDTO> mockClients = List.of(new ClientPMDTO("b", "2", "09952351", "", "1111222233332", "xxx", "xx", "Tun", "216", "two", "EI", LocalDate.of(2024, 8, 1), LocalDate.of(2024, 6, 22)));
        when(clientRepository.findClientsPMByOpeningDate(any(LocalDate.class), any(LocalDate.class))).thenReturn(mockClients);

        List<ClientPMDTO> clients = clientService1.getClientsPMByOpeningDate(LocalDate.of(2010, 1, 1), LocalDate.of(2023, 12, 31));

        assertNotNull(clients);
        assertEquals(1, clients.size());
        assertEquals("b", clients.get(0).getCli());

        System.out.println("Done");
    }

    // Test pour getClientPPByCli
    @Test
    public void testGetClientPPByCli() {
        ClientPPDTO mockClient = new ClientPPDTO("a", "1", "Cin", "14461053", LocalDate.of(2022, 9, 15), "Siliana", LocalDate.of(2032, 9, 7), "djo", "Djo", "M", LocalDate.of(2004, 3, 2), "Marsa", "216", "x");

        when(clientRepository.findClientPPByCli(anyString())).thenReturn(mockClient);

        ClientPPDTO client = clientService1.getClientPPByCli("a");

        assertNotNull(client);
        assertEquals("a", client.getCli());
        assertEquals("djo", client.getNom());

        System.out.println("Done");
    }

    // Test pour getClientPMByCli
    @Test
    public void testGetClientPMByCli() {
        // Corrected mock client data to match the expected "Labidi" value for rso
        ClientPMDTO mockClient = new ClientPMDTO("b", "Labidi", "09952351", "", "1111222233332", "xxx", "xx", "Tun", "216", "two", "EI", LocalDate.of(2024, 8, 1), LocalDate.of(2024, 6, 22));

        when(clientRepository.findClientPMByCli(anyString())).thenReturn(mockClient);

        ClientPMDTO client = clientService1.getClientPMByCli("b");

        assertNotNull(client);
        assertEquals("b", client.getCli());
        assertEquals("xxx", client.getRso());  // Matches the corrected mock data

        System.out.println("Done");
    }


}
