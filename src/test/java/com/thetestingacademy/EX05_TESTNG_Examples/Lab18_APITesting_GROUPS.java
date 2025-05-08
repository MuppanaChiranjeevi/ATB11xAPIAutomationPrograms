package com.thetestingacademy.EX05_TESTNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab18_APITesting_GROUPS {


    @Test(groups = {"sanity", "reg"}, priority = 1)
    public void test_sanityRun() {
        System.out.println("Sanity");
        System.out.println("reg");
        Assert.assertTrue(true);
    }

    @Test(groups = {"reg"}, priority = 2)
    public void test_regRun() {
        System.out.println("Reg");
        Assert.assertTrue(true);
    }

    @Test(groups = {"smoke","reg"},priority = 3)
    public void test_smokeRun() {
        System.out.println("Smoke");
        System.out.println("Reg");
        Assert.assertTrue(true);
    }
    @Test(groups = {"smoke","sanity"},priority = 4)
    public void test_Run() {
        System.out.println("Smoke");
        System.out.println("Sanity");
        Assert.assertTrue(false);
    }
}
