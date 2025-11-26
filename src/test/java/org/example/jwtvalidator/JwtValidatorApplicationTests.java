package org.example.jwtvalidator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class JwtValidatorApplicationTests {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void testPublicEndpoint() throws Exception {
        mockMvc.perform(get("/public"))
                .andExpect(status().isOk())
                .andExpect(content().string("This is public endpoint"));
    }

    @Test
    void testSecureEndpointUnauthorized() throws Exception {
        mockMvc.perform(get("/secure"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void testSecureEndpointWithJwt() throws Exception {
        mockMvc.perform(
                        get("/secure")
                                .with(SecurityMockMvcRequestPostProcessors.jwt())
                )
                .andExpect(status().isOk())
                .andExpect(content().string("This is secure endpoint"));
    }

    @Test
    void testMeEndpoint() throws Exception {
        mockMvc.perform(
                        get("/me")
                                .with(SecurityMockMvcRequestPostProcessors.jwt()
                                        .jwt(jwt -> {
                                            jwt.claim("sub", "user123");
                                            jwt.claim("email", "test@example.com");
                                            jwt.claim("scope", "openid email profile");
                                        })
                                )
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.subject").value("user123"))
                .andExpect(jsonPath("$.claims.email").value("test@example.com"));
    }
}

