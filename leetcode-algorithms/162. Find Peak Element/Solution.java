/**
 * Binary search
 * Time : O(LogN)
 * Space: O(1)
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left + 1 < right){
            int mid = left + (right-left)/2;
            
            // if it is decreasing, it will be on left side
            if (nums[mid] > nums[mid+1]){
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (nums[left] > nums[right]){
            return left;
        } else {
            return right;
        }
    }
}
