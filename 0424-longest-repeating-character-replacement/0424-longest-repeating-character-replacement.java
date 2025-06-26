class Solution {
    /**
    Thinking of a sliding window that allows k non repeating characters.
     */
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if(n<=1) return n;

        int l = 0, r = 0;
        int longest = 0;
        int[] freq = new int[26];
        while(r<n){
            freq[s.charAt(r)-'A']++;

            int replacement = (r-l+1) - freq[getMaxFreq(freq)];
            if(replacement<=k){
                longest = Math.max(longest, r-l+1);
                r++;
            }else{
                freq[s.charAt(l)-'A']--;
                l++;
                r++;
            }
        }
        return longest; 
    }

    private int getMaxFreq(int[] freq){
        int i = 0, max=0;
        while(i<freq.length){
            if(freq[i]>freq[max]){
                max = i;
            }
            i++;
        }
        return max;
    }
}