package com.thetestingacademy.Ex06_TEST_Assertions;
/*TestNG Assertions
Types of TestNG Assertions

- Hard Assertions
- Soft Assertions */

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Lab27_APITesting_TestNG_Assertions {
    @Test(enabled = false)
    public void test_hardAssertExample() {
        System.out.println("Start of the program");
        Assert.assertEquals("pramod","Pramod");
        System.out.println("End of the program");

    }

    // Software Assertion

    @Test(enabled = true)
    public void test_softAssertExample() {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Start of the program");
        softAssert.assertEquals("pramod","Pramod");
        System.out.println("End of program");
        softAssert.assertAll();
    }
}
