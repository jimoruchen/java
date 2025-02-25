package leetcode54;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int row = 0, col = 0;
        int total = m * n;
        int index = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < total; i++) {
            res.add(matrix[row][col]);
            visited[row][col] = true;
            int nextRow = row + directions[index][0], nextCol = col + directions[index][1];
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
                index = (index + 1) % 4;
            }
            row += directions[index][0];
            col += directions[index][1];
        }
        return res;
    }
}
