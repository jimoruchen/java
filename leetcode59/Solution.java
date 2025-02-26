package leetcode59;

class Solution {
    public int[][] generateMatrix(int n) {
        int[] nums = new int[n * n];
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n * n; i++)
            nums[i] = i + 1;
        int index = 0;
        int top = 0, left = 0;
        int bottom = n - 1, right = n - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = nums[index++];
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = nums[index++];
            }
            right--;
            if (left <= right && top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = nums[index++];
                }
                bottom--;
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = nums[index++];
                }
                left++;
            }
        }
        return matrix;
    }
}
