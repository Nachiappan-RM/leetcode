class Solution {
    // List<String> res = new ArrayList<>();
    // public List<String> generateParenthesis(int n) {
    //     backtrack("", n, 0, 0);
    //     return res;
    // }

    // private void backtrack(String parentheses, int n,  int open, int close){
    //     if(open == n && close == n){
    //         res.add(parentheses);
    //         return;
    //     }

    //     if(open<n){
    //         backtrack(parentheses+"(", n, open+1, close);
    //     }

    //     if(open>close){
    //         backtrack(parentheses+")", n, open, close+1);
    //     }
    // }

    //--------REVISION------------
    /**
    Brute force would be trying every possible,
    By keeping a hashset and trying to keep generating all possible strings of length 2*n
    Keeping only valid combinations in set,

    Would take exponential time.

    So Backtracking would work better - Not reconstructing the whole thing - 
    We can just switch the orders.

    For validity we need to use stack.
    We can have 2 stacks one for ( with index and other for ) with index

    OR we can use recursion
    Every possible position it can be '(' or ')'

    but '(' is possible only if open<close
    and base would be open==close==n
    '(' is only possible if open < n
     */
    public List<String> generateParenthesis(int n){
        List<String> possiblePairs = new ArrayList<String>();
        generate(new StringBuilder(), 0, 0, n, possiblePairs);
        return possiblePairs;
    }

    private void generate(StringBuilder curr, int open, int close, int n, List<String> possiblePairs){
        if(n == open && n == close){
            possiblePairs.add(curr.toString());
            return;
        }

        if(open<n){
            generate((new StringBuilder(curr)).append("("), open+1, close, n, possiblePairs);
        }

        if(close<open){
            generate((new StringBuilder(curr)).append(")"), open, close+1, n, possiblePairs);
        }
    }
}