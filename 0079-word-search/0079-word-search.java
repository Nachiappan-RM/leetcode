
// class Solution {
//     public boolean exist(char[][] board, String word) {
//         /*
//         We might need an array to keep track of visited
//         */

//         for(int i=0 ;i<board.length; i++){
//             for(int j=0 ;j<board[i].length; j++){
//                 if(board[i][j] == word.charAt(0)){
//                     boolean[][] isVisited = new boolean[board.length][board[i].length];
//                     if(check(board, word, isVisited, i, j, 0)){
//                         return true;
//                     }
//                 }
//             }
//         }

//         return false;
//     }

//     private boolean check(char[][] board,String word, boolean[][] isVisited, int i, int j, int c){
//         if(c == word.length()){
//             return true;
//         }

//         // Check boundaries and whether the cell matches the current character
//         if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || isVisited[i][j] || board[i][j] != word.charAt(c)) {
//             return false;
//         }

//         // Mark this cell as visited
//         isVisited[i][j] = true;


//         // Explore all four directions
//         boolean found = check(board, word, isVisited, i + 1, j, c + 1) ||
//                         check(board, word, isVisited, i - 1, j, c + 1) ||
//                         check(board, word, isVisited, i, j + 1, c + 1) ||
//                         check(board, word, isVisited, i, j - 1, c + 1);

//         // Unmark this cell for other paths
//         isVisited[i][j] = false;

//         return found;
//     }
// }


// ----------- REVISION ------------
class Solution {
    final int[][] DIRECTIONS = {{0,1}, {1,0}, {-1,0}, {0, -1}};
    public boolean exist(char[][] board, String word) {

        if(word == null || board == null || board.length == 0 || word.equals("")) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(search(board, new boolean[m][n],i, j, m, n, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, boolean[][] isVisited, int i, int j, int m, int n, String word, int index) {
        if(index == word.length()) {
            return true;
        }

        if(i>=m || j>=n || i<0 || j<0 || isVisited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        isVisited[i][j] = true;

        for(int[] dir : DIRECTIONS) {
            if(search(board, isVisited,i+dir[0], j+dir[1], m, n, word, index+1)) {
                return true;
            }
        }

        isVisited[i][j] = false; // Backtracking
        return false;
    }
}