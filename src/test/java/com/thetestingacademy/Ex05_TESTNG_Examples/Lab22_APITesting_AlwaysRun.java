package com.thetestingacademy.Ex05_TESTNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab22_APITesting_AlwaysRun {
    @Test
    public void test_new_register() {
        System.out.println("Registration page");
        Assert.assertTrue(true);
    }

    @Test(alwaysRun = true)
    public void test_loginPage() {
        System.out.println("Login page");
        Assert.assertTrue(true);
    }

    @Test(alwaysRun = true, enabled = false)
    public void test_home() {
        System.out.println("Home page");
        Assert.assertTrue(true);
    }

}
