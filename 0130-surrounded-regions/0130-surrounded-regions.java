/**
class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0,-1}};
    public void solve(char[][] board) {
        int m = board.length;
        if(m==0) return;
        int n = board[0].length;
        if(n==0) return;

        boolean[][] isVisited = new boolean[m][n];

        for(int i=0; i<m; i++){
            visitConnectedRegions(board, isVisited, i, 0, m, n);
            visitConnectedRegions(board, isVisited, i, n-1, m, n);
        }

        for(int i=0; i<n; i++){
            visitConnectedRegions(board, isVisited, 0, i, m, n);
            visitConnectedRegions(board, isVisited, m-1, i, m, n);
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='O' && !isVisited[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }

    private void visitConnectedRegions(char[][] board, boolean[][] isVisited, int x,int y, int m, int n){
        if(x<0 || y<0 || x>=m || y>=n || isVisited[x][y] || board[x][y] == 'X'){
            return;
        }
        isVisited[x][y] = true;
        for(int[] dir: directions){
            visitConnectedRegions(board, isVisited, x+dir[0], y+dir[1], m, n);
        }
    }
}
*/
// ----------- REVISION -----------
class Solution {
    public void solve(char[][] board) {
        /*
        DFS Flood fill from all the edge of the matrix change the  edge 'O' region to 'R'
        Convert all the R to O and rest everything to X in the last

        Instead of 'R' i can use isVisited itself
        */

        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        boolean isVisited[][] = new boolean[m][n];

        for(int i=0; i<m; i++) {
            dfs(board, isVisited, i, 0);
            dfs(board, isVisited, i, n-1);
        }

        for(int i=0; i<n; i++) {
            dfs(board, isVisited, 0, i);
            dfs(board, isVisited, m-1, i);
        }

        for(int i=0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(isVisited[i][j]) {
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }
    private final int[][] DIRECTIONS = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    private void dfs(char[][] board, boolean[][] isVisited, int i, int j) {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || isVisited[i][j] || board[i][j] == 'X') {
            return;
        }

        isVisited[i][j] = true;
        for(int[] direction : DIRECTIONS) {
            dfs(board, isVisited, i+direction[0], j+direction[1]);
        }
    }
}