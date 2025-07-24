/**
input is s -> String
return the number of palindromic substrings of s

Example:
input: s = "abc"
output: 3

input: s = "bbb"
output: 6

b, b, b, bb, bb, bbb
 */
class Solution {
    public int countSubstrings(String s) {
        //initialize count of palindrome
        int count = 0;

        int n = s.length();

        for(int i =0; i<n; i++) {
            count += expandFromCenter(s, i, i); //odd - length
            count += expandFromCenter(s, i, i+1); // Even - length
        }

        return count;
    }

    private int expandFromCenter(String s, int left, int right) {
        int matches = 0;

        while(left>=0 && right<s.length()
             && s.charAt(left) == s.charAt(right)) {
            matches++;
            left--;
            right++;
        }

        return matches;
    }
}