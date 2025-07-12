/*
class Solution {
    private int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        
        if(grid.length == 0){
            return maxArea;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int row=0; row<grid.length; row++){
            for(int col=0; col<grid[row].length; col++){
                if(!visited[row][col] && grid[row][col] == 1){
                    int area = getIsland(row, col, visited, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int getIsland(int row, int col, boolean[][] visited, int[][] grid){
        if(row<0 || row>=grid.length 
        || col<0 || col>= grid[0].length 
        || grid[row][col] == 0 || visited[row][col]){
            return 0;
        }

        int area = 1;
        visited[row][col] = true;
        // System.out.printf("row: %d, col: %d, area: %d\n", row, col, area);
        area += getIsland(row+1, col, visited, grid);
        area += getIsland(row-1, col, visited, grid);
        area += getIsland(row, col+1, visited, grid);
        area += getIsland(row, col-1, visited, grid);
        return area;
    }
}
*/

// -------- REVISION --------------
class Solution {
    private int area = 0;
    private final int[][] DIRECTIONS = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        if(grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        if(m==0 || n==0) {
            return 0;
        }

        boolean[][] isVisited = new boolean[m][n];

        for(int x=0; x<m; x++) {
            for(int y=0; y<n; y++) {
                if(grid[x][y] == 1 || !isVisited[x][y]) {
                    area = 0;
                    dfsIsland(grid, isVisited, x, y, m, n);
                    if(area>maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }

    private void dfsIsland(int[][] grid, boolean[][] isVisited, int x, int y, int m, int n) {
        if(x<0 || y<0 || x>=m || y>=n || isVisited[x][y] || grid[x][y] == 0) {
            return;
        }

        area++;
        isVisited[x][y] = true;
        for(int[] direction: DIRECTIONS) {
            dfsIsland(grid, isVisited, x+direction[0], y+direction[1], m, n);
        }
    }
}