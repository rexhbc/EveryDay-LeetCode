/**
 * DP
 * Time : O(N^2)
 * SPace: O(N)
 */
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        
        int[] dp = new int[nums.length];
        dp[dp.length-1] = 0;
        
        for (int i = dp.length - 2; i >= 0; i--){
            dp[i] = -1;
            for (int j = i+1; j < nums.length && j <= i + nums[i]; j++){
                if (dp[j] != -1){
                    if (dp[i] == -1){
                        dp[i] = dp[j] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j]+1);
                    }
                }
            }
        }
        
        return dp[0];
    }
}
