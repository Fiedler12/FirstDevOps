package controller;

import static org.junit.jupiter.api.Assertions.*;

class HibernateControllerTest {

        @org.junit.jupiter.api.Test
        void getInstance() {
            // check that the instance is not null
            assertNotNull(HibernateController.getInstance());
        }
        // test for the singleton pattern
        @org.junit.jupiter.api.Test
        void getInstance2() {
            // check that the instance is not null
            assertNotNull(HibernateController.getInstance());
            // check that the instance is the same
            assertEquals(HibernateController.getInstance(), HibernateController.getInstance());
        }

        // test for session factory
        @org.junit.jupiter.api.Test
        void getSessionFactory() {
            // check that the session factory is not null
            assertNotNull(HibernateController.getSessionFactory());
        }


}