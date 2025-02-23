package leetcode498;

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0, direction = 0;
        int index = 0;
        while (index < m * n) {
            result[index++] = matrix[row][col];
            if (direction == 0) { // Up-right direction
                if (col == n - 1) {
                    row++;
                    direction = 1;
                } else if (row == 0) {
                    col++;
                    direction = 1;
                } else {
                    row--;
                    col++;
                }
            } else { // Down-left direction
                if (row == m - 1) {
                    col++;
                    direction = 0;
                } else if (col == 0) {
                    row++;
                    direction = 0;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return result;
    }
    //1 2  3  4
    //5 6  7  8
    //9 10 11 12
    //13 14 15 16

}
