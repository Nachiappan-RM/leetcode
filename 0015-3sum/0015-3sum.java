class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        /*
        Sort nums

        2 points Approach:
        Loop 0-Len(nums)
            l=i+1, r=nums-1, expectedTwoSum= 0-nums[i]
            if(nums[l] + nums[r] == expectedTwoSum){
                Add to the list(nums[l], nums[r], nums[i]);
                //Remove Duplicates
                while(l!=nums.length-1 && nums[l+1] == nums[l]){
                    l++;
                }
                while(r!=0 && nums[r-1] == nums[r]){
                    r--;
                }
            }else if(nums[l] + nums[r] < expectedTwoSum){
                l++;
            }else{
                r++;
            }
        */
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if(i == 0 || nums[i-1] != nums[i]){
                int l=i+1, r = nums.length-1, expectedTwoSum = 0-nums[i];
                while(l<r){
                    if(nums[l] + nums[r] == expectedTwoSum){
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        res.add(list);

                        while(l<r && nums[l+1] == nums[l]){
                            l++;
                        }
                        while(l<r && nums[r-1] == nums[r]){
                            r--;
                        }
                        l++;
                        r--;
                    }else if(nums[l] + nums[r] < expectedTwoSum){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        
        return res;
    }
    
}