/**
 * Time:O(N)
 * Space: O(1)
 */
class Solution {
    public int maxProduct(int[] nums) {
        int globalMax = nums[0];
        int min = nums[0];
        int max = nums[0];
        
        for (int i = 1; i < nums.length; i++){
            int prevSum = max;
            max = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
            min = Math.min(Math.min(prevSum*nums[i], min*nums[i]), nums[i]);
            globalMax = Math.max(globalMax, max);
        }
        
        return globalMax;
    }
}
