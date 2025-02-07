package leetcode189;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int k = 3;
        for (int num : solution.rotate(nums, k))
            System.out.print(num + " ");
    }
}
