class Solution {
    // public boolean isAnagram(String s, String t) {
    //     int n = s.length();
    //     int m = t.length();

    //     if(m != n){
    //         return false;
    //     }
    //     int[] alpha = new int[26];

    //     for(int i=0; i<n; i++){
    //         alpha[s.charAt(i)-'a']++;
    //         alpha[t.charAt(i)-'a']--;
    //     }

    //     for(int i=0; i<26; i++){
    //         if(alpha[i]!=0){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    public boolean isAnagram(String s, String t){
        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        for(char c: t.toCharArray()){
            freq[c-'a']--;
            if(freq[c-'a']<0) return false; //early purning
        }
        for(int i=0; i<26; i++){
            if(freq[i]!=0) return false;
        }
        return true;
    }
}