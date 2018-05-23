/**
 * Choose two number and do two sum
 * Time  : O(N^3)
 * Space : O(1)
 * BUG: NEVER FORGOT TO CHECK DUPLICATION
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 3; i++){
            
            // AVOID DUPLICATIONS!!!
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length - 2; j++){
                
                int left = j+1;
                int right = nums.length-1;
                int numToFind = target - nums[i] - nums[j];
                while (left < right){
                    int sum = nums[left] + nums[right];
                    if (sum > numToFind){
                        right--;
                    } else if (sum < numToFind){
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        
                        // AVOID DUPLICATIONS!!!
                        while (left < right && nums[left] == nums[left - 1]) left++;
                    }
                }
                
                // AVOID DUPLICATIONS!!!
                while (j+1 < nums.length - 2 && nums[j+1] == nums[j]) j++;
            }
        }
        
        return result;
        
    }
}
