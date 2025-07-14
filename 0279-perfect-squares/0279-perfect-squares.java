class Solution {
    /**
    Not greedy - Its going to be bottom - up dynamic programming

    R[n] = 1+ {s=1 to sqrt(n) (s*s) + R[n-(s*s)]}
    
     */
    public int numSquares(int n) {
        int dp[] = new int[n+1];

        dp[0] = 0; // Base

        for(int i=1; i<n+1; i++) {
            dp[i] = i;
            for(int j = 1; j<=i; j++) {
                int square = j * j;

                if(i-square<0){
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i-square] + 1);
            }
        }

        return dp[n];
    }
}