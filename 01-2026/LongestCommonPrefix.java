/**
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.
*/

//Solution 2
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String common = strs[0];

        for (String word: strs) {
            while(!word.startsWith(common)) {
                common = common.substring(0, common.length() - 1);
            }
        }

        return common;
    }
}

//Solution 1
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String common = strs[0];
        int small = common.length();
        int len = 0;

        for (String word : strs) {
            if (word == common) {
                continue;
            }
            len = word.length();
            for (int i = 0; i < Math.min(len, common.length()); i++) {
                if (word.charAt(i) != common.charAt(i)) {
                    common = word.substring(0,i);
                    break;
                }
            }
            if (small > len) {
                small = len;
            }
        }

        if (common.length() > small) {
            common = common.substring(0,small);
        }

        return common;
    }
}
