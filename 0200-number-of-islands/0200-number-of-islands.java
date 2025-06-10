class Solution {
    // int islandCount = 0;
    // public int numIslands(char[][] grid) {
    //     if(grid.length!=0){
    //         boolean[][] visited = new boolean[grid.length][grid[0].length];
    //         for(int row =0; row<grid.length; row++){
    //             for(int col=0; col<grid[row].length; col++){
    //                 if(!visited[row][col] && grid[row][col]== '1'){
    //                     islandCount+=1;
    //                     // System.out.printf("row: %d, col: %d, cnt: %d\n", row, col, islandCount);
    //                     lookForIsland(grid, visited, row, col);
    //                 }
    //             }
    //         }
    //     }
    //     return islandCount;
    // }

    // private void lookForIsland(char[][] grid, boolean[][] visited, int row, int col){
    //     if(row<0 || col<0 || row>=grid.length || col >= grid[0].length
    //         || visited[row][col] || grid[row][col]=='0'){
    //         return;
    //     }

    //     visited[row][col] = true;
    //     lookForIsland(grid, visited, row+1, col);
    //     lookForIsland(grid, visited, row-1, col);
    //     lookForIsland(grid, visited, row, col+1);
    //     lookForIsland(grid, visited, row, col-1);
    // }

    // public int numIslands(char[][] grid) {
    //     int m = grid.length;
    //     int n = grid[0].length;

    //     int island = 0;
    //     int[][] isVisited = new int[m][n];

    //     for(int i=0; i<m; i++){
    //         for(int j=0; j<n; j++){
    //             if(isVisited[i][j] == 0 && grid[i][j] == '1'){
    //                 island +=1;
    //                 findIsland(grid, isVisited, i, j, m, n);
    //             }
    //         }
    //     }

    //     return island;
    // }
    // private void findIsland(char[][] grid, int[][] isVisited, int i, int j, int m, int n){
    //     if(i<0 || j<0 || i>=m || j>=n || isVisited[i][j]==1 || grid[i][j] != '1'){
    //         return;
    //     }

    //     isVisited[i][j] = 1; 

    //     findIsland(grid, isVisited, i+1, j, m, n);
    //     findIsland(grid, isVisited, i-1, j, m, n);
    //     findIsland(grid, isVisited, i, j+1, m, n);
    //     findIsland(grid, isVisited, i, j-1, m, n);
        
    // }

    int[][] directions = {{1,0}, {0,-1}, {0,1}, {-1,0}};
    public int numIslands(char[][] grid){
        int m = grid.length;
        if(m==0) return 0;
        int n = grid[0].length;
    
        boolean isVisited[][] = new boolean[m][n];
        int islandCount = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && !isVisited[i][j]){
                    searchIsland(grid, isVisited, i, j, m, n);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private void searchIsland(char[][] grid, boolean[][] isVisited, int i, int j, int m, int n){
        if(i>=m || j>=n || i<0 || j<0 || isVisited[i][j] || grid[i][j] == '0'){
            return;
        }
        isVisited[i][j] = true;
        for(int[] dir: directions){
            searchIsland(grid, isVisited, i+dir[0], j+dir[1], m, n);
        }
    }
}