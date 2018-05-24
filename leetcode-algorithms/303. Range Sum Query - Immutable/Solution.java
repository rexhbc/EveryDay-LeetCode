/** 
 * dp[i] represent the sum of number from 0th to ith
 * Time : O(1) for sum range
 * Space: O(N)
 */
class NumArray {
    private int[] dp;
    private int[] array;

    public NumArray(int[] nums) {
        dp = new int[nums.length];
        array = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++){
            if (i == 0){
                dp[i] = nums[i];
            } else { // i >= 1
                dp[i] = nums[i] + dp[i-1];
            }
            
            array[i] = nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return dp[j] - dp[i] + array[i];
    }
}

/** 
 * dp[i] represent the sum of number from 0th to i-1th
 * sum is dp[j+1] - dp[i]
 * Time : O(1) for sum range
 * Space: O(N)
 */
class NumArray {
    private int[] dp;

    public NumArray(int[] nums) {
        dp = new int[nums.length+1];
        
        for (int i = 1; i <= nums.length; i++){
            dp[i] = dp[i-1] + nums[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        return dp[j+1] - dp[i];
    }
}

