public class Solution {
    // you need to treat n as an unsigned value
    // public int hammingWeight(int n) {
    //     if(n==0) return 0;
    //     if(n==1) return 1;
        
    //     return hammingWeight(n/2)+n%2;
    // }

    public int hammingWeight(int n) {
        int count = 0;

        for(int i=0; i<32; i++) {
            if(((n>>i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}