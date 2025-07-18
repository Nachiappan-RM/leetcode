// class Solution {
//     public boolean canJump(int[] nums) {
//         // /*
//         // check the current value is length - (current_index+1)
//         // */
//         // int len = nums.length;
//         // if(nums[len-1] == 0){
//         //     return true;
//         // }
//         // if(len==1){
//         //     if(nums[0] == 1){
//         //     return true;
//         //     }else{
//         //         return false;
//         //     }
//         // }
//         // for(int i=0; i<len;i++){
//         //     if(nums[i]%len == len-(i+1)){
//         //         return true;
//         //     }
//         // }
//         // return false;

//         // int len = nums.length;
//         // int i = 0;
//         // while(i<= len-1){
//         //     if(i == len-1 || nums[i] >= (len-i-1)){
//         //         return true;
//         //     }
//         //     if(nums[i] == 0){
//         //        return false;
//         //     }
//         //     i += nums[i];
//         // }
//         // if(i >= len-1){
//         //     return true;
//         // }
//         // return false;

//         int len = nums.length;
    
//         if(len == 1){
//             return (nums[0] == 0 || nums[0]==1);
//         }

//         int noRoute = 0;

//         for(int i=len-2; i>=0; i--){
//             if(nums[i] > noRoute){
//                 noRoute = 0;
//             }else if(nums[i] <= noRoute){
//                 noRoute++;
//             }
//         }
//         return (noRoute==0);
//     }
// }

/**
nums is a integer array,
starting is first index and each value says maximum jump length at that position.

return true if it can reach the last index if not false

examples,
[2,3,1,1,4] -> true
[3,2,1,0,4] -> false
 */
 // ---------- REVISION -------------
class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for(int i=0; i<nums.length; i++) {
            if(i > farthest) {
                return false; // can't reach this position
            }

            // Update the farthest index
            farthest = Math.max(farthest, i+ nums[i]);

            if(farthest >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}