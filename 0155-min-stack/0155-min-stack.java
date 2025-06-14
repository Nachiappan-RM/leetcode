// class MinStack {
//     /*
//     What are the potential datatype that we are discussing - int
//     No need to handle underflow overflow - Given

//     Handle when there pop the min element
//     */

//     private Stack<Node> minStack;
//     private int min = Integer.MAX_VALUE;


//     class Node{
//         Node(int val, int min){
//             this.data = val;
//             this.min = min;
//         }
//         private int data;
//         private int min;
//     }
//     public MinStack() {
//         this.minStack = new Stack<>();
//     }
    
//     public void push(int val) {
//         if(val<this.min){
//             this.min = val;
//         }
//         this.minStack.push(new Node(val, min));
//     }
    
//     public void pop() {
//        this.minStack.pop();
//        if(!minStack.isEmpty()){
//             this.min = this.minStack.peek().min;
//        }else{
//            this.min = Integer.MAX_VALUE;
//        }
//     }
    
//     public int top() {
//         return this.minStack.peek().data;
//     }
    
//     public int getMin() {
//         return this.minStack.peek().min;
//     }
// }


//-------REVISION--------
/**
This stack has to be returning the minimum number in constant time

Idea - To retrieve the min element in the stack - Thinking of having a priority queue with all stack element

     stack  minHeap
push  O(1)   O(log n)
pop   O(1)   X O(n)lookup and delete  (Not feasible)

Stack is the only datastructure that could do all these in O(1)

We can have a node each has a local minimum
2,3,4,5,1,2,3
2 2 2 2 1 1 1



 */
class MinStack{

    class MinNode{
        int min;
        int value;
        MinNode(int value, int min){
            this.value = value;
            this.min = min;
        }
    }
    Stack<MinNode> stack;
    //Initializes the stack object
    MinStack(){
        this.stack = new Stack<>();
    }

    //Pushes the val to stack
    void push(int val){
        int min = val;
        if(!stack.isEmpty()){
            min = Math.min(min, stack.peek().min);
        }
        stack.push(new MinNode(val, min));
    }

    //pop the element val onto the stack
    void pop(){
        stack.pop();
    }

    //gets the top element of the stack
    int top(){
        return stack.peek().value;
    }

    //get the minimum element in the stack
    int getMin(){
        return stack.peek().min;
    }
}



/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */