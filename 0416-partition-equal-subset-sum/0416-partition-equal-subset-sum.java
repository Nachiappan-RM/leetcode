class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }

        if(sum % 2 == 1) return false;

        int target = sum/2;
        HashSet<Integer> computedSums = new HashSet<>();
        computedSums.add(0);

        for(int i = 0; i<nums.length; i++) {
            for(int val : new ArrayList<>(computedSums)) {
                if(val + nums[i] == target) {
                    return true;
                }
                computedSums.add(val + nums[i]);
            }
        }

        return false;
    }
}