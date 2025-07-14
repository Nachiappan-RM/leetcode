
/**
// Brute force
class Solution {
    
    // Pacific Ocean - row 0 or column 0
    // Atlantic Ocean - row n-1 or column n-1

    // if its more than 1X1, 2 points that shared both matrix[0][n-1] and matrix[m-1][0]
     
    private final int[][] DIRECTIONS = {{0,1},{1,0},{-1,0},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> results = new ArrayList<>();

        if(heights == null || heights.length == 0 || heights[0].length == 0) {
            return results;
        }
        int m = heights.length;
        int n = heights[0].length;

        boolean canReachP[][] = new boolean[m][n];
        boolean canReachA[][] = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j =0; j<n; j++) {
                canReachP[i][j] = canReachPacific(heights, i, j, m, n, canReachP, new boolean[m][n]);
                canReachA[i][j] = canReachAtlantic(heights, i, j, m, n, canReachA, new boolean[m][n]);
               
                if(canReachP[i][j] && canReachA[i][j]) {
                    results.add(Arrays.asList(i,j));
                }
            }
        }
        return results;
    }
    
    private boolean canReachPacific(int[][] heights, int i, int j, int m, int n, boolean[][] canReach, boolean[][] isVisited) {
        if(canReach[i][j] || i == 0 || j == 0) {
            return true;
        }
        isVisited[i][j] = true;
        boolean reachable = false;
        for(int[] dir : DIRECTIONS) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x>=0 && y>=0 && x<m && y<n && !isVisited[x][y] && heights[x][y] <= heights[i][j]) {
                reachable = reachable || canReachPacific(heights, x, y, m, n, canReach, isVisited);
            }
        }

        return reachable;
    }

    private boolean canReachAtlantic(int[][] heights, int i, int j, int m, int n, boolean[][] canReach, boolean[][] isVisited) {
        if(canReach[i][j] || i == m-1 || j == n-1) {
            return true;
        }
        isVisited[i][j] = true;
        boolean reachable = false;
        for(int[] dir : DIRECTIONS) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x>=0 && y>=0 && x<m && y<n && !isVisited[x][y] && heights[x][y] <= heights[i][j]) {
                reachable = reachable || canReachAtlantic(heights, x, y, m, n, canReach, isVisited);
            }
        }

        return reachable;
    }
}
 */

class Solution {
    private final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> results = new ArrayList<>();

        if(heights == null || heights.length == 0 || heights[0].length == 0) {
            return results;
        }
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i = 0; i<m; i++) {
            dfs(heights, pacific, i, 0, m, n); // First Column
            dfs(heights, atlantic, i, n-1, m, n); // Last column
        }

        for(int i = 0; i<n; i++) {
            dfs(heights, pacific, 0, i, m, n); // First Row
            dfs(heights, atlantic, m-1, i, m, n); // Last Row
        }

        for(int i=0; i<m; i++) {
            for(int j =0 ;j<n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    results.add(Arrays.asList(i,j));
                }
            }
        }
        return results;
    }

    private void dfs(int[][] grid, boolean[][] isVisited, int i, int j, int m, int n) {
        
        isVisited[i][j] = true;
        for(int[] dir : DIRECTIONS) {
            int x = i+dir[0];
            int y = j+dir[1];
            if(x>=0 && y>=0 && x<m && y<n && !isVisited[x][y] && grid[x][y] >= grid[i][j]) {
                dfs(grid, isVisited, x, y, m, n);
            }
        }
    }
}