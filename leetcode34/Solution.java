package leetcode34;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if (nums == null || start == nums.length || nums[start] != target)
            return new int[] {-1, -1};
        int end = lowerBound(nums, target + 1) - 1;
        return new int[] {start, end};
    }
    private static int lowerBound(int[] nums, int target) {      //返回最小的满足>=target的下标
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
