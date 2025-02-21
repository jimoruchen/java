package leetcode238;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int tmp = 1;
        int[] ans = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0)
                left[i] = left[i - 1] * nums[i - 1];
            else
                left[i] = tmp;
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            if (j < nums.length - 1)
                right[j] = right[j + 1] * nums[j + 1];
            else
                right[j] = tmp;
        }
        for (int k = 0; k < nums.length; k++) {
            ans[k] = left[k] * right[k];
        }
        return ans;
    }
}
