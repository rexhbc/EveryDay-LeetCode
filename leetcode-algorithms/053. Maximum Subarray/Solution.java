/**
 * Time:  O(N)
 * Space: O(N)
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int globalMax = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (dp[i-1] > 0){
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            globalMax = Math.max(globalMax, dp[i]);
        }
        
        return globalMax;
    }
}

/**
 * Time:  O(N)
 * Space: O(1)
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int globalMax = nums[0];
        int preSum = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (preSum > 0){
                preSum = preSum + nums[i];
            } else {
                preSum = nums[i];
            }
            globalMax = Math.max(globalMax, preSum);
        }
        
        return globalMax;
    }
}
