package CRE.CRE.Controller;

import CRE.CRE.Service.ClientService;
import CRE.CRE.dto.ClientPPDTO;
import CRE.CRE.dto.ClientPMDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ClientControllerTest {

    @Mock
    private ClientService clientService1;

    @InjectMocks
    private ClientController clientController1;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clientController1).build();
    }


    // Test pour getAllClientsPP
    @Test
    public void testGetAllClientsPP() throws Exception {
        List<ClientPPDTO> mockClients = List.of(new ClientPPDTO("a", "1", "CIN", "12345678", null, "CityA", null, "John", "Doe", "M", null, "AddressA", "216", "x"));
        when(clientService1.getAllClientsPP()).thenReturn(mockClients);

        mockMvc.perform(get("/clients/pp/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }

    // Test pour getAllClientsPM
    @Test
    public void testGetAllClientsPM() throws Exception {
        List<ClientPMDTO> mockClients = List.of(new ClientPMDTO("b", "2", "09952351", "12345", "1111222233332", "CompanyY", "SIG", "Tunisia", "Two", "LLC", null, null, null));
        when(clientService1.getAllClientsPM()).thenReturn(mockClients);

        mockMvc.perform(get("/clients/pm/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }

    // Test pour getClientsPPByOpeningDate
    @Test
    public void testGetClientsPPByOpeningDate() throws Exception {
        List<ClientPPDTO> mockClients = List.of(new ClientPPDTO("a", "1", "Cin", "14461053", LocalDate.of(2022, 9, 15), "Siliana", LocalDate.of(2032, 9, 7), "djo", "Djo", "M", LocalDate.of(2004, 3, 2), "Marsa", "216", "x"));
        when(clientService1.getClientsPPByOpeningDate(any(LocalDate.class), any(LocalDate.class))).thenReturn(mockClients);

        MvcResult result = mockMvc.perform(get("/clients/pp")
                        .param("startDate", "2010-01-01")
                        .param("endDate", "2023-12-31")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        System.out.println(jsonResponse);
    }

    // Test pour getClientsPMByOpeningDate
    @Test
    public void testGetClientsPMByOpeningDate() throws Exception {
        List<ClientPMDTO> mockClients = List.of(new ClientPMDTO("b", "2", "09952351", "", "1111222233332", "xxx", "xx", "Tun", "216", "two", "EI", LocalDate.of(2024,8,1), LocalDate.of(2024,6,22)));
        when(clientService1.getClientsPMByOpeningDate(any(LocalDate.class), any(LocalDate.class))).thenReturn(mockClients);

        MvcResult result = mockMvc.perform(get("/clients/pm")
                        .param("startDate", "2010-01-01")
                        .param("endDate", "2023-12-31")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        System.out.println(jsonResponse);
    }

    // Test pour getClientPPByCli
    @Test
    public void testGetClientPPByCli_Found() throws Exception {
        ClientPPDTO mockClient = new ClientPPDTO("a", "1", "CIN", "14461053", null, "Siliana", null, "djo", "Djo", "M", null, "Marsa", "216", "x");
        when(clientService1.getClientPPByCli(anyString())).thenReturn(mockClient);

        mockMvc.perform(get("/clients/pp/a")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cli").value("a"));
    }


    // Test pour getClientPMByCli
    @Test
    public void testGetClientPMByCli_Found() throws Exception {
        ClientPMDTO mockClient = new ClientPMDTO("b", "2", "09952351", "12345", "1111222233332", "CompanyX", "SIG", "Tunisia", "Two", "LLC", null, null, null);
        when(clientService1.getClientPMByCli(anyString())).thenReturn(mockClient);

        mockMvc.perform(get("/clients/pm/b")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cli").value("b"));
    }

}
