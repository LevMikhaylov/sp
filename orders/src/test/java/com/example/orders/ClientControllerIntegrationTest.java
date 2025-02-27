package com.example.orders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
public class ClientControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(roles = "ADMIN")  // Предполагается, что доступ к этому эндпоинту только для администраторов
    void shouldExportClientsForAdmin() throws Exception {
        mockMvc.perform(get("/export/clients"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDenyExportClientsForUnauthenticatedUser() throws Exception {
        mockMvc.perform(get("/export/clients"))
                .andExpect(status().isUnauthorized());
    }
}
