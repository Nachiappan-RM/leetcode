/**
First and last house are adjacent

So we need to change the base condition here,

Each house can be robbed or skipped,
money[i] = max(nums[i] + money[i-2], money[i-1])

*/

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int n = nums.length;

        if(n == 1) {
            return nums[0];
        }
        int money1 = robLinear(nums, 0, n-2);
        int money2 = robLinear(nums, 1, n-1);
        return Math.max(money1, money2);
    }

    private int robLinear(int[] nums, int start, int end) {
        int n = end - start + 1;

        if( n == 0) {
            return 0;
        }else if(n == 1) {
            return nums[start];
        }

        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start+1], nums[start]);
        for(int i=2; i<n; i++) {
            dp[i] = Math.max(dp[i-1], nums[start+i]+dp[i-2]);
        }

        return dp[n-1];
    }
}