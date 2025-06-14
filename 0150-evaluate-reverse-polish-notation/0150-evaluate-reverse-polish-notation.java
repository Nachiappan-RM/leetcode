class Solution {
    /**
    Initial thought process,
    Getting it in a reverse polish order - Stimulates like a stack operation,
    - Push all numbers into the stack,
    - The moment when we encounter a operator -> Pop last two number from stack
    - Compute the result push it back to the stack
    
     */
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for(String token: tokens){
            if(token.equals("+") || token.equals("*") || token.equals("-")|| token.equals("/")){
                int op1 = Integer.parseInt(stack.pop());
                int op2 = Integer.parseInt(stack.pop());
                int result = 0;
                if(token.equals("+")){
                    result = op1 + op2;
                }else if(token.equals("-")){
                    result = op2 - op1;
                }else if(token.equals("*")){
                    result = op1 * op2;
                }else if(token.equals("/")){
                    result = op2 / op1;
                }
                stack.push(String.valueOf(result));
            }else{
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}