package leetcode59;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int n = 3;
        int[][] matrix = solution.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
