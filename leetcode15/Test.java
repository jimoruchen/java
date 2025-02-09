package leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1])  continue;
            int target = -nums[i];
            for (int j = i + 1; j < len; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k = len - 1;
                while (j < k && nums[j] + nums[k] > target)
                    k--;
                if (j == k)
                    break;
                if (nums[j] + nums[k] == target) {
                    List<Integer> ans = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    res.add(ans);
                }
            }
        }
        return res;
    }
}
