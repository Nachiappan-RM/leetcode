class Solution {
    // public int search(int[] nums, int target) {

    //     /*
    //     Trying to find adjacent values not increasing order like(7, 0)-O(logn)
    //     Assign 7 as end and 0 as start of binary search-O(log n)
    //     */

    //     int start = 0;
    //     int end = nums.length;
    
    //     int mid = (start+end)%nums.length;
    //     int prev = (mid-1+nums.length)%nums.length; 
    //     while(nums[mid] > nums[prev]){
    //         start = (mid+1)%nums.length;
    //         mid = (start+end)%nums.length;
    //         prev = (mid-1+nums.length)%nums.length;
    //     }
    //     start = mid;
    //     end = prev;
    //     System.out.printf("start- %d end - %d", start, end);
    //    if(start == end){
    //        return nums[start] == target ? start: -1;
    //    }
    //    int res = -1;
    //    //We have got 2 halve sorted arrays
    //    if(end>start){
    //        res = binarySearch(nums, target, start,end); //Sorted nums
    //    }else{
    //        //Inclusive indices
    //        res = binarySearch(nums, target, start, nums.length-1);
    //        if(res !=-1){
    //            return res;
    //        }
    //        res = binarySearch(nums, target, 0, end);
    //        if(res !=-1){
    //            return res;
    //        }
    //    }
       
    //     return res;
    // }

    // private static int binarySearch(int[] nums, int target, int start, int end){
    //     int mid = 0;

    //     while(start<=end){
    //         mid = (start+end)/2;
    //         if(nums[mid] == target){
    //             return mid;
    //         }else if(nums[mid]<target){
    //             start = mid+1;
    //         }else{
    //             end = mid-1;
    //         }
    //     }

    //     return -1;
    // }


    // ----------- REVISION -------------

    /**
    nums[mid] == target return mid
    nums[mid] < target || (nums[mid] > target && nums[start] > target) (on the right side of mid)
    nums[mid] > target && nums[start] < target (on the left side of mid)

     */
    public int search(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        if(nums.length == 0){
            return -1;
        }

        while(start<=end){
            int mid = start + (end-start)/2;
            System.out.println(mid);
            if(nums[mid] == target) return mid;
            
            // Left sorted?
            else if(nums[start] <= nums[mid]){
                //Will target lies in left side of middle
                if((nums[start] <= target && nums[mid]>target)){
                    end = mid - 1;
                }else{ //or right side
                    start = mid + 1;
                }
            }else{ 
                // check if target is in the right side of mid
                if((nums[mid] < target && nums[end]>=target)){
                    start = mid + 1;
                }else{ // its going to be on left side
                    end = mid - 1;
                }
            }
            
        }

        return -1;
    }
}