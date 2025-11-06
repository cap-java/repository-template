package customer.incident_app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.endsWith;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTests {
    private static final String incdientURI = "/odata/v4/ProcessorService/Incidents";
    private static final String incidentID = "3583f982-d7df-4aad-ab26-301d4a157cd7";
    
    @Autowired MockMvc mockMvc;

    @Test
    @WithMockUser("alice")
    public void emojiAppended() throws Exception {
        mockMvc.perform(get(incdientURI+("(ID="+incidentID+",IsActiveEntity=true)")))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.title").exists())
            .andExpect(jsonPath("$.title").value(endsWith("🙃")));
    }
}
