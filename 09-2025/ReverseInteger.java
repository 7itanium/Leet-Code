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



class Solution {
    public int reverse(int x) {

        /*
        String num = String.valueOf(x);
        StringBuilder temp = new StringBuilder(num);
        num = temp.reverse().toString();
        System.out.print(num);

        int ans = Integer.parseInt(num);
        */

        long ans = 0;
        while (x != 0) {
            int temp = (x % 10);
            ans = (ans * 10) + temp;
            x /= 10;
            if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return 0;
        }
        return (int) ans;
        
    }
}
