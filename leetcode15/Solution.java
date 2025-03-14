package leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) return res;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int k = len - 1;
            int target = -nums[i];
            for (int j = i + 1; j < len; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                while (j < k && nums[j] + nums[k] > target)
                    --k;
                if (j == k) break;
                if (nums[j] + nums[k] == target) {
                    List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    res.add(triplet);
                }
            }
        }
        return res;
    }
}
