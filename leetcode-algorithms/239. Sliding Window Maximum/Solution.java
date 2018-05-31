/**
 * Sliding window with deque maintaining the structure
 * Time : O(N)
 * Space: O(K) at most we have k element in the dequeue
 * Bug  : have to delete from right as well 
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0){
            return new int[0];
        }
        
        int[] result = new int[nums.length-k+1];
        int index = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++){
            
            // if left out of bound, remove it
            while (!queue.isEmpty() && queue.peekFirst() < i-k+1){
                queue.pollFirst();
            }
            
            // maintain a queue that the most left is the max of the current window
            // by also removing from the right if the current is bigger then the
            // the most right!!!
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            
            // insert the element INDEX
            queue.offerLast(i);
            if (i >= k-1){
                result[index] = nums[queue.peekFirst()];
                index++;
            }
        }
        
        return result;
    }
}
