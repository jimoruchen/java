package leetcode75;

public class Solution1 {
    void sortColors(int[] nums) {
        int ptr = 0;
        int length = nums.length;
        for (int i = 0; i < length; ++i) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = tmp;
                ++ptr;
            }
        }
        for (int i = ptr; i < length; ++i) {
            if (nums[i] == 1) {
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = tmp;
                ++ptr;
            }
        }
    }
}
