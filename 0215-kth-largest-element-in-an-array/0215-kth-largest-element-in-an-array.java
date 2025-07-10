// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         //Maintaining only k elements in min heap.
//         PriorityQueue<Integer> heap = new PriorityQueue<>(); // minHeap
//         for(int num : nums){
//             if(heap.size()<k){
//                 heap.add(num);
//             }else if(heap.peek()<num){
//                 heap.poll();
//                 heap.add(num);
//             }
//         }
//         return heap.peek();
//     }
// }


// -------- REVISION ------------
/**
TC - O(n*log k)
SC - k
 */
class Solution {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;

        if(len<k) return -1; //Impossible to happen

        for(int n: nums) {
            if(minHeap.size() < k) {
                minHeap.offer(n);
            } else if(minHeap.size() == k && minHeap.peek() < n) {
                minHeap.poll();
                minHeap.offer(n);
            }
        }

        return minHeap.peek();
    }
}