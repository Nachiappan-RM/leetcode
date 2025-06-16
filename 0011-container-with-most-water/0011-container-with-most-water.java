class Solution {
    // public int maxArea(int[] height) {

    //     int left = 0;
    //     int right = height.length-1;

    //     int max =0;

    //     while(left<right){
    //         max = Math.max(max, (right-left)*Math.min(height[left], height[right]));

    //         if(height[left] < height[right]){
    //             left++;
    //         }else{
    //             right--;
    //         }
    //     }
    //     return max;
    //     // int max = 0;

    //     // for(int i=0; i<height.length-1;i++){
    //     //     for(int j=i+1;j< height.length; j++){
    //     //         int curr = (j-i)*Math.min(height[i], height[j]);
    //     //         if(max<curr){
    //     //             max = curr;
    //     //         }
    //     //     }
    //     // }

    //     // return max;
    // }

    // public int maxArea(int[] height) {
    //     int l = 0;
    //     int r = height.length-1;
    //     int max = 0;
    //     while(l<r){
    //         max = Math.max(max, Math.min(height[l], height[r])*(r-l));
    //         if(height[l]>height[r]) r--;
    //         else l++;
    //     }
    //     return max;
    // }

    //------REVISION----------
    public int maxArea(int[] height) {
        int n = height.length;
        int i=0, j= n-1;
        int maxArea = 0;
        while(i<j){
            maxArea = Math.max(Math.min(height[i], height[j]) * (j-i), maxArea);
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxArea;
    }
}