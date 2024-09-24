package com.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Unit test for simple StringProcessor.
 */
public class StringProcessorTest {
	@Test
	public void testRemoveConsecutiveChars() {
	       String input = "aabcccbbad";
	       String result = input;
	       RemoveConsecutiveChars removeConsecutiveChars = new RemoveConsecutiveChars();
	       while (true) {
	           String nextResult = removeConsecutiveChars.process(result);
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
	       ReplaceConsecutiveChars replaceConsecutiveChars = new ReplaceConsecutiveChars();
	       while (true) {
	           String nextResult = replaceConsecutiveChars.process(result);
	           if (nextResult.equals(result)) {
	               break;
	           }
	           result = nextResult;
	           System.out.println("-> " + result);
	       }
		assertEquals("String abcccbad replaceConsecutiveChars should be d", "d", result);

	}
}
