package leetcode75;

class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        quicksort(nums, 0, len - 1);
    }

    public void quicksort(int[] nums, int left, int right) {
        if (left < right) {
            int partition = partition(nums, left, right);
            quicksort(nums, left, partition);
            quicksort(nums, partition + 1, right);
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
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return j;
    }
}
