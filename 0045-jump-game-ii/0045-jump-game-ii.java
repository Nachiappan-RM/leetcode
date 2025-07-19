// class Solution {
//     /*
//     Given
//     - There is a path available to last value
//     */
//     public int jump(int[] nums) {

//         int len = nums.length;

//         if(len==1){
//             return 0;
//         }

//         int jump = 0;
//         int currentEndJump = 0;
//         int maxJump = 0;

//         for(int i=0;i<len;i++){
//             maxJump = Math.max(maxJump, i+nums[i]);
//             //When Encounter greater maxJump 
//             if(maxJump>=len-1){
//                 jump++;
//                 break;
//             }
//             //Changing the current end jump to the max one, Since we didn't find solutions in between
//             if(i == currentEndJump){
//                 jump++;
//                 currentEndJump = maxJump;
//             }
//         }
//         return jump;
//     }
// }


// ----------- REVISION -----------------

class Solution {
    public int jump(int[] nums) {
        int farthest = 0;
        int jumps = 0;
        int currentEnd = 0;
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] + i > farthest) {
                farthest = nums[i]+i;
            }

            if(currentEnd == i) {
                jumps++;
                currentEnd = farthest;
                if(currentEnd >= nums.length-1) {
                    break;
                }
            }
        }
        return jumps; //Assured there is a poosible way
    }
}









