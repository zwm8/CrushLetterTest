package com.interview;



public class RemoveConsecutiveChars extends StringProcessor{
	
	/**
	 * 
	 * Instead of removing the consecutively identical characters, replace them with
	 * a single character that comes before it alphabetically.
	 * 
	 * @param input The string needs to replace consecutive characters
	 * @return
	 */	
	
	 @Override
	    public String process(String input) {
			if (input == null || input.length() < 3) {
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
}
