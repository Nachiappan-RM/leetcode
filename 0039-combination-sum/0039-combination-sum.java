/**
Will it be in sorted order - no
can I use one same number multiple times - Yes
only positive numbers

To return all the unique combinations of candidates.
keep on increasing the window size until we get the 
                                      Number
                                    /       \
                    adding that number      not adding that number
                    /    \
repeat the same number   not repeating the same number


 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        if (target <= 0 || candidates == null || candidates.length == 0) {
            return combinations;
        }
        computeCombinationSum(candidates, target, 0, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private void computeCombinationSum(int[] candidates, int target, int sum, int index, List<Integer> combination,
            List<List<Integer>> combinations) {
        if (index >= candidates.length || sum > target) {
            return;
        }

        if (sum == target) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        // (sum < target) 
        combination.add(candidates[index]);
        //repeat same number
        computeCombinationSum(candidates, target, sum+candidates[index], index, combination, combinations);
        combination.remove(combination.size() - 1); //backtrack
        
        //Skipping the number
        computeCombinationSum(candidates, target, sum, index+1, combination, combinations);
    }
}