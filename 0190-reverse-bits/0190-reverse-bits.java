class Solution {
    public int reverseBits(int n) {
        int t = n;
        int result = 0;
        for(int i=0; i<32; i++) {
            result = result<<1;
            result = result | (t & 1);
            t = t>>1;
        }
        return result;
    }
}