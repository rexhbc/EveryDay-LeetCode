/**
 * using maxHeap to record the first half
 * and minHeap to record the second half
 * Time : O(logN) for addNum since the insertion to the heap takes logN time
 *        O(1) for findMedian
 * Space: O(N) since we store everything in the heap
 */
class MedianFinder {
    
    PriorityQueue<Integer> smaller;
    PriorityQueue<Integer> larger;

    /** initialize your data structure here. */
    public MedianFinder() {
        larger = new PriorityQueue<>();
        smaller = new PriorityQueue<>(11, Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        // when to added to the smaller side
        if (smaller.isEmpty() || num <= smaller.peek()){
            smaller.offer(num);
        } else {
            larger.offer(num);
        }
        
        // in order to the make the size likely, we need to adjust size
        if (larger.size() > smaller.size()){
            smaller.offer(larger.poll());
        } else if (smaller.size() - larger.size() == 2){
            larger.offer(smaller.poll());
        }
        
    }
    
    public double findMedian() {
        int size = smaller.size()+larger.size();
        
        if (size % 2 == 0){
            return (smaller.peek()+larger.peek())/2.0;
        } else {
            return smaller.peek()/1.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
