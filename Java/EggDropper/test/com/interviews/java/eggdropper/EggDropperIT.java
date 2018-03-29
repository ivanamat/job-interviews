package com.interviews.java.eggdropper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

/**
 * EggDropper junit test
 */
public class EggDropperIT {

    public EggDropper dropper = new EggDropper();

    public EggDropperIT() {
        System.out.println("EggDropperIT");
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("@BeforeClass - setUpClass");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("@AfterClass - tearDownClass");
    }

    @Before
    public void setUp() {
        System.out.println("@Before - setUp");
    }

    @After
    public void tearDown() {
        System.out.println("@After - tearDown");
    }

    /**
     * Test of minEggDropperX method, of class EggDropper. 0 eggs 0 floors
     */
    @Test
    public void testMinEggDropper0Eggs0Floors() {
        System.out.println("testMinEggDropper0Eggs0Floors");

        int eggs = 0;
        int floors = 0;

        int expResult = 0;
        System.out.print("expResult:");
        System.out.println(expResult);

        int result = dropper.minEggDropperX(eggs, floors);
        System.out.print("Result:");
        System.out.println(result);

        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of minEggDropperX method, of class EggDropper. 0 eggs 100 floors
     */
    @Test
    public void testMinEggDropper0Eggs100Floors() {
        System.out.println("testMinEggDropper0Eggs100Floors");

        int eggs = 0;
        int floors = 100;

        int expResult = 0;
        System.out.print("expResult:");
        System.out.println(expResult);

        int result = dropper.minEggDropperX(eggs, floors);
        System.out.print("Result:");
        System.out.println(result);

        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of minEggDropperX method, of class EggDropper. 2 eggs 0 floors
     */
    @Test
    public void testMinEggDropper2Eggs0Floors() {
        System.out.println("testMinEggDropper2Eggs0Floors");

        int eggs = 2;
        int floors = 0;

        int expResult = 0;
        System.out.print("expResult:");
        System.out.println(expResult);

        int result = dropper.minEggDropperX(eggs, floors);
        System.out.print("Result:");
        System.out.println(result);

        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of minEggDropperX method, of class EggDropper. 2 eggs 100 floors
     */
    @Test
    public void testMinEggDropper2Eggs100Floors() {
        System.out.println("testMinEggDropper2Eggs100Floors");

        int eggs = 2;
        int floors = 100;

        int expResult = 14;
        System.out.print("expResult:");
        System.out.println(expResult);

        int result = dropper.minEggDropperX(eggs, floors);
        System.out.print("Result:");
        System.out.println(result);

        Assert.assertEquals(expResult, result);
    }

}