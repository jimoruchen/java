package leetcode724;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int pivotIndex(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        int len = nums.length;
        int count = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                ans += nums[j];
            }
            if (count == ans)
                queue.offer(i);
            ans = 0;
            count += nums[i];
        }
        if (!queue.isEmpty())
            return queue.poll();
        else
            return -1;
    }
}
