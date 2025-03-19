package leetcode75;

public class Solution2 {
    public int[] sortColors(int[] nums) {
        threeWayQuickSort(nums, 0, nums.length - 1);
        return nums;
    }
    public static void threeWayQuickSort(int[] nums, int low, int high) {
        if (nums ==null || low < 0 || high > nums.length || low > high) {
            return;
        }
        int pivot = nums[low];
        int lt = low;
        int gt = high;
        int i = low + 1;
        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, i++, lt++);
            } else if (nums[i] > pivot) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        threeWayQuickSort(nums, low, lt - 1);
        threeWayQuickSort(nums, gt + 1, high);
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
