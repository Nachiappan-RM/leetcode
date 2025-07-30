/**
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string

Example:
input: s = "abcc" p = "abc*"
output : true
*/

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        //dp[i][j] = does s[i...m-1] match p[j...n-1] ?
        boolean[][] dp = new boolean[m+1][n+1];

        //Base case : empty string vs empty string
        dp[m][n] = true;

        // Handle patterns like "a*", "a*b",..
        for(int j = n-2; j>=0; j--) {
            if(p.charAt(j+1) == '*') {
                dp[m][j] = dp[m][j+2];
            }
        }

        // Fill Dp - Tab bottom-up
        for(int i=m; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                //check if current characters match
                boolean firstMatch = (i<m) && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
                //If theres '*' in the next pattern
                if(j+1 < n && p.charAt(j+1) == '*') {
                    // 1) skip "x" OR 2) use one match and stay on this pattern
                    dp[i][j] = dp[i][j+2] || (firstMatch && dp[i+1][j]);
                } else {
                    dp[i][j] = firstMatch && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}




















