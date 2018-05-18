/**
 * Time: O(NlogK)
 * Space: O(K)
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return Integer.MIN_VALUE;
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        
        for (int i:nums){
            if (minHeap.size() < k){
                minHeap.offer(i);
            } else if (i > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(i);
            }
        }
        
        return minHeap.peek();
    }
}


