package leetcode167;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = new int[]{1, 2, 2, 3, 5, 25, 75};
        int[] result = solution.twoSum(numbers, 4);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + " ");
        }
    }
}
