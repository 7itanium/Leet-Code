/*
Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 */

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        String ans = String.valueOf(s.charAt(0));
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = expandFromCenter(s,i,i);
            int even = expandFromCenter(s,i,i + 1);
            int temp = Math.max(odd,even);
            
            if (temp > size) {
                size = temp;
                ans = s.substring(i-(size/2)+((size+1) % 2),i+(size/2)+1);
            }
        }
        

        return ans;
    }

    private int expandFromCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}