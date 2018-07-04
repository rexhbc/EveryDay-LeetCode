/**
 * Binary search
 * Time : O(LogN)
 * Space: O(1)
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        // exit when there is only one left
        while (left + 1 < right){
            if (nums[left] < nums[right]){
                return nums[left];
            }
            
            int mid = left + (right-left)/2;
            
            if (nums[mid] > nums[left]){
                left = mid;
            } else { // nums[mid] <= nums[left]
                right = mid;
            }
        }
        
        return Math.min(nums[left], nums[right]);
    }
}
