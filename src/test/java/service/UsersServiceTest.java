package service;

import com.auth0.jwt.exceptions.JWTDecodeException;
import controller.JWTHandler;
import jakarta.validation.constraints.Null;
import jakarta.ws.rs.NotFoundException;
import model.User;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersServiceTest {

    // test the getUser method with a valid id and a valid token in the header of the request (token is valid)
    @org.junit.jupiter.api.Test
    void getUser() throws NotAuthorizedException {
        // create a new instance of the service
        UsersService usersService = new UsersService();
        // generate a token for the user with id 1
        User user = new User();
        user.setId(1);
        user.setName("Rune");
        user.setEmail("test@test.test");
        user.setPassword("test");
        String token = JWTHandler.generateJwtToken(user);
        // call the getUser method with a valid id and a valid token in the header of the request (token is valid)
        User user1 = usersService.getUser(1, token);
        // check that the user is not null
        assertNotNull(user1);
        // call the getUser method with an invalid id and a valid token in the header of the request (token is valid) and check if it throws an exception
        assertThrows(NullPointerException.class, () -> usersService.getUser(0, token));
        // call the getUser method with a valid id and an invalid token in the header of the request (token is invalid) and check if it throws an exception
        assertThrows(JWTDecodeException.class, () -> usersService.getUser(1, "invalid token"));
        // check that the user has the expected name
        assertEquals("Rune", user1.getName());
        // check that the user has the expected id
        assertEquals(1, user1.getId());

    }
    // test the putUser method with a valid id and a valid token in the header of the request (token is valid) and a valid user object in the body of the request (user object is valid) and check if it returns the updated user object with the expected values
    @org.junit.jupiter.api.Test
    void putUser() throws NotAuthorizedException {
        // create a new instance of the service
        UsersService usersService = new UsersService();
        // generate a token for the user with id 1
        User user = new User();
        user.setId(1);
        user.setName("Rune");
        user.setEmail("test@test.test");
        user.setPassword("test");
        String token = JWTHandler.generateJwtToken(user);
        // call the putUser method with a valid id and a valid token in the header of the request (token is valid) and a valid user object in the body of the request (user object is valid) and check if it returns the updated user object with the expected values
        User user1 = usersService.putUser(1, user, token);
        // check that the user is not null
        assertNotNull(user1);
        // check that the user has the expected name
        assertEquals("Rune", user1.getName());
        // check that the user has the expected id
        assertEquals(1, user1.getId());
        // check that the user has the expected email
        assertEquals("test@test.test", user1.getEmail());
        // check that the user has the expected cpr
        // check that the user has the expected password
        assertEquals("test", user1.getPassword());
        // call the putUser method with an invalid id and a valid token in the header of the request (token is valid) and a valid user object in the body of the request (user object is valid) and check if it throws an exception
        assertThrows(NullPointerException.class, () -> usersService.putUser(0, user, token));
        // call the putUser method with a valid id and an invalid token in the header of the request (token is invalid) and a valid user object in the body of the request (user object is valid) and check if it throws an exception
        assertThrows(JWTDecodeException.class, () -> usersService.putUser(1, user, "invalid token"));
        // call the putUser method with a valid id and a valid token in the header of the request (token is valid) and an invalid user object in the body of the request (user object is invalid) and check if it throws an exception
        assertThrows(NullPointerException.class, () -> usersService.putUser(1, null, token));

    }
}