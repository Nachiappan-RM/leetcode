class Solution {
    /**
    - Water can only trap if we have 3 or more heights

    - Need to find the left and right peaks and get the water inbetween them

    [0,1,0,2,1,0,1,3,2,1,2,1]
     ^
    
     */
    public int trap(int[] height) {
        int n = height.length;
        if(n<3) return 0;

        int trapped = 0;
        // Logic min(mLeft, right) - height[i] -> trapped    
        
        int l = 0 , r= n-1;
        int maxLeft = height[0], maxRight = height[n-1];

        while(l<=r){
            int currentTrapped = 0;
            if(maxLeft < maxRight){
                currentTrapped = maxLeft- height[l];
                maxLeft = Math.max(maxLeft, height[l]);
                l++;
            }else{
                currentTrapped = maxRight - height[r];
                maxRight = Math.max(maxRight, height[r]);
                r--;
            }
            if(currentTrapped>0){
                trapped += currentTrapped;
            }
        }
        return trapped;
    }
}