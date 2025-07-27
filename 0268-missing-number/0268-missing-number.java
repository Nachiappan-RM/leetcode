/*
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i : nums){
            sum+=i;
        }
        return ((n+1)*n)/2 - sum;
    }
}
*/

class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;

        for (int i = 0; i < nums.length; i++) {
            xor ^= i;
            xor ^= nums[i];
        }
        xor ^= nums.length;
        return xor;
    }
}