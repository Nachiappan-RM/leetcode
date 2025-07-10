class MedianFinder {
    PriorityQueue<Integer> firstHalfMaxHeap;
    PriorityQueue<Integer> secondHalfMinHeap;

    public MedianFinder() {
        firstHalfMaxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b, a));
        secondHalfMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        firstHalfMaxHeap.offer(num);
        secondHalfMinHeap.offer(firstHalfMaxHeap.poll());

        if (firstHalfMaxHeap.size() < secondHalfMinHeap.size()) {
            firstHalfMaxHeap.offer(secondHalfMinHeap.poll());
        }
    }

    public double findMedian() {
        if (secondHalfMinHeap.size() < firstHalfMaxHeap.size()) {
            return (double) firstHalfMaxHeap.peek();
        }

        return ((double) firstHalfMaxHeap.peek() + (double) secondHalfMinHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */