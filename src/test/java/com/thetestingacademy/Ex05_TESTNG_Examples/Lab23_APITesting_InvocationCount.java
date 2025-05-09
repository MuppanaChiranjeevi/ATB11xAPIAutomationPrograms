package com.thetestingacademy.Ex05_TESTNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab23_APITesting_InvocationCount {
    @Test(invocationCount = 3)
    public void testcase01(){
        System.out.println("TestCase 1");
        Assert.assertTrue(true);
    }
    @Test(invocationCount = 2)
    public void testcase02(){
        System.out.println("TestCase 2");
        Assert.assertTrue(true);
    }
    @Test(invocationCount = 4)
    public void testcase03(){
        System.out.println("TestCase 3");
        Assert.assertTrue(true);
    }
    @Test
    public void testcase04(){
        System.out.println("TestCase 4");
        Assert.assertTrue(true);
    }

}
