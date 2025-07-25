/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        //Recursive approach
        // return recursiveLIS(nums, nums.length, nums.length-1);

        // Bottom-Up Approach
        // return iterativeLIS(nums, nums.length);

        // Top-down approach
        int[] memo = new int[nums.length];
        for(int i=0; i<memo.length; i++){
            memo[i] = -1;
        }
        int maxLIS = 0;
        for (int i = 0; i < nums.length; i++) {
            maxLIS = Math.max(maxLIS, memoizedLIS(nums, nums.length, i, memo));
        }

        return maxLIS;
    }

    private int recursiveLIS(int[] nums, int n, int i){
        if(i==0){ //one element
            return 1;
        }

        int q = 1;
        for(int j=i-1; j>=0; j--){
            if(nums[j]<nums[i]){
                q = Math.max(q, 1+recursiveLIS(nums, n, j));
            }
        }
        return q;
    }
    
    private int iterativeLIS(int[] nums, int n){
        int[] LIS = new int[n];
        int max = 1;

        for(int i=0;i<n;i++){
            LIS[i] = 1;
            for(int j=0; j<i;j++){
                if(nums[j]<nums[i]){
                    LIS[i] = Math.max(LIS[i], 1+LIS[j]);
                }
            }
           max = Math.max(max, LIS[i]);
        }
        return max;
    }

     private int memoizedLIS(int[] nums, int n, int i, int[] memo){
        if(memo[i]!=-1){
            return memo[i];
        }
        if(i==0){ //one element
            memo[i] = 1;
            return 1;
        }

        int q = 1;
        for(int j=0; j<i; j++){
            if(nums[j]<nums[i]){
                if(memo[j] == -1){
                    memo[j] = memoizedLIS(nums, n, j, memo);
                }
                q = Math.max(q, 1+memo[j]);
            }
        }
        memo[i] = q;
        return q;
    }
}
*/

// --------REVISION-------
class Solution {
    public int lengthOfLIS(int[] nums){
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int dp[] = new int[nums.length];

        Arrays.fill(dp, 1);
        int maxLength = 1;
        for(int i=1; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLength = Math.max(dp[i], maxLength);
        }

        return maxLength;
    }
}