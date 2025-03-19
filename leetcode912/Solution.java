package leetcode912;

class Solution {
    public int[] sortArray(int[] nums) {
        int length = nums.length;
        threeWayQuickSort(nums, 0, length - 1);
        return nums;
    }
    public void threeWayQuickSort(int[] nums, int left, int right) {
        if (nums == null || left < 0 || right > nums.length || left > right)
            return;
        int privot = nums[left];
        int low = left;
        int high = right;
        int i = low;
        while (i <= high) {
            if (nums[i] < privot) {
                swap(nums, i++, low++);
            } else if (nums[i] > privot) {
                swap(nums, i, high--);
            } else {
                i++;
            }
        }
        threeWayQuickSort(nums, left, low - 1);
        threeWayQuickSort(nums, high + 1, right);
    }

    public void swap(int[] nums, int r, int i) {
        int tmp = nums[r];
        nums[r] = nums[i];
        nums[i] = tmp;
    }
}
