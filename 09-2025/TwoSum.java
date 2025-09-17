class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = {0,0};
        int i = 0, j = 1;
        
        while (true) {
            if (nums[i] + nums[j] == target) {
                ans[0] = i;
                ans[1] = j;
                break;
            }

            j++;

            if (j >= nums.length) {
                j = ++i + 1;
            }
        }

        return ans;

    }
}