package leetcode724;

import java.util.Arrays;

public class Solution1 {
    public int pivotIndex(int[] nums) {
        int count = Arrays.stream(nums).sum();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * ans == count - nums[i])
                return i;
            ans += nums[i];
        }
        return -1;
    }
}
