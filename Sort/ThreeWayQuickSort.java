package Sort;

public class ThreeWayQuickSort {
    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 3, 5};
        int len = nums.length;
        threeWayQuickSort(nums, 0, len - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void threeWayQuickSort(int[] nums, int left, int right) {
        if (nums == null || left < 0 || right > nums.length || left > right) {
            return;
        }
        int pivot = nums[left];
        int low = left;
        int high = right;
        int i = low + 1;
        while (i <= high) {
            if (nums[i] < pivot) {
                swap(nums, i++, low++);
            } else if (nums[i] > pivot) {
                swap(nums, i, high--);
            } else {
                i++;
            }
        }
        threeWayQuickSort(nums, left, low - 1);
        threeWayQuickSort(nums, high + 1, right);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
