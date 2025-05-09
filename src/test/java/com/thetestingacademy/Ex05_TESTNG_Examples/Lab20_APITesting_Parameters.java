package com.thetestingacademy.Ex05_TESTNG_Examples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lab20_APITesting_Parameters {
    @Parameters("browser")
    @Test
    public void test_param(String value){
        System.out.println("You are running this for parameter "+value);

        if(value.equalsIgnoreCase("firefox")){
            System.out.println("Start the firefox");
        }
        if(value.equalsIgnoreCase("chrome")){
            System.out.println("Start the chrome!");
        }


    }

}
