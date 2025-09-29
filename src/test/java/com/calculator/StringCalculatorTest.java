package com.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
	private StringCalculator calculator;

	@Before
	public void setUp() {
		calculator = new StringCalculator();
	}

	@Test
	public void testEmptyString() {
		Assert.assertEquals(0, calculator.add(""));
	}
	
	@Test
	public void testOneNumber() {
		Assert.assertEquals(1, calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		Assert.assertEquals(3, calculator.add("1,2"));
	}
	
	@Test
    public void testNewLineDelimiter() {
        Assert.assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void testUnknownAmountOfNumbers() {
        Assert.assertEquals(10, calculator.add("1,2,3,4"));
    }
}
