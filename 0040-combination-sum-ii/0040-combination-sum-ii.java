class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        if(target<=0 || candidates == null || candidates.length == 0) {
            return combinations;
        }
        Arrays.sort(candidates);
        computeCombinations(candidates, target, 0, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private void computeCombinations(int[] candidates, int target, int sum, int index, List<Integer> curr, List<List<Integer>> combinations) {
        if(sum>target) {
            return;
        }

        if(sum == target) {
            combinations.add(new ArrayList<>(curr));
            return;
        }

        for(int i = index; i<candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;

            curr.add(candidates[i]);
            computeCombinations(candidates, target, sum+candidates[i], i+1, curr, combinations);
            curr.remove(curr.size()-1);
        }
    }
}