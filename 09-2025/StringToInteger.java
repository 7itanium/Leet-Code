/*
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

The algorithm for myAtoi(string s) is as follows:

Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
Return the integer as the final result.

 

Example 1:

Input: s = "42"

Output: 42

Explanation:

The underlined characters are what is read in and the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
           ^
Example 2:

Input: s = " -042"

Output: -42

Explanation:

Step 1: "   -042" (leading whitespace is read and ignored)
            ^
Step 2: "   -042" ('-' is read, so the result should be negative)
             ^
Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
               ^
Example 3:

Input: s = "1337c0d3"

Output: 1337

Explanation:

Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
         ^
Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
             ^
Example 4:

Input: s = "0-1"

Output: 0

Explanation:

Step 1: "0-1" (no characters read because there is no leading whitespace)
         ^
Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
          ^
Example 5:

Input: s = "words and 987"

Output: 0

Explanation:

Reading stops at the first non-digit character 'w'.

 

Constraints:

0 <= s.length <= 200
s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.

*/

class Solution {
    public int myAtoi(String s) {
        StringBuilder ans = new StringBuilder();
        boolean seenZero = false;
        int neg = 1;
        int start = 0;

        checkForStart:
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '0') {
                seenZero = true;
                continue;
            } else if (Character.isWhitespace(current) && seenZero == false) {
                continue;
            } else if (Character.isDigit(current)) {
                start = i;
                break checkForStart;
            } else if (current == '-' || current == '+') {
                if (current == '-') neg = -1;
                start = i + 1;
                if (seenZero == true) start = s.length();
                break checkForStart;
            } else {
                break checkForStart;
            }
        }

        getNum:
        for (int i = start; i < s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                ans.append(current);
            } else {
                break getNum;
            }
        }


/*        mainloop:
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                if (started == false && current == '0') {
                    seenZero = true;
                    continue mainloop;
                }
                ans.append(current);
                started = true;
            } else if (started == false && seenZero == false) {
                int index = Arrays.binarySearch(allowed, current);
                System.out.print(current);
                System.out.println(index);
                switch (index) {
                    case 1:
                        neg = -1;
                        continue mainloop;
                    case 0:
                        continue mainloop;
                    case 2:
                        continue mainloop;
                    default:
                        break mainloop;
                } 
            } else {
                break mainloop;
            }
        } */

        
        /*
        if (ans.length() == 0) ans.append("0");
        long fin = Long.parseLong(ans.toString());
        if (fin > Integer.MAX_VALUE) {
            fin = Integer.MAX_VALUE;
            if (neg == -1) fin += 1;
        } */

        int fin = 0;
        if (ans.length() == 0) ans.append("0");
        try {
            fin = Integer.parseInt(ans.toString());
        } catch (Exception e) {
            fin = Integer.MAX_VALUE;
            if (neg == -1) fin += 1;
        }
        
        
        return fin * neg;

            

        
    }
}
