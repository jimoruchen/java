package leetcode54;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int top = 0, left = 0;
        int bottom = m -1, right = n - 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++)
                res.add(matrix[top][j]);
            top++;
            for (int i = top; i <= bottom; i++)
                res.add(matrix[i][right]);
            right--;
            if (left <= right && top <= bottom) {
                for (int j = right; j >= left; j--)
                    res.add(matrix[bottom][j]);
                bottom--;
                for (int i = bottom; i >= top; i--)
                    res.add(matrix[i][left]);
                left++;
            }
        }
        return res;
        //1  2  3  4
        //5  6  7  8
        //9  10 11 12
        //13 14 15 16
    }
}
