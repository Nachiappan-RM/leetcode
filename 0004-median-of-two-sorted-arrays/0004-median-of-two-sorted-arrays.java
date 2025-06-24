class Solution {
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     /*
    //     Merge 2 arrays,

    //     if len is even
    //         get mid and mid+1 element and return the median
    //     else:  
    //         return mid value
    //     */
    //     int n = nums1.length;
    //     int m = nums2.length;
    //     if(n == 0 && m!=0){
    //         if(m%2!=0){ //odd
    //             return (double) nums2[m/2];
    //             // return res;
    //         }else{
    //             return (double) (nums2[m/2]+nums2[m/2-1])/2;
    //             // return res;
    //         }
    //     }else if(m == 0 & n!=0){
    //         if(n%2!=0){ //odd
    //             return (double) nums1[n/2];
    //             // return res;
    //         }else{
    //             return (double) (nums1[n/2]+nums1[n/2-1])/2;
    //             // return res;
    //         }
    //     }else{
    //         int[] merged = new int[m+n];

    //         int l=0, r=0, i=0;

    //         while(l<n && r<m){
    //             if(nums1[l]<=nums2[r]){
    //                 merged[i++] = nums1[l++];
    //             }else{
    //                 merged[i++] = nums2[r++];
    //             }
    //         }

    //         while(l<n){
    //             merged[i++] = nums1[l++];
    //         }

    //         while(r<m){
    //             merged[i++] = nums2[r++];
    //         }

    //         System.out.println(Arrays.toString(merged));
    //         if(merged.length%2!=0){ //if odd return median
    //             return (double) merged[merged.length/2];
    //             // return res;
    //         }else{
    //             return (double) (merged[merged.length/2]+merged[merged.length/2-1])/2;
    //             // return res;
    //         }
    //     }
    // }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if (m < n) { //Making sure 2nd array is smaller
            return findMedianSortedArrays(nums2, nums1);
        }

        if (m == 0) {
            // nums2 is empty, so directly return the median of nums1
            if (n % 2 == 1)
                return nums1[n / 2];
            return (nums1[n / 2 - 1] + nums1[n / 2]) / 2.0;
        }

        if (n == 0) {
            if (m % 2 == 1)
                return nums2[m / 2];
            return (nums2[m / 2 - 1] + nums2[m / 2]) / 2.0;
        }

        /**
        Brute Force -> Merge 2 arrays 
        -> If m+n is even return ([value[mid]+ value[mid+1])/2
        -> If m+n is odd return mid value
        
        TC -> O(n+m) | SP -> O(n+m)
        
        Better Approach -> Instead of creating merge array use point for the final array and compute the index till mid
        TC -> O(n+m) | SP -> O(1)
        
        Optimal Approach,
        Binary search since its already sorted
        TC -> O(log(n+m)) | SP -> O(1)
         */

        int l = n + m;
        int firstHalfLen = (l + 1) / 2; //length of left half

        int start = 0, end = n;
        while (start <= end) {
            int mid1 = start + (end - start) / 2;
            int mid2 = firstHalfLen - mid1; //Remaining elements in left half

            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < m) ? nums2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (l % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2)
                end = mid1 - 1;
            else
                start = mid1 + 1;
        }
        return 0; //Not reachable
    }
}