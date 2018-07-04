/**
 * Binaey search
 * Time : O(NlogN)
 * Space: O(1)
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        
        while (left < right){
            int mid = left + (right-left)/2;
            int count = 0;
            for (int i : nums){
                if (i <= mid){
                    count++;
                }
            }
            
            if (count <= mid){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
