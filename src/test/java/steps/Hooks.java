package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {

    @Before
    public void setup() {
        System.out.println("2");


    }

    @After
    public void tearDowns() {
        System.out.println("322");

    }
}
