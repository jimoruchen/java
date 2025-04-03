package leetcode34;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5,7,7,8,8,10};
        int target = 7;
        int[] ans = solution.searchRange(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
