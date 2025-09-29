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

	@Test
	public void testCustomDelimiter() {
		Assert.assertEquals(3, calculator.add("//;\n1;2"));
	}

	@Test
	public void testNegativeNumberThrowsException() {
		try {
			calculator.add("-1,2");
			Assert.fail("Exception expected");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(e.getMessage().contains("negatives not allowed"));
			Assert.assertTrue(e.getMessage().contains("-1"));
		}
	}

	@Test
	public void testMultipleNegativesInExceptionMessage() {
		try {
			calculator.add("-1,-2,3");
			Assert.fail("Exception expected");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(e.getMessage().contains("negatives not allowed"));
			Assert.assertTrue(e.getMessage().contains("-1"));
			Assert.assertTrue(e.getMessage().contains("-2"));
		}
	}
}
