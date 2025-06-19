class Solution {
    // public int findMin(int[] nums) {
    //     int min = nums[0];
    //     for(int i=1;i<nums.length;i++){
    //         if(nums[i]<nums[i-1]){
    //             min = nums[i];
    //             break;
    //         }
    //     }
    //     return min;
    // }

    // -------REVISION--------
    /**
    Try to find the place index that actually decreases -> To find start and and end 
    Do binary from there
    ->O(n + log n)
    
    But Thinking of how I can do that in O(log n)
    Thinking of Binary search

     */
    public int findMin(int[] nums){
        int start = 0;
        int end = nums.length-1;

        while(start<end){
            int mid = start + (end-start)/2;
            if(nums[mid] > nums[end]){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return nums[start];
    }
}