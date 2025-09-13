/**
Brute force,
- 2 pointers + cnt to track how many times the current value has appeared

other ways,
- freq map then rewrite the arr -> Extra space
- we could do nested loops to shift elements left whenever we see a 3rd duplicate,
But it could also be exp -> O(n^2)

Complexity of Brute force,
TC - O(n) -> We would be needing one go over nums
SC - O(1) -> only var is good enough right
 */


class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }


        int p = 0, cnt = 0;
        int prev = Integer.MIN_VALUE;

        for(int i=0; i< nums.length; i++){
            if(nums[i]!=prev) {
                prev = nums[i];
                cnt = 1;
            }else{
                cnt++;
            }
            if(cnt <= 2) {
                nums[p] = nums[i];
                p++;
            }
        }

        return p;
    }
}