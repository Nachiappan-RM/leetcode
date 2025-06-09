/**

You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

 

Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3

Example 2:

Input: nums = [1], target = 1
Output: 1

Will we get negative numbers as part of nums? -> no
Will target be in negative? - Maybe


We can use Backtracking - But it will take (2^n)
We can compute sum (Total sum) -> O(n)

Recurrence relation,
CurrentSum + curr.
Currsum - curr
*/


class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return findWays(nums, 0, 0, target, memo);
    }

    private int findWays(int[] nums, int index, int currentSum, int target, Map<String, Integer> memo){
        if(index == nums.length){
            return currentSum == target?1:0;
        }
        String key = index+","+currentSum;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int added = findWays(nums, index+1, currentSum+nums[index], target, memo);
        int subtracted = findWays(nums, index+1, currentSum-nums[index], target, memo);
        int totalWays = added+subtracted;
        memo.put(key, totalWays);
        return totalWays;

    }
}