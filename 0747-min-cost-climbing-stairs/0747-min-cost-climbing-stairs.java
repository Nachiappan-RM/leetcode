
/**
class Solution {
    // public int minCostClimbingStairs(int[] cost) {
    //     int n = cost.length;
    //     int[] L = new int[n];
        
    //     L[0] = cost[0];
    //     L[1] = cost[1];
    //     for(int i=2;i<n; i++){   
    //         L[i] = Math.min(L[i-1], L[i-2])+cost[i];
    //     }
    //     // System.out.println(Arrays.toString(L));
    //     return Math.min(L[n-1], L[n-2]);
    // }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        for(int i=2; i<n; i++){
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }
        return Math.min(cost[n-1], cost[n-2]);
    }
}
*/

// ------------- REVISION ---------------
/**
Greedy won't work - But it can change anytime in the middle

DP - Would be the right thing here
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length <= 0) {
            return 0;
        }

        if(cost.length == 1) {
            return cost[0];
        }

        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i=2; i<n; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }

        return Math.min(dp[n-2], dp[n-1]);
    }
}