/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 

Constraints:

-231 <= x <= 231 - 1

*/



//I'm aware this is slow, sue me

class Solution {
    public int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x = Math.abs(x);
        }

        String num = String.valueOf(x);
        StringBuilder temp = new StringBuilder(num);
        num = temp.reverse().toString();
        System.out.print(num);

        try {
            int ans = Integer.parseInt(num);
            return (ans * sign);
        } catch (Exception e) {
            return 0;
        }


        
    }
}
