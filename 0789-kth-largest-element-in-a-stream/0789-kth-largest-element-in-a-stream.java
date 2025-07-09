/**
class KthLargest {
    // int k;
    // List<Integer> stream;
    // public KthLargest(int k, int[] nums) {
    //     this.k = k;
    //     stream = new ArrayList<>();
    //     for(int i: nums){
    //         stream.add(i);
    //     }
    // }
    
    // public int add(int val) {
    //     stream.add(val);
    //     Collections.sort(stream);
    //     return stream.get(stream.size()-k);
    // }
    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}

*/
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */


class KthLargest {
    
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        for(int n: nums){
            if(minHeap.size()<k){
                minHeap.offer(n);
            }else if(minHeap.size() == k && minHeap.peek()<n) {
                minHeap.offer(n);
                minHeap.poll();
            }
        }
        this.k = k;
    }

    public int add(int val) {
        if(minHeap.size()<k){
            minHeap.offer(val);
        }else if(minHeap.size() == k && minHeap.peek()<val) {
            minHeap.offer(val);
            minHeap.poll();
        }

        // if(minHeap.size()<k) {
        //     // Throw error
        // }
        return minHeap.peek();
    }
}
