/*
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n== 1){
            return 1;
        }
        int[][] matrix = new int[m][n];
        for(int i=0; i<n; i++){
            matrix[0][i] = 1;
        }

        for(int i=0; i<m; i++){
            matrix[i][0] = 1;
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                matrix[i][j] = matrix[i][j-1] + matrix[i-1][j];
            }
        }

        return matrix[m-1][n-1];
    }
}
*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        dp[m-1][n-1] = 1;

        for (int i = 0; i < m; i++) {
            dp[i][n-1] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[m-1][j] = 1;
        }
        
        for(int i=m-2; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                if(i+1 < m && j+1 < n) {
                    dp[i][j] = dp[i+1][j] +dp[i][j+1] ;
                }else if(i+1<m) {
                    dp[i][j] = dp[i+1][j];
                }else if(j+1<n){
                    dp[i][j] = dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
}