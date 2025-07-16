/*
class Solution {
    public int climbStairs(int n) {
        // if(n<=2){
        //     return n;
        // }
        // int[] arr = new int[n];
        // arr[0] = 1;
        // arr[1] = 2;
        // for(int i=2;i<n;i++){
        //     arr[i] = arr[i-1] + arr[i-2];
        // }
        // return arr[n-1];
       
            if(n<2){
                return 1;
            }
            return climbStairs(n-1)+ climbStairs(n-2);
        
    }
}
*/


// --------- REVISION ----------
class Solution {
    public int climbStairs(int n) {
        // if(n<=2) {
        //     return n;
        // }
        // return climbStairs(n-1) + climbStairs(n-2);
        if(n<=2) {
            return n;
        }
        int steps[] = new int[n+1];
        steps[1] = 1;
        steps[2] = 2;
        return stairs(n, steps);
    }

    private int stairs(int n, int[] steps) {
        if(steps[n] != 0){
            return steps[n];
        }
        steps[n] = stairs(n-1, steps) + stairs(n-2, steps);
        return steps[n]; 
    }
}