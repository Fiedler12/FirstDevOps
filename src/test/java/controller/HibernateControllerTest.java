package controller;

import static org.junit.jupiter.api.Assertions.*;

class HibernateControllerTest {

        @org.junit.jupiter.api.Test
        void getInstance() {
            HibernateController hibernateController = HibernateController.getInstance();
            assertNotNull(hibernateController);
        }
        // test for the singleton pattern
        @org.junit.jupiter.api.Test
        void getInstance2() {
            HibernateController hibernateController = HibernateController.getInstance();
            HibernateController hibernateController2 = HibernateController.getInstance();
            assertEquals(hibernateController, hibernateController2);
        }

        // test for session factory
        @org.junit.jupiter.api.Test
        void getSessionFactory() {
            HibernateController hibernateController = HibernateController.getInstance();
            assertNotNull(hibernateController.getSessionFactory());
        }


}