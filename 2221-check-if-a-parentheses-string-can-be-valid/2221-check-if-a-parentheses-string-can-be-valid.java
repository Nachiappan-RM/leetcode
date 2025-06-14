class Solution {
    /**
    Odd length -> invalid -> return false <- Edge Purning
    
    Any paranthesis at index i,
    - where locked[i] == 0,
        - Stays the same
        - Can be changed to another one
    
    thinking of having a stack,
    
    Push all the ( to stack,
    
    
    
     */
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0)
            return false;
        // return isValid(0, 0, 0, n, s, locked); -> TC - O(2^n) with SC - O(n)

        //Greedy Approach - Only care about locked char
        int flexible = 0;
        //Left to right having more '(' be advantage
        for(int i=0;i<n; i++){
            if(locked.charAt(i) == '1'){
                flexible += (s.charAt(i) == '(') ? 1 : -1;
            }else{
                flexible += 1; //Assuming its '(' -> Base case
            }
            if(flexible<0) return false;
        }

        flexible = 0; // reset to see balanced )
        //Left to right having more '(' be advantage
        for(int i=n-1;i>=0; i--){
            if(locked.charAt(i) == '1'){
                flexible += (s.charAt(i) == ')') ? 1 : -1;
            }else{
                flexible += 1; //Assuming its ')' -> Base case
            }
            if(flexible<0) return false;
        }

        return true;
    }

    private boolean isValid(int i, int open, int close, int n, String s, String locked) {
        if(close>open) return false;
        if (i == n) { //Base case
            return open == close;
        }

        if (locked.charAt(i) == '1') {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            // if(close>open) return false;
            return isValid(i + 1, open, close, n, s, locked);
        }

        // Otherwise
        return isValid(i + 1, open + 1, close, n, s, locked) || isValid(i + 1, open, close + 1, n, s, locked);

    }
}