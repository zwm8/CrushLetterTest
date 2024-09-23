package com.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;


/**
 * Unit test for simple StringProcessor.
 */
public class StringProcessorTest {
	@Test
	public void testRemoveConsecutiveChars() {
	       String input = "aabcccbbad";
	       String result = input;

	       while (true) {
	           String nextResult = StringProcessor.removeConsecutiveChars(result);
	           if (nextResult.equals(result)) {
	               break;
	           }
	           result = nextResult;
	           System.out.println("-> " + result);
	       }
	       assertEquals("String aabcccbbad removeConsecutiveChars should be d", "d", result);

	}


	@Test
	public void testReplaceConsecutiveChars() {
	       String input = "abcccbad";
	       String result = input;

	       while (true) {
	           String nextResult = StringProcessor.replaceConsecutiveChars(result);
	           if (nextResult.equals(result)) {
	               break;
	           }
	           result = nextResult;
	           System.out.println("-> " + result);
	       }
		assertEquals("String abcccbad replaceConsecutiveChars should be d", "d", result);

	}
}
