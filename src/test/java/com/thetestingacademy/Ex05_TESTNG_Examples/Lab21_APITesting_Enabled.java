package com.thetestingacademy.Ex05_TESTNG_Examples;


import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab21_APITesting_Enabled {

    @Test(enabled = true)
    public void testcase01(){
        System.out.println("TestCase 1");
        Assert.assertTrue(true);
    }
    @Test(enabled = false)
    public void testcase02(){
        System.out.println("TestCase 2");
        Assert.assertTrue(true);
    }
    @Test(enabled = true)
    public void testcase03(){
        System.out.println("TestCase 3");
        Assert.assertTrue(true);
    }

}
