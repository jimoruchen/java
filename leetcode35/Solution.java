package leetcode35;

import java.util.Arrays;

class Solution {
    public int searchInsert(int[] nums, int target) {
        boolean flag = Arrays.stream(nums).anyMatch(i -> i == target);
        if (flag) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
        } else {
            int[] newNums = new int[nums.length + 1];
            newNums[0] = target;
            System.arraycopy(nums, 0, newNums, 1, nums.length);
            Arrays.sort(newNums);
            for (int i = 0; i < newNums.length; i++) {
                if (target == newNums[i]) {
                    return i;
                }
            }
        }
        return -1;
    }
}