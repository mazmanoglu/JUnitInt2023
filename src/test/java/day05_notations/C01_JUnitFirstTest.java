package day05_notations;

import org.junit.Test;

public class C01_JUnitFirstTest {

    /*
    1- We can create more than one independent test method in one class
    2- We can run these test methods independently or run all methods from class level.
    3- With test notation, main method dependency is eliminated (no need to main). Methods using test notation can run without main method.
    4- Junit reports that the standard test methods run successfully or failed.
    5- Junit performs tests by using methods from the Assert class. Thus, we don't need to compare expected and actual results with if-else.
    6- Junit also reports the difference of actual and expected data in all failed tests.
     */

    @Test
    public void test01(){
        System.out.println("Test 01 passed");
    }

    @Test
    public void test02(){
        System.out.println("Test 02 passed");
    }

    @Test
    public void test03(){
        System.out.println("Test 03 passed");
    }
}
