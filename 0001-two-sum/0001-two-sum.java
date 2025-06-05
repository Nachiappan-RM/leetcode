class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        //Accessing time of Map is O(1)
        // diff val -> Key ; Ind of that element gave diff-> Value
        Map<Integer, Integer> diffDict = new HashMap<>();

        // TC - O(n)
        for(int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            int ind = diffDict.getOrDefault(diff, -1);
            if(ind != -1){ //There exist the diff
                res[0] = ind;
                res[1] = i;
                break;
            }else{
                diffDict.put(nums[i], i); //Push the actual num so that in future we can check there exsit such value to add up to other elements giving target
            }
        }
        return res;
    }
}