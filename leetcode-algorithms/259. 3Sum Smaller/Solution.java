/**
 * Two Pointer: similar with three sum
 * Time : O(N^2)
 * Space: O(1)
 */
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        
        // 0 1 2 3 4
        // 1 2 3 4 5 target: 8
        // i l   r
        for (int i = 0; i < nums.length - 2; i++){
            int left = i+1;
            int right = nums.length - 1;
            while (left < right){
                int cur = nums[i] + nums[left] + nums[right];
                if (cur < target){
                    result += right - left;
                    left++;
                } else { // cur >= target
                    right--;
                }
            }
            
        }
        
        return result;
    }
}
