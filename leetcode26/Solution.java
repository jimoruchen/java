package leetcode26;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[slow]) {
                nums[++slow] = nums[i];
            }
        }
        return slow + 1;
    }
}
