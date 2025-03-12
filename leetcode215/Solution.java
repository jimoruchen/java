package leetcode215;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        quicksort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public void quicksort(int[] nums, int left, int right) {
        if (left < right) {
            int privot = partition(nums, left, right);
            quicksort(nums, left, privot);
            quicksort(nums, privot + 1, right);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left - 1;
        int j = right + 1;
        while (i < j) {
            do i++; while (nums[i] < pivot);
            do j--; while (nums[j] > pivot);
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return j;
    }
}
