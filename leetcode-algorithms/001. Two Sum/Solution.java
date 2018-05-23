/**
 * Two pass
 * Time  : O(N)
 * Space : O(N)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // first stores the target-current number, secon stores the index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++){
            int cur = target - nums[i];
            
            if (map.containsKey(cur) && map.get(cur) != i){
                return new int[]{i, map.get(cur)};
            }
        }
        
        return new int[]{-1,-1};
    }
}

/**
 * one pass
 * Time  : O(N)
 * Space : O(N)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // first stores the target-current number, secon stores the index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++){
            int cur = target - nums[i];
            if (map.containsKey(cur)){
                return new int[]{i, map.get(cur)};
            }
            map.put(nums[i], i);
        }
        
        return new int[]{-1,-1};
    }
}

/**
 * Two Pointer if sorted
 * Time  : O(N)
 * Space : O(1)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right){
            if (nums[left] + nums[right] > target){
                right--;
            } else if (nums[left] + nums[right] < target){
                left++;
            } else {
                return new int[]{left, right};
            }
        }
        return new int[]{-1,-1};
    }
}
