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

	public static void main3(String[] args) {
		List<String> strings = Arrays.asList("  Hello, World!  ", "Java 8", "Streams API");

		// 使用UpperCaseProcessor处理字符串
		List<String> upperCaseStrings = strings.stream().map(s -> new RemoveConsecutiveChars().process(s))
				.collect(Collectors.toList());

		// 使用TrimProcessor处理字符串
		List<String> trimmedStrings = strings.stream().map(s -> new ReplaceConsecutiveChars().process(s))
				.collect(Collectors.toList());

		// 输出处理后的字符串列表
		System.out.println("Upper case strings: " + upperCaseStrings);
		System.out.println("Trimmed strings: " + trimmedStrings);
	}

	public static void main(String[] args) {
		String input = "aabcccbbad";
		String result = input;
		if (false == isLowerCaseAlphaRegex(input)) {
			System.out.println("-> " + result);
			return;
		}
		System.out.println(""  + result+" RemoveConsecutiveChars");
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
		System.out.println(""  + input+" ReplaceConsecutiveChars");
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
