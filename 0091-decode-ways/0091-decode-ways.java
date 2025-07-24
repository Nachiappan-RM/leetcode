class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();

        // dp[i] = number of ways to decode substring s[i..n-1]

        int[] dp = new int[n+1];

        //Base case: one way to decode an empty suffix
        dp[n] = 1;

        //Fill dp from right to left
        for(int i =n - 1; i >=0; i--) {
            //If current char is '0' no valid decoding starts here
            if(s.charAt(i) == '0') {
                dp[i] = 0;
            }else {
                //Take one digit
                dp[i] = dp[i+1];
                //check if two digit number is valid
                if(i+1 < n) {
                    int twoDigit = (s.charAt(i) - '0') * 10 + (s.charAt(i+1) - '0');
                    if(twoDigit >= 10 && twoDigit <= 26) {
                        dp[i] += dp[i+2];
                    }
                }
            }
        }

        return dp[0];
    }
}