class Solution {
    // Last index temperature answer is going to be 0 always,

    /**
    Thinking of using stack from right to left along with index,

    [73,74,75,71,69,72,76,73]

    Stack with last element,
    [73,74,75,71,69,72,76,73]
                          ^
    stack  [(73, 7)]
    answer [0]

    [73,74,75,71,69,72,76,73]
                        ^
    stack  [(73, 7)]
    answer [0]  76>73

    pop
    stack  []
    answer [0, 0] //Stack is empty so no element found add 0 to answer

    push curr
    stack [(76, 6)]
    ans [0, 0]

    [73,74,75,71,69,72,76,73]
                    ^
    72>76 (false)
    stack [(72, 5),(76, 6)]
    answer [1(stack.peek(),index - i), 0, 0]

    [73,74,75,71,69,72,76,73]
                 ^
    stack [(69, 4), (72, 5),(76, 6)]
    answer [1, 1, 0, 0]

    [73,74,75,71,69,72,76,73]
              ^
    stack [(71, 3), (72, 5),(76, 6)]
    answer [2, 1, 1, 0, 0]

    
    [73,74,75,71,69,72,76,73]
            ^
    stack [(76, 6)]
    answer [4, 2, 1, 1, 0, 0]

    [73,74,75,71,69,72,76,73]
         ^
    stack [(74, 2),(76, 6)]
    answer [4, 2, 1, 1, 0, 0]

    So I have to pop and push it back to the stack at the end,
    But complexity will go O(n^2)

    Monotonic stack would do the job,

    Keep a decreasing stack starting from the last index,
     */
    class TempWithIndex{
        int temp;
        int index;
        public TempWithIndex(int temp, int index){
            this.temp = temp;
            this.index = index;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        if(n<=1) return answer;

        // answer[n-1] = 0; //We know that
        Stack<TempWithIndex> stack = new Stack<>();

        for(int i=n-1; i>=0; i--){
            
            //remove all the smaller temperature from stack
            while(!stack.isEmpty() && stack.peek().temp<=temperatures[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                answer[i] = 0;
            }else{
                answer[i] = stack.peek().index - i;
            }
            stack.push(new TempWithIndex(temperatures[i], i));
        }
        return answer;
    }
}