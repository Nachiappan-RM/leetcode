/*
class Solution {
    public int maxSubArray(int[] nums) {
        
        //Kadane's Algorithm
        int localMax = nums[nums.length-1];
        int globalMax = nums[nums.length-1];
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] < localMax+nums[i]){
                localMax +=nums[i];
            }else{
                localMax = nums[i];
            }

            globalMax = Math.max(localMax, globalMax);
        }
        return globalMax;
    }
}

*/
/**

Find all the subarray and get the local max and get the max sum
Time - O(n^2)


 */
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length<1) {
            return 0;
        }
        int localSum = nums[0];
        int max = nums[0];

        for(int i=1; i<nums.length; i++) {
            localSum = Math.max(nums[i], localSum + nums[i]);
            if(localSum > max) {
                max = localSum;
            }
        }
        return max;
    }
}