/**
 * using stack for two iteration
 * Time : O(N)
 * Space: O(N)
 * BUG : we can only pop the element from stack when the element is <= to the current number
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = result.length - 1; i >= 0; i--){
            
            // pop the element that is <= to the current one to find the
            // next GREATER element
            while (!stack.isEmpty() && stack.peekFirst() <= nums[i]){
                stack.pollFirst();
            }
            if (!stack.isEmpty()){
                result[i] = stack.peekFirst();
            } else {
                result[i] = -1;
            }
            stack.offerFirst(nums[i]);
        }
        
        for (int i = result.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && stack.peekFirst() <= nums[i]){
                stack.pollFirst();
            }
            if (!stack.isEmpty()){
                result[i] = stack.peekFirst();
            } else {
                result[i] = -1;
            }
            stack.offerFirst(nums[i]);
        }
        
        return result;
    }
}
