package leetcode59;

public class Solution1 {
    public int[][] generateMatrix(int n) {
        int[] nums = new int[n * n];
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n * n; i++)
            nums[i] = i + 1;
        int index = 0, total = n * n;
        int row = 0, col = 0;
        boolean[][] visited = new boolean[n][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < total; i++) {
            matrix[row][col] = nums[i];
            visited[row][col] = true;
            int nextRow = row + directions[index][0], nextCol = col + directions[index][1];
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
                index = (index + 1) % 4;
            }
            row += directions[index][0];
            col += directions[index][1];
        }
        return matrix;
    }
}
