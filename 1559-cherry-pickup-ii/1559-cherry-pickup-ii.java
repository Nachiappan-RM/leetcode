class Solution {
    private int m, n;
    private int[][][] dp;

    public int cherryPickup(int[][] grid) {
        if(grid == null) {
          return 0;
        }
        this.m = grid.length;
        this.n = grid[0].length;

        dp = new int[m][n][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(grid, 0, 0, n-1);
    }

    private int helper(int[][] grid, int row, int c1, int c2) {

      if(row == m) {
        return 0;
      }

      if(dp[row][c1][c2] != -1) {
        return dp[row][c1][c2];
      }

      int gain = grid[row][c1];
      int best = 0;
      if(c1 != c2) {
        gain += grid[row][c2];
      }

      for(int d1 = -1; d1<=1; d1++) {
        for(int d2 = -1; d2<=1; d2++) {
          int nc1 = c1+d1;
          int nc2 = c2+d2;

          if(nc1 < 0 || nc1>=n || nc2<0 || nc2>=n) {
            continue;
          }

          int temp = gain + helper(grid, row+1, nc1, nc2);
          best = Math.max(best, temp);
        }
      }

      dp[row][c1][c2] = best;
      return best;
    }
}
/**

We have 2 Person one is in Top row first and Another person is in top row last,
  same column
  column - 1
  column + 1

  Always = ROW + 1
Example,
grid = [
  [3,1,1],
  [2,5,1],
  [1,5,5],
  [2,1,1]
  ]
  
  [
  [1],
  [2]
  ]

output = 24


#1 Person path, (3 + 2 + 5 + 2) = 12.
#2 Person path, (1 + 5 + 5 + 1) = 12.

First,
- thinking of DFS - tries every possible ways

Other Solutions,
- Some way to opmizing would be DP/Memoization

dfs(row1, col1, col2 sumSoFar)

Each of the row have upto 9 recursive calls,
So time -> O(9^m)
Space -> O(m)

m rows
n cols

Each person can still go to 3 cols only
1 Person X 3 moves => 2Person X 3 moves = 9 recursive calls 

Optimized would be top-down dp,
Using 3D - dp[row][c1][c2] -> initized to -1
define a helper(row, c1, c2)
if(row == m) return 0
if dp[row][c1][c2] != -1 return it
otherwise each d1, d2 in {-1, 0, 1} compute
nc1 = c1+d1

Time - O(m*n*n*9) -> O(m*n^2)
Space - O(m*n^2) 
*/