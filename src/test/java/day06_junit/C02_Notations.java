package day06_junit;

import org.junit.*;

public class C02_Notations {
    @BeforeClass
    public static void setupClass(){
        System.out.println("Before Class has run.");
    }

    @AfterClass
    public static void teardownClass(){
        System.out.println("After Class has run.");
    }

    @Before
    public void setupMethod(){
        System.out.println("Before method has run.");
    }

    @After
    public void teardownMethod(){
        System.out.println("After method has run");
    }

    @Test
    public void test1(){
        System.out.println("Test 1 has run.");
    }
    @Test
    public void test2(){
        System.out.println("Test 2 has run.");
    }
    @Test
    public void test3(){
        System.out.println("Test 3 has run.");
    }
    /*
    Result
    Before Class has run.
    Before method has run.
    Test 1 has run.
    After method has run
    Before method has run.
    Test 2 has run.
    After method has run
    Before method has run.
    Test 3 has run.
    After method has run
    After Class has run.
     */

    @Test @Ignore
    public void testIgnore(){
        System.out.println("Test Ignore method has run.");
    }

    /*
    Result
    ..
    ..
    ..
    Test ignored. (didn't pass, didn't fail)
    After Class has run.
     */
}
