package leetcode289;

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int tmp = 0;
        int[][] newBoard = new int[m][n];
        int[][] directions = {{-1, -1}, {0, -1}, {-1, 0}, {0, 1}, {1, 0}, {1, 1}, {-1, 1}, {1, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard[0].length; j++) {
                if (newBoard[i][j] == 1) {
                    for (int[] direction : directions) {
                        int x = i + direction[0];
                        int y = j + direction[1];
                        if (x < 0 || y < 0 || x >= m || y >= n)
                            continue;
                        if (newBoard[x][y] == 1)
                            tmp++;
                    }
                    if (tmp < 2 || tmp >3)
                        board[i][j] = 0;
                    tmp = 0;
                } else {
                    for (int[] direction : directions) {
                        int x = i + direction[0];
                        int y = j + direction[1];
                        if (x < 0 || y < 0 || x >= m || y >= n)
                            continue;
                        if (newBoard[x][y] == 1)
                            tmp++;
                    }
                    if (tmp == 3)
                        board[i][j] = 1;
                    tmp = 0;
                }
            }
        }
    }
}