// class Solution {
//     public int lastStoneWeight(int[] stones) {
//         PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

//         for(int stone:stones){
//             maxHeap.add(stone);
//         }

//         while(maxHeap.size()>1){
//             int x = maxHeap.poll();
//             int y = maxHeap.poll();
//             if(x == y) continue;
//             if(x>y) maxHeap.add(x-y);
//             else maxHeap.add(y-x);
//         }
//         return maxHeap.isEmpty()?0:maxHeap.poll();
//     }
// }

// -------- REVISION -----------
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> stonesMaxHeap = new PriorityQueue<>((a,b)->Integer.compare(b,a));

        for(int stone: stones) {
            stonesMaxHeap.offer(stone);
        }

        while(stonesMaxHeap.size()!=1){
            int x = stonesMaxHeap.poll();
            int y = stonesMaxHeap.poll();
            if(x>y){
                stonesMaxHeap.offer(x-y);
            }else{
                stonesMaxHeap.offer(y-x);
            }
        }

        return stonesMaxHeap.peek();
    }
}