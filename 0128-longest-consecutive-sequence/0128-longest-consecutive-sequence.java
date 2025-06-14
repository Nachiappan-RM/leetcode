import java.util.Map.Entry;

class Solution {
    // public int longestConsecutive(int[] nums) {
    //     if(nums.length == 0){
    //         return 0;
    //     }
    //     HashSet<Integer> uniqueElements = converArrayToSet(nums);

    //     int max=1;
    //     for(int s : uniqueElements){
    //         if(!uniqueElements.contains(s-1)){
    //             int cnt=1;
    //             int temp = s;
    //             while(uniqueElements.contains(temp+1)){
    //                 cnt++;
    //                 temp++;
    //             }
    //             max = max<cnt ? cnt : max;
    //         }
    //     }

    //     return max;
    //     /* 
    //     // HashMap approach
    //     int longest = 0;
    //     //Key - nums[i] -> value longest with that(local longest)
    //     HashMap<Integer, Integer> numberSeqCount = new HashMap<>();

    //     for(int i=0; i<nums.length; i++){
    //         //When there is a greater than element comes update the map for it and global.
    //         if(numberSeqCount.containsKey(nums[i]+1) || numberSeqCount.containsKey(nums[i]-1)){
    //             int seqCountPrev = 0; 
    //             if(numberSeqCount.containsKey(nums[i]+1)){
    //                 seqCountPrev += numberSeqCount.get(nums[i]+1);
    //                 numberSeqCount.put(nums[i]+1, numberSeqCount.get(nums[i]+1)+1);
    //             }
    //             if(numberSeqCount.containsKey(nums[i]-1)){
    //                 seqCountPrev += numberSeqCount.get(nums[i]-1);
    //                 numberSeqCount.put(nums[i]-1, numberSeqCount.get(nums[i]-1)+1);
    //             }
    //             if(numberSeqCount.containsKey(nums[i])){
    //                 numberSeqCount.put(nums[i], seqCountPrev+numberSeqCount.get(nums[i]));
    //             }else{
    //                 numberSeqCount.put(nums[i], seqCountPrev+1);
    //             }
    //             System.out.println("-----------"+nums[i]+"-----------");
    //             for(Entry<Integer, Integer> entry: numberSeqCount.entrySet()){
    //                 System.out.println(entry.getKey() +" : "+entry.getValue());
    //             }

    //             if(longest<seqCountPrev+1){
    //                 longest = seqCountPrev+1;
    //             }
    //         }else{
    //             numberSeqCount.put(nums[i], 1);
    //         }   
    //     }
    //     return longest;
    //     */
    // }

    // private HashSet<Integer> converArrayToSet(int[] nums){
    //     HashSet<Integer> set = new HashSet<>();
    //     for(int v=0; v<nums.length; v++){
    //         set.add(nums[v]);
    //     }
    //     return set;
    // }

    // -------REVISITION-------- 
    /**
    Initial thought sort and get max consecutive elements - O(nlog n + n)
    
    HashMap - To check whether the 
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        for (int num : numSet) {
            // Only check the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

}