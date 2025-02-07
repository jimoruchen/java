package leetcode189;

class Solution {
    public int[] rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        int[] nums1 = new int[length];
        for (int i = 0; i < k; i++) {
            nums1[i] = nums[length - k + i] ;
        }
        for (int j = k; j < length; j++) {
            nums1[j] = nums[j - k];
        }
        System.arraycopy(nums1, 0, nums, 0, length);
        return nums;
    }
}
