class Solution {
    // public boolean searchMatrix(int[][] matrix, int target) {
    //    /*
    //    Key notes:
    //     - Every row sorted - (Binary search)
    //     - Last column is increasing order(Sorted) - (Binary search)

    //     TC- O(n)
    //    */ 
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //     // for(int i=0; i< n; i++){
    //     //     if(matrix[i][m-1] >= target){
    //     //         return binarySearch(matrix[i], target, 0, m-1);
    //     //     }
    //     // }

    //     int start = 0;
    //     int end = n-1;

    //     while(start<=end){
    //         int mid = (start+end)/2;
    //         if(matrix[mid][m-1] >= target && matrix[mid][0] <= target){
    //             return binarySearch(matrix[mid], target, 0, m-1);
    //         }else if(matrix[mid][m-1] < target){
    //             start = mid+1;
    //         }else{
    //             end = mid-1;
    //         }
    //     }

    //     return false;
    // }

    // private static boolean binarySearch(int[] nums, int target, int start, int end){
    //     int mid = 0;

    //     while(start<=end){
    //         mid = (start+end)/2;
    //         if(nums[mid] == target){
    //             return true;
    //         }else if(nums[mid]<target){
    //             start = mid+1;
    //         }else{
    //             end = mid-1;
    //         }
    //     }

    //     return false;
    // }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;

        if(n == 0) return false;

        //Edge purning
        if(matrix[m-1][n-1]<target || matrix[0][0] > target) return false;

        //Column wise Binary search would take log(n) and row wise binary search log m
        // Overall log(m*n)

        int start = 0, end = m-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(matrix[mid][0] == target) return true;
            else if(matrix[mid][0] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        int s = 0, e = n-1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(matrix[start-1][mid] == target) return true;
            else if(matrix[start-1][mid] < target){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return false;
    }
}