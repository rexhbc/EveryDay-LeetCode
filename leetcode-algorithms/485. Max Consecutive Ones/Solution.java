/**
 * brute force
 * Time : O(N)
 * Space: O(1)
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int globalMax = 0;
        int counter = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                counter++;
            } else {
                counter = 0;
            }
            globalMax = Math.max(globalMax, counter);
        }
        
        return globalMax;
    }
}
