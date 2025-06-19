class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /**
        We are searching for a proper k,
        Min k can be 1 or atmost max value in piles
         */
        int n = piles.length;
        // Constraint n>=1
        int max = 1;

        for (int val: piles) {
            if (max<val) {
                max = val;
            }
        }
        int start = 1;
        int end = max;
        while(start<=end){
            int mid = start + (end-start)/2;
            // Compute the total hours need for koko to eat banana's
            long totalHours = 0;
            for(int i=0; i<n; i++) {
                totalHours += (int)Math.ceil((double)piles[i]/(double)mid);
            }

            if(totalHours<=(long)h){ //There is possible totalHours check for smaller
                end = mid-1;
            }else{ // No way possible with current try with more banana's per hr
                start = mid+1;
            }
        }
        return start;
    }
}