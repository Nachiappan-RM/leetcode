class Solution {
    public int largestRectangleArea(int[] heights) {

        /*
        Brute force - Time Limit Exceeded Testcases-93/98 Passed

        TC - O(n^2)
        SC - O(1)
        */
        /*
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<heights.length; i++){
            int count = 1;
            for(int j=i+1; j<heights.length; j++){
                if(heights[j]<heights[i]){
                    break;
                }
                count++;
            }
            for(int k=i-1; k>=0; k--){
                if(heights[k]<heights[i]){
                    break;
                }
                count++;
            }
            largest = Math.max(largest, heights[i]*count);
        }

        return largest;
        */

        /*

        Monotonic stack, Increasing order

        - When I encounter a smallest number<Peek I will pop the elements in the stack
        Initial stack
        leftValues = [] -> copy of height;
        Loop - i ->0 to n-1
            - while(!stack.isEmpty() && heights[i]<stack.peek())
                stack.pop()
                cnt++
                leftValues[i] += height[i]
            - stack.push(heights[i])
        */

        // ---------- Optimized Approach ------------
        Stack<int[]> stack = new Stack<>();
        int n = heights.length;
        int maxArea = 0;
        for(int i=0 ;i <n; i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] indexWithHeight = stack.pop();
                int index = indexWithHeight[0];
                int height = indexWithHeight[1];
                start = index; //Left side extension
                maxArea = Math.max(maxArea, height*(i - index));
            }
            stack.push(new int[]{start, heights[i]});
        }

        while(!stack.isEmpty()){
            int[] indexWithHeight = stack.pop();
            int index = indexWithHeight[0];
            int height = indexWithHeight[1];
            maxArea = Math.max(maxArea, height*(n - index));
        }

        return maxArea;
    }
}

/**


Given an array of integers heights representing the histogram's bar height 
where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.


*/