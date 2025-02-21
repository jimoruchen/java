package leetcode238;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        int[] nums1 = solution.productExceptSelf(nums);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }

}
