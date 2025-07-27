/*
class Solution {
    public int[] countBits(int n) {
        int ans[] = new int[n+1];

        if(n>0){
            ans[1] = 1;
            for(int i=2; i<n+1; i++){
                ans[i] = ans[i/2]+i%2;
            }
        }

        return ans;
    }
}
*/


class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int i=0; i<=n; i++) {
            result[i] = countSetBits(i);
        }
        return result;
    }

    private int countSetBits(int n) {
        int count = 0;
        for(int i=0; i<32;i++) {
            if(((n>>i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}