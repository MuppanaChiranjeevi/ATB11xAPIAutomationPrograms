package com.thetestingacademy.EX05_TESTNG_Examples;

import org.testng.annotations.Test;

public class Lab17_APITesting_Priority {
    @Test(priority = 1)
    public void t1(){
        System.out.println("P1");
    }
    @Test(priority = 4)
    public void t2(){
        System.out.println("P3");
    }
    @Test(priority = 3)
    public void t3(){
        System.out.println("P2");
    }
    @Test(priority = 2)
    public void t4(){
        System.out.println("P4");
    }
}
