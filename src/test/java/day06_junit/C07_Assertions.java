package day06_junit;

import org.junit.Assert;
import org.junit.Test;

public class C07_Assertions {
    /*
    Assert class has many methods. We use mostly 4 of them
    - Assert.assertTrue
    - Assert.assertFalse
    - Assert.assertEquals
    - Assert.assertNotEquals

    The methods in Assert class in JUnit check whether the actual results match our expectations.
    If the expected result is compatible with the actual result, the test is Passed.

    to sum up, if test sentence is
        - positive --> assertTrue
        - negative --> assertFalse

    The code stops working on the line where the Assertion fails, the next lines are not executed.
     */

    int number1 = 10;
    int number2 = 20;
    int number3 = 30;

    @Test
    public void test01(){
        // test the number1 is smaller than number2
        Assert.assertTrue(number1<number2);

        // test the number1 is NOT BIGGER than number2
        Assert.assertFalse(number1>number2);

        // test the number1 is equal to number3
        Assert.assertEquals(number1,number3);
    }

    @Test
    public void test02(){
        Assert.assertEquals(number3,number1+number2);
    }

    @Test
    public void test03(){
        Assert.assertNotEquals(number3,number2);
    }

    @Test
    public void test04(){
        Assert.assertTrue(number1==number3);
        //assertTrue or assertFalse cannot show the differences but assertEquals shows
    }

    @Test
    public void test05(){
        Assert.assertFalse(number3==number2);
    }

    @Test
    public void test06(){
        Assert.assertNotEquals(number3, number1+number2);
    }

    @Test
    public void test07(){
        Assert.assertTrue(number3<number2);
    }

    @Test
    public void test08(){
        Assert.assertFalse(number3>number1);
        System.out.println("Will this sentence print?"); // Nee
    }
}
