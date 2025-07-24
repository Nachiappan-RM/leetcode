/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return amount;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;

        for(int i=1;i<=amount; i++){
           for(int c: coins){
                if(c <= i){
                    dp[i] = Math.min(dp[i], dp[i-c]+1);
                }
           }
        }
        
        return dp[amount]>amount?-1:dp[amount];
    } 
}
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int INF = amount + 1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, INF);

        dp[0] = 0; //Base case

        for(int i=1; i<=amount; i++) {
            for(int c: coins) {
                if(i>=c) {
                    dp[i] = Math.min(dp[i], dp[i-c] + 1);
                }
            }
        }
        return (dp[amount] == INF) ? -1 : dp[amount];
    }
}

