/**
Find the longest palindromic substring

examples:
input -"babad"
output - "bab" or "aba"

input - "cbbd"
output - "bb"
 */

class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";

        int start = 0; // Start index of the longest palindrome found
        int end = 0; // End index of the longest palindrome found

        // Loop through each character in the string
        for(int i = 0; i< s.length(); i++) {
            //Check for odd-length palindrome (centered at i)
            int len1 = expandAroundCenter(s, i, i);
            //Check for even length palindrom (center at i and i+1)
            int len2 = expandAroundCenter(s, i, i+1);

            int len = Math.max(len1, len2);

            //If this palindrom is longer than the previous longest, update start and end
            if(len > end - start + 1) {
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start, end+1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        //Expanding as long as the character at left and right are equal
        while(left>=0 && right < s.length() 
        && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right-left-1;
    }
}






















