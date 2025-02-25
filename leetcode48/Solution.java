package leetcode48;

class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] ans = new int[m * n];
        int k = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                ans[k++] = matrix[i][j];
            }
        }
        k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[j][i] = ans[k++];
            }
        }
        //1 2 3    7 4 1
        //4 5 6    8 5 2
        //7 8 9    9 6 3
    }
}
