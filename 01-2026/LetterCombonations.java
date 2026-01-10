/**
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

1 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/

class Solution {
    public List<String> letterCombinations(String input) {
        List<String> combos = new ArrayList<>();
        int len = input.length();
        int[] letter = new int[len + 1];
        int[] digits = new int[len + 1];

        char[][] keys = {
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
        };

        for (int j = 0; j < len; j++) {
            letter[j] = 0;
            digits[j] = Character.getNumericValue(input.charAt(j)) - 2;
        }
        
        
        while(letter[len] == 0) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < len; i++) {
                temp.append(keys[digits[i]][letter[i]]);
            }
            System.out.println(temp);
            int k = 0;
            while (true) {
                letter[k]++;
                if (letter[k] > 2 && digits[k] != 5 && digits[k] != 7) {
                    letter[k] = 0;
                    k++;
                } else if (letter[k] > 3) {
                    letter[k] = 0;
                    k++;
                } else {
                    break;
                }
            }
            combos.add(temp.toString());
        }

        return combos;
    }
}
