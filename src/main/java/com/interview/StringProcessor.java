package com.interview;

public class StringProcessor {
	/**
	 * Determine whether the string only contains letters a-z
	 * 
	 * @param str The string needs to determine
	 * @return If the string only contains letters a-z, return true; Otherwise,
	 *         return false
	 */
	public static boolean isLowerCaseAlpha(String str) {
		for (int i = 0; i < str.length(); i++) {
			// Check if each character is between 'a' and 'z'
			if (str.charAt(i) < 'a' || str.charAt(i) > 'z') {
				return false; // If non a-z characters are found, return false
			}
		}
		return true; // All characters are letters a-z, return true
	}

	/**
	 * Determine whether the string only contains letters a-z
	 * 
	 * @param str The string needs to determine
	 * @return If the string only contains letters a-z, return true; Otherwise,
	 *         return false
	 */
	public static boolean isLowerCaseAlphaRegex(String str) {
		// Regular expression: ^ [a-z]+$represents a string starting with a-z and
		// consisting entirely of a-z until the end of the string
		return str.matches("^[a-z]+$");
	}

	/**
	 * For a given string that only contains alphabet characters a-z, if 3 or more
	 * consecutive characters are identical, remove them from the string
	 * 
	 * @param input The string needs to remove consecutive characters
	 * @return
	 */

	public static String removeConsecutiveChars(String input) {
		if (input == null || input.length() < 3) {
			return input;
		}
		
		if (false == isLowerCaseAlphaRegex(input)) {
			return input;
		}

		StringBuilder sb = new StringBuilder(input);
		int i = 0;

		while (i < sb.length() - 2) {
			char currentChar = sb.charAt(i);
			if (currentChar == sb.charAt(i + 1) && currentChar == sb.charAt(i + 2)) {
				int j = i + 3;
				while (j < sb.length() && sb.charAt(j) == currentChar) {
					j++;
				}
				sb.delete(i, j);
			} else {
				i++;
			}
		}

		return sb.toString();
	}

	/**
	 * 
	 * Instead of removing the consecutively identical characters, replace them with
	 * a single character that comes before it alphabetically.
	 * 
	 * @param input The string needs to replace consecutive characters
	 * @return
	 */
	public static String replaceConsecutiveChars(String input) {
		char alphabetFirstChar = 'a';
		if (input == null || input.length() < 3) {
			return input;
		}
		
		if (false == isLowerCaseAlphaRegex(input)) {
			return input;
		}

		StringBuilder sb = new StringBuilder(input);
		int i = 0;

		while (i < sb.length() - 2) {
			char currentChar = sb.charAt(i);
			if (currentChar == sb.charAt(i + 1) && currentChar == sb.charAt(i + 2)) {
				char replacementChar = (char) (currentChar - 1);

				int j = i + 3;
				while (j < sb.length() && sb.charAt(j) == currentChar) {
					j++;
				}

				if (alphabetFirstChar == currentChar) {
					sb.delete(i, j);
				} else {
					sb.replace(i, j, String.valueOf(replacementChar));
				}

			} else {
				i++;
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String input = "aabcccbbad";
		String result = input;

		while (true) {
			String nextResult = removeConsecutiveChars(result);
			if (nextResult.equals(result)) {
				break;
			}
			result = nextResult;
			System.out.println("-> " + result);
		}
	}
}
