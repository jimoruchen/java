package leetcode215;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {6, 7, 5, 4, 8, 9, 1, 2, 12, 23, 3};
        int num = solution.findKthLargest(arr, 3);
        System.out.println(num);
    }
}
