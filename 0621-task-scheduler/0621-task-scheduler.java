// class Solution {
//     class Node{
//         char ch;
//         int count;
//         public Node(char ch, int count){
//             this.ch = ch;
//             this.count = count;
//         }
//     }
//     class WaitingNode{
//         Node node;
//         int time;
//         public WaitingNode(Node node, int time){
//             this.node = node;
//             this.time = time;
//         }
//     }
//     public int leastInterval(char[] tasks, int n) {
//         int[] count = new int[26];       
//         for(int task: tasks){
//             count[task-'A']++;
//         }

//         //To find minimum number we have to take the max freq task everytime.
//         PriorityQueue<Node> maxHeap = new PriorityQueue<>(new Comparator<Node>(){
//             @Override
//             public int compare(Node n1, Node n2){
//                 return Integer.compare(n2.count, n1.count);
//             }
//         });

//         for(int i=0; i<26; i++){
//             if(count[i]!=0) maxHeap.offer(new Node(((char)(i+'A')), count[i]));
//         }
        
//         Queue<WaitingNode> waitingQueue = new LinkedList<>();
//         int time = 0;
//         while(!maxHeap.isEmpty() || !waitingQueue.isEmpty()){
//             time +=1;
//             if(!maxHeap.isEmpty()){
//                 Node t = maxHeap.poll();
//                 t.count = t.count-1;
//                 if(t.count>0){
//                     waitingQueue.offer(new WaitingNode(t, time+n));
//                 }
//             }

//             if(!waitingQueue.isEmpty() && waitingQueue.peek().time==time){
//                 WaitingNode w = waitingQueue.poll();
//                 maxHeap.offer(w.node);
//             }
//         }    
//         return time; 
//     }
// }


// --------- REVISION -------------
/**
Priority Queue + Queue
*/
class Solution {
    class Pair {
        int count;
        int waitingTime;
        public Pair(int c, int n) {
            this.count = c;
            this.waitingTime = n;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        // Get freq count
        Map<Character, Integer> characterCount = new HashMap<>();
        for(char c: tasks) {
            characterCount.put(c, characterCount.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        
        for(int count: characterCount.values()) {
            maxHeap.offer(count);
        }

        Queue<Pair> queue = new LinkedList<>();
        int time = 0;
        while(!queue.isEmpty() || !maxHeap.isEmpty()) {
            time++;

            if(!maxHeap.isEmpty()) {
                int c = maxHeap.poll();
                c--;
                if(c>0){
                    queue.offer(new Pair(c, time+n));
                }
            }

            if(!queue.isEmpty() && queue.peek().waitingTime <= time){
                maxHeap.offer(queue.poll().count);
            }
        }

        return time;
    }
}