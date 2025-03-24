package leetcode88;

class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            nums1[m + i] = nums2[i];
        }
        threeWayQuickSort(nums1, 0, nums1.length - 1);
    }

    public static void threeWayQuickSort(int[] nums, int left, int right) {
        if (nums == null || left < 0 || right > nums.length || left > right)
            return;
        int privot = nums[left];
        int low = left;
        int high = right;
        int i = low + 1;
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

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
