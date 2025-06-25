class Solution {
    // public int findDuplicate(int[] nums) {
    //     int tortois = nums[0];
    //     int hare = nums[0];
    //     boolean first =true;

    //     while(first || tortois!=hare){
    //         tortois = nums[tortois];
    //         hare = nums[nums[hare]];
    //         first = false;
    //     }
    //     tortois = nums[0];
    //     while(tortois != hare){
    //         tortois = nums[tortois];
    //         hare = nums[hare];
    //     }
    //     return hare;
    // }

    // ---------REVISION-------------
    public int findDuplicate(int[] nums){
        int n = nums.length;
        /**
        more than 1 times

        With no extra space, sort and loop over.
        TC - O(nlogn + n) <-But this will change the in order of nums

        Since its going to be in the range [1,n] thinking like a pointers 
        we need to find the interection or start point of the cycle
         */

        int slow = nums[0];
        int fast = nums[nums[0]];

        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        //We'll get the intersection we have to reset the fast and make it slow to get start of cycle
        fast = 0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}