/**
 * Siding window because it is contiguous subarray
 * Time : O(N)
 * Space: O(1)
 * Bug  : be careful when adding to the counter
 */

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int counter = 0;
        int i = 0;
        int j = 0;
        int cur = 1;
        
        while (j < nums.length){
            cur = cur * nums[j];
            
            while (i < j && cur >= k){
                cur = cur/nums[i];
                i++;
            }
            
            // BUG:we only add when it is less then k
            if (cur < k){
                counter += j-i+1;
            }
            j++;
        }
        
        return counter;
    }
}
