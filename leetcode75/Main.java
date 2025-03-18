package leetcode75;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = {2,0,2,1,1,0};
        solution.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
