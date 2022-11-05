package service;

import model.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersServiceTest {

        // test the getUsers method
        @org.junit.jupiter.api.Test
        void getUsers() {
            // create a new instance of the service
            UsersService usersService = new UsersService();
            // call the getUsers method
            List<User> users = usersService.getUsers();
            // check that the list is not null
            assertNotNull(users);
            // check that the list is not empty
            assertFalse(users.isEmpty());
            // check that the list contains the expected number of users
            assertEquals(23, users.size());
            // check that the first user in the list has the expected name
            assertEquals("Rune", users.get(0).getName());


        }

        // test the getUser method with a valid id
//        @org.junit.jupiter.api.Test
//        void getUser() {
//            // create a new instance of the service
//            UsersService usersService = new UsersService();
//            // call the getUser method with a valid id
//            User user = usersService.getUser(3001);
//            // check that the user is not null
//            assertNotNull(user);
//            // call the getUser method with an invalid id
//            User user2 = usersService.getUser(1);
//            // check that the trial is null
//            assertNull(user2);
//            // check that the user has the expected name
//            assertEquals("Rune", user.getName());
//            // check that the user has the expected id
//            assertEquals(3001, user.getId());
//
//        }

}