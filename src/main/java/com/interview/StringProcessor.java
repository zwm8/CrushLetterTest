package com.interview;

public class StringProcessor {

	 public static String removeConsecutiveChars(String input) {
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


   public static String replaceConsecutiveChars(String input) {
	   char alphabetFirstChar ='a';
       if (input == null || input.length() < 3) {
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

        	   if(alphabetFirstChar==currentChar)
    		   {
        		   sb.delete(i, j);
    		   }
        	   else
        	   {
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
