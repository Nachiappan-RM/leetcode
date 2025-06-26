class Solution {
    // public int lengthOfLongestSubstring(String s) {
    //     if(s == null || s.length() == 0){
    //         return 0;
    //     }

    //     int l=0;
    //     String subString = "";
        
    //     for(char c: s.toCharArray()){
    //         l = subString.length()>l ? subString.length() : l;
    //         if(subString.indexOf(c)!=-1){
    //             subString = subString.substring(subString.indexOf(c)+1);
    //         }
    //         subString +=c;
    //     }
    //     return subString.length()>l ? subString.length() : l;
        
    // }

    // --------- REVISION ----------
    public int lengthOfLongestSubstring(String s){
        /**
        Thinking of 2 points that can be track of only unique character
        ie Like a sliding window

        The moment I encounter the repeated character we can strink the 
        window till next character of that repeated character
         */
        int l = 0, r = 0;

        int n = s.length();
        int longestUniqueSubstring = 0;
        HashSet<Character> uniqueCharacter = new HashSet<>();
        if ( n < 1 ) {
            return longestUniqueSubstring;
        }

        while(r<n){
            if(uniqueCharacter.contains(s.charAt(r))){
                while(l<r && s.charAt(l) != s.charAt(r)){
                    uniqueCharacter.remove(s.charAt(l));
                    l++;
                }
                // uniqueCharacter.remove(s.charAt(l));
                l++; //Moving the window to the next unique character
            }
            longestUniqueSubstring = Math.max(longestUniqueSubstring, r-l+1);
            uniqueCharacter.add(s.charAt(r));
            r++;
        }

        return longestUniqueSubstring;
    }
}