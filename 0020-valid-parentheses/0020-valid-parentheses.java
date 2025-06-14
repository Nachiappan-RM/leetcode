class Solution {
    // public boolean isValid(String s) {
    //     Stack<Character> paranthesis = new Stack<>();
    //     if(s.length()%2!=0){
    //         return false;
    //     }
    //     for(char c: s.toCharArray()){
    //         if( c == '(' || c=='{' || c== '['){
    //             paranthesis.push(c);
    //         }
    //         else if(c == ')'){
    //             if(!paranthesis.isEmpty()){
    //                 char p = paranthesis.pop();
    //                 if(p != '('){
    //                     return false;
    //                 }
    //             }else{
    //                 return false;
    //             }

    //         }else if(c == '}'){
    //             if(!paranthesis.isEmpty()){
    //                 char p = paranthesis.pop();
    //                 if(p != '{'){
    //                     return false;
    //                 }
    //             }else{
    //                 return false;
    //             }
    //         }else if(c == ']'){
    //             if(!paranthesis.isEmpty()){
    //                 char p = paranthesis.pop();
    //                 if(p != '['){
    //                     return false;
    //                 }
    //             }else{
    //                 return false;
    //             }
    //         }
    //     }
    //     return paranthesis.isEmpty();
    // }

    // --------REVISION----------
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() % 2 != 0)
            return false; //Early Purning

        for (char c : s.toCharArray()) {
            if(c == '(' || c=='[' || c=='{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;
                char open = stack.pop();
                if((open != '(' && c == ')')
                    || (open != '[' && c == ']')
                    || (open != '{' && c == '}')
                ){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}