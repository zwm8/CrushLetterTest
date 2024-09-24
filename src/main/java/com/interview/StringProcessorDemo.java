package com.interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringProcessorDemo {
	public static boolean isLowerCaseAlphaRegex(String str) {
		// Regular expression: ^ [a-z]+$represents a string starting with a-z and
		// consisting entirely of a-z until the end of the string
		return str.matches("^[a-z]+$");
	}

	public static void main(String[] args) {
		String input = "aabcccbbad";
		String result = input;
		if (false == isLowerCaseAlphaRegex(input)) {
			System.out.println("-> " + result);
			return;
		}
		System.out.println("" + result + " RemoveConsecutiveChars");
		RemoveConsecutiveChars removeConsecutiveChars = new RemoveConsecutiveChars();
		while (true) {
			String nextResult = removeConsecutiveChars.process(result);
			if (nextResult.equals(result)) {
				break;
			}
			result = nextResult;
			System.out.println("-> " + result);
		}

		result = "abcccbad";
		System.out.println("" + result + " ReplaceConsecutiveChars");
		ReplaceConsecutiveChars replaceConsecutiveChars = new ReplaceConsecutiveChars();
		while (true) {
			String nextResult = replaceConsecutiveChars.process(result);
			if (nextResult.equals(result)) {
				break;
			}
			result = nextResult;
			System.out.println("-> " + result);
		}
	}
}
