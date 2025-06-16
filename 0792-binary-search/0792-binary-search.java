class Solution {
    // public int search(int[] nums, int target) {
    //     int l = 0, r=nums.length-1;
    //     while(l<=r){
    //         int mid = l +(r-l)/2;
    //         if(nums[mid] == target){
    //             return mid;
    //         }else if(nums[mid]<target){
    //             l = mid+1;
    //         }else{
    //             r = mid-1;
    //         }
    //     }
    //     return -1;
    // }

    // --------REVISION----------
    public int search(int[] nums, int target){
        // Its sorted to find something -> search in sorted -> binary search

        if(nums == null || nums.length == 0){
            return -1;
        }
        int n = nums.length;

        //Edge purning
        if(nums[n-1]<target || nums[0]>target) return -1;

        int start=0, end = n-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return -1;
    }
}