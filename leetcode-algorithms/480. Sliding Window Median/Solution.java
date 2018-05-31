/**
 * using maxHeap to record the first half
 * and minHeap to record the second half
 * Time : O(NlogN)
 * Space: O(N) since we store everything in the heap
 * BUG:  be careful with deleting, since i define first half has more
 *       elements then the second half, i have to delete the first half
 *       when the number to delete is the same as the median number.
 */
class Solution {
    PriorityQueue<Integer> larger = new PriorityQueue<>();
    PriorityQueue<Integer> smaller = new PriorityQueue<>(11, Collections.reverseOrder());
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        if (n <= 0){
            return new double[0];
        }
        
        double[] result = new double[n];
        int index = 0;
        
        for (int i = 0; i < nums.length; i++){
            addNum(nums[i]);
            
            // remove the element
            if (i >= k){
                remove(nums[i-k]);
            }
            
            // get the median
            if (i >= k-1){
                result[index] = findMedian();
                index++;
            }
            
        }
        
        return result;
    }
    
    private void addNum(int num) {
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
    
    private void remove(int num){
        if (num <= findMedian()){// BE CAREFUL WITHE <=
            smaller.remove(num);
        } else {
            larger.remove(num);
        }
        
        // in order to the make the size likely, we need to adjust size
        if (larger.size() > smaller.size()){
            smaller.offer(larger.poll());
        } else if (smaller.size() - larger.size() == 2){
            larger.offer(smaller.poll());
        }
    }
    
    private double findMedian() {
        int size = smaller.size()+larger.size();
        
        if (size % 2 == 0){
            return ((double)smaller.peek()+(double)larger.peek())/2.0;
        } else {
            return (double)smaller.peek();
        }
    }
}
