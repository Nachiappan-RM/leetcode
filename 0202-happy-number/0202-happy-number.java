/*
class Solution {
    public boolean isHappy(int n) {
        //Bring it down to one digit number
        //If its not 1 false else true
        int[] squares = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81};
        HashSet<Integer> seen = new HashSet<>();
        while(n!=1 && !seen.contains(n)){
            seen.add(n);
            int ans = 0;
            while(n>0){
                int d = n%10;
                ans += squares[d];
                n = n/10;
            }
            n = ans;
        }

        return n==1;
    }
}
*/

/**
Set to maintain the numbers we've seen so far to find out the endless loop

 */
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> results = new HashSet<>();

        while( n != 1) {
            n = computeSquareSum(n);
            if(results.contains(n)) {
                return false;
            }
            results.add(n);
        }
        return true;
    }

    private int computeSquareSum(int n) {
        int sum = 0;
        while(n!=0) {
            sum += (n%10) * (n%10);
            n = n/10;
        }
        return sum;
    }
}