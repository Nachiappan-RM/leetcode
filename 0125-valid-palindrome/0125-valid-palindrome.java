class Solution {
    // public boolean isPalindrome(String s) {
    //     String reverseString = "";

    //     for(int i=s.length()-1; i>=0; i--){
    //         if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
    //             reverseString += Character.toLowerCase(s.charAt(i));
    //         }
    //     }
    //     int len = reverseString.length();
    //     for(int i=0; i<len/2; i++){
    //         if(reverseString.charAt(i) != reverseString.charAt(len-i-1)){
    //             return false;
    //         }
    //     }

    //     return true;
    // }

    // --------REVISION-------
    public boolean isPalindrome(String s) {
        int n = s.length();
        if (n == 0)
            return true;
        int i = 0, j = n - 1;

        while (i < j) {
            while ((i < j) && !(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                    && !(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                    && !(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                i++;
            }

            while ((i < j) && !(s.charAt(j) >= 'A' && s.charAt(j) <= 'Z')
                    && !(s.charAt(j) >= 'a' && s.charAt(j) <= 'z')
                    && !(s.charAt(j) >= '0' && s.charAt(j) <= '9')) {
                j--;
            }

            if (i < j) {
                char c1 = s.charAt(i);
                char c2 = s.charAt(j);
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                    c1 = (char) (s.charAt(i) - 'A' + 'a'); //converting to lowercase
                }
                if (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') {
                    c2 = (char) (s.charAt(j) - 'A' + 'a'); //converting to lowercase
                }

                if (c1 != c2) {
                    return false;
                }
                i++;
                j--;
            }

        }

        return true;
    }
}