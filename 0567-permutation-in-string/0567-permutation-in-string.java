class Solution {
    /**
    Thinking of a sliding window in s2 with the window size of s1 length
    and check the frequency match with s1
     */
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n>m) return false;

        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for(int i=0; i<n; i++){
            f1[s1.charAt(i)-'a']++;
            f2[s2.charAt(i)-'a']++;
        }

        if(isSame(f1,f2)) return true;
        int r = n;
        while(r<m){
            f2[s2.charAt(r-n)-'a']--;
            f2[s2.charAt(r)-'a']++;
            if(isSame(f1,f2)) return true;
            r++;
        }
        return false;
    }

    private boolean isSame(int[] f1, int[] f2){
        for(int i=0; i<26; i++){
            if(f1[i] != f2[i]) return false;
        }
        return true;
    }
}