package com.thetestingacademy.EX05_TESTNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab18_APITesting_DependsON {
    @Test
    public void serverStartedOk() {
        System.out.println("I will run first");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void test1() {
        System.out.println("method1");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void test2() {
        System.out.println("method2");
        Assert.assertTrue(true);

    }
}
