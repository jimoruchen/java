package test;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = extend(nums1, 2);
        for(int num : nums2)
            System.out.println(num);
    }
    public static int[] extend(int[] nums1, int enlarge) {
        int[] nums = new int[nums1.length + enlarge];
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }
        return nums;
    }
}