package com.AndreaPop.Automation.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// This test is used to ensure there are no runtime issues or test runner issues
public class BasicTest {

    @BeforeMethod
    public  void setUp() {
        System.out.println("Before method executed");
    }

    @Test
    public void basicTest(){
        System.out.println("Test executed");
        Assert.assertTrue(true);
    }
}
