package TestNGDemo.test;

import org.testng.annotations.Test;

public class day6 {

        @Test(priority = 1)
        public void login() {
            System.out.println("Login");
        }

        @Test(priority = 2)
        public void dashboard() {
            System.out.println("Dashboard");
        }

        @Test(priority = 3)
        public void logout() {
            System.out.println("Logout");
        }
    }

