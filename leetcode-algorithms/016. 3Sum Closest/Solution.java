/**
 * same as three sum problem
 * Time : O(N^2)
 * Space: O(1)
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int cur = nums[i] + nums[left] + nums[right];
                int curDiff = Math.abs(cur-target);
                if (curDiff < diff){
                    diff = curDiff;
                    result = cur;
                }
                if (cur > target){
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        return result;
    }
}
