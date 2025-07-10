// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         //Create a binary for 2^n and then push all the index with Set 1
//         int n = nums.length;
//         List<List<Integer>> res = new ArrayList<List<Integer>>();
//         for(int i=0; i< 1<<n; i++){
//             List<Integer> sub = new ArrayList<>();
//             for(int j=0;j<n;j++){
//                 if((i & (1<<j))!=0){
//                     sub.add(nums[j]);
//                 }
//             }
//             res.add(sub);
//         }
//         return res;
//     }
// }

// -------- REVISION ------------
class Solution {
    /**
    Increase the size from 0 to n
    Try to see all possible sub array with that size using backtracking
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSets = new ArrayList<>();
        computeSubsets(nums, 0, new ArrayList<>(), powerSets);
        return powerSets;
    }
    //DFS + backtrack
    private void computeSubsets(int[] nums, int i, List<Integer> subset, List<List<Integer>> powerSets) {
        if(i>= nums.length) {
            powerSets.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        computeSubsets(nums, i+1, subset, powerSets);

        //Backtrack
        subset.remove(subset.size()-1);
        computeSubsets(nums, i+1, subset, powerSets);
    }
}