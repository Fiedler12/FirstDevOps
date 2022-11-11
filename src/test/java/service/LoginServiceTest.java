package service;

import controller.JWTHandler;
import model.LoginData;
import model.User;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {
    // test the postLoginData method
    @org.junit.jupiter.api.Test
    void postLoginData() throws NotAuthorizedException {
        // create a new instance of the service
        LoginService loginService = new LoginService();
        LoginData loginData = new LoginData();
        loginData.setEmail("test@test.test");
        loginData.setPassword("test");
        // call the postLoginData method
        String token = loginService.postLoginData(loginData);
        // check that the token is not null
        assertNotNull(token);
        // verify that the token is valid
        User user = JWTHandler.validate(token);
        // check that the user is not null
        assertNotNull(user);
        // check that the user has the expected email
        assertEquals("test@test.test", user.getEmail());
        // test the postLoginData method with an invalid email and a valid password and check if it throws an exception
        loginData.setEmail("invalid email");
        assertThrows(NotAuthorizedException.class, () -> loginService.postLoginData(loginData));
        // test the postLoginData method with a valid email and an invalid password and check if it throws an exception
        loginData.setEmail("test@test.test");
        loginData.setPassword("invalid password");
        assertThrows(NotAuthorizedException.class, () -> loginService.postLoginData(loginData));

    }
}