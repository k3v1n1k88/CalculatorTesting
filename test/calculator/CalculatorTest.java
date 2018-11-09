/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.Arrays;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import mockit.Deencapsulation;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author root
 */
public class CalculatorTest {
    
    @Mocked 
    Calculator calculatorInstance = new Calculator();
    
    public CalculatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of calc method, of class Calculator.
     */
    @Test
    public void testCalc() {
        String input = "(123+234)*789-123/123";
        calculatorInstance = new Calculator(input);
        String res = calculatorInstance.calc();
        assertEquals(res,"281672");
    }
    
    @Test
    public void testInfixToPostfix(){
        String[] input = {"(", "123", "+", "234", ")", "*", "789", "-", "123", "/", "123"};
        
        String[] expected = {"123","234","+","789","*","123","123","/","-"};
        String[] actualResult = calculatorInstance.infixToPostfix(input);
        assertArrayEquals(expected,actualResult);
    }
}
