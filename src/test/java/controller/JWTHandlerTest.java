package controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;


class JWTHandlerTest {
    private static String key = "hæmli";
    // test generateJwtToken method with a valid user object and with a experydate of 10 minutes
    @org.junit.jupiter.api.Test
    void generateJwtToken() {
        model.User user = new model.User();
        user.setId(1);
        user.setName("test");
        user.setEmail("test@test.test");
        user.setPassword("test");
        try {
            String token = JWTHandler.generateJwtToken(user);
            assertNotNull(token);
            JWTVerifier verifier = JWT.require(Algorithm.HMAC512(key)).build();
            DecodedJWT verify = verifier.verify(token);
            assertEquals(verify.getIssuer(), "Probe");
            assertEquals(verify.getClaim("user").asString(), new ObjectMapper().writer().writeValueAsString(user));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // test validate method with a valid token and a valid user object
    @org.junit.jupiter.api.Test
    void validate() {
        Calendar expiry = Calendar.getInstance();
        expiry.add(Calendar.MINUTE, 10);
        model.User user = new model.User();
        user.setId(1);
        user.setName("test");
        user.setEmail("test@test.test");
        user.setPassword("test");
        try {
            String token = JWTHandler.generateJwtToken(user);
            assertNotNull(token);
            model.User user1 = JWTHandler.validate(token);
            assertEquals(user1.getId(), user.getId());
            assertEquals(user1.getName(), user.getName());
            assertEquals(user1.getEmail(), user.getEmail());
            assertEquals(user1.getPassword(), user.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

