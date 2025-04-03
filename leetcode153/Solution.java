package leetcode153;

class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;
        quickSort(nums, 0, length - 1);
        return nums[0];
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int privot = partition(nums, left, right);
            quickSort(nums, left, privot);
            quickSort(nums, privot + 1, right);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left - 1;
        int j = right + 1;
        while (i < j) {
            do i++; while (nums[i] < pivot);
            do j--; while (nums[j] > pivot);
            if (i < j) {
                swap(nums, i, j);
            }
        }
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
