package leetcode506;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 3, 4, 5, 6, 7};
        for (String s : solution.findRelativeRanks(nums)) {
            System.out.println(s);
        }
    }
}
