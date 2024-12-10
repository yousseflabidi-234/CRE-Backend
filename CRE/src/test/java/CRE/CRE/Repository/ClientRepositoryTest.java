package CRE.CRE.Repository;

import CRE.CRE.Entity.Client;
import CRE.CRE.dto.*;
import CRE.CRE.dto.ClientPPDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @BeforeEach
    @Rollback
    public void setUp() {
        // Insérer des données de test dans la base de données
        Client client1 = new Client("a", "1", "Cin", "14461053", LocalDate.of(2022, 9, 15),"Siliana", LocalDate.of(2032,9,7),"djo", "Djo", "M", LocalDate.of(2004,3,2), "Marsa", "216", null, LocalDate.of(2024,8,29),"14461053",null,"1111222233331","xxx","xxx","Tun",null,"one","EI",LocalDate.of(2019,5,19),LocalDate.of(2024,8,29));
        Client client2 = new Client("b", "2", "Cin", "09952351", LocalDate.of(2014, 1, 18),"Kram", LocalDate.of(2034,12,17),"Labidi", "Ines", "F", LocalDate.of(1996,12,24), "Marsa", "216", null, LocalDate.of(2024,6,22),"09952351",null,"1111222233332","xxx","xx","Tun",null,"two","EI",LocalDate.of(2024,8,1),LocalDate.of(2024,6,22));

        client1.setDou(LocalDate.of(2024, 8, 1));
        client2.setDou(LocalDate.of(2017, 5, 9));

        clientRepository.save(client1);
        clientRepository.save(client2);
    }

    @Test
    public void testFindAllClientsPP() {
        List<ClientPPDTO> clients = clientRepository.findAllClientsPP();

        assertNotNull(clients, "List of PP clients should not be null");
        assertEquals(1, clients.size(), "Should find one PP client");
        assertEquals("a", clients.get(0).getCli(), "PP Client ID should match");
        System.out.println("done: " + clients);
    }

    @Test
    public void testFindAllClientsPM() {
        List<ClientPMDTO> clients = clientRepository.findAllClientsPM();

        assertNotNull(clients, "List of PM clients should not be null");
        assertEquals(1, clients.size(), "Should find one PM client");
        assertEquals("b", clients.get(0).getCli(), "PM Client ID should match");
        System.out.println("done: " + clients);
    }

    @Test
    public void testFindClientsPPByOpeningDate() {
        LocalDate startDate = LocalDate.of(2010, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 31);

        List<ClientPPDTO> clients = clientRepository.findClientsPPByOpeningDate(startDate, endDate);

        assertEquals(1, clients.size(), "Should find one PP client");
        assertEquals("a", clients.get(0).getCli(), "PP Client ID should match");
        System.out.println("done: " + clients);
    }

    @Test
    public void testFindClientsPMByOpeningDate() {
        LocalDate startDate = LocalDate.of(2010, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);

        List<ClientPMDTO> clients = clientRepository.findClientsPMByOpeningDate(startDate, endDate);

        assertEquals(1, clients.size(), "Should find one PM client");
        assertEquals("b", clients.get(0).getCli(), "PM Client ID should match");
        System.out.println("done: " + clients);
    }

    @Test
    public void testFindClientPPByCli() {
        ClientPPDTO client = clientRepository.findClientPPByCli("a");

        assertNotNull(client, "PP Client should not be null");
        assertEquals("a", client.getCli(), "PP Client ID should match");
        System.out.println("done");
        System.out.println("client: " + client);
    }

    @Test
    public void testFindClientPMByCli() {
        ClientPMDTO client = clientRepository.findClientPMByCli("b");

        assertNotNull(client, "PM Client should not be null");
        assertEquals("b", client.getCli(), "PM Client ID should match");
        System.out.println("done");
        System.out.println("client: " + client);
    }

    @Test
    public void testFindClientPPByCli_NotFound() {
        ClientPPDTO client = clientRepository.findClientPPByCli("unknown");

        assertNull(client, "PP Client should be null when not found");
        System.out.println(client);
    }

    @Test
    public void testFindClientPMByCli_NotFound() {
        ClientPMDTO client = clientRepository.findClientPMByCli("unknown");

        assertNull(client, "PM Client should be null when not found");
        System.out.println(client);
    }
}
