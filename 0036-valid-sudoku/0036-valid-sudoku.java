class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {
                if (!isValid3x3(board, i, j)) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!isValidColumn(board, i))
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i))
                return false;
        }
        return true;
    }

    private boolean isValidRow(char[][] board, int r) {
        boolean[] isVisited = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (board[r][i] != '.') {
                if (isVisited[board[r][i] - '1'])
                    return false;
                isVisited[board[r][i] - '1'] = true;
            }
        }
        return true;
    }

private boolean isValidColumn(char[][] board, int c) {
        boolean[] isVisited = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (board[i][c] != '.') {
                if (isVisited[board[i][c] - '1'])
                    return false;
                isVisited[board[i][c] - '1'] = true;
            }
        }
        return true;
    }


    private boolean isValid3x3(char[][] board, int x, int y) {
        boolean[] isVisited = new boolean[9];

        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] != '.') {
                    if (isVisited[board[i][j] - '1'])
                        return false;
                    isVisited[board[i][j] - '1'] = true;
                }
            }
        }

        return true;
    }
}