/**
 * Time:  O(nlogn + nlog(maxDiff))
 * Space: O(1)
 */

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        // Answer must be between 0 to (max-min)
        int left = 0;
        int right = nums[nums.length-1] - nums[0];
        
        while (left < right){
            int mid = left + (right-left)/2;
            int count = 0;
            int i = 0;
            for (int j = 0; j < nums.length; j++){
                while (nums[j] - nums[i] > mid) i++;
                count += j - i;
            }
            
            if (count < k) left = mid+1;
            else right = mid;
        }
        
        return left;
    }
}


