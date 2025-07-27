class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums); // sort to keep the duplicates adjacent
        List<List<Integer>> result = new ArrayList<>();

        //Start backstracking with an empty subset
        backtrack(nums, 0, new ArrayList<>(), result);
        
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // Add a copy of the current subset to the result
        result.add(new ArrayList<>(current));

        //Loop through the numbers starting from 'start'
        for(int i=start; i<nums.length; i++) {
            //If this is a duplicate and not the first occurence at this level, skip it
            if(i > start && nums[i] == nums[i-1]) {
                continue; //skip duplicates
            }

            current.add(nums[i]);
            
            backtrack(nums, i+1, current, result);
            current.remove(current.size() - 1);
        }
    }
}