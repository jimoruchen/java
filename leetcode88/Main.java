package leetcode88;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,3,2};
        int m = nums1.length - nums2.length;
        int n = nums2.length;
        solution.merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}
