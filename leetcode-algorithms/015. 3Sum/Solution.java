/**
 * sort first, then for each element, do two sum to find other elements
 * Time  : O(N^2)
 * Space : O(1)
 * BUG: forgot to avoid duplication
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++){
            
            // avoid duplications!!!!!!! IMPORTANT
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = 0 - nums[i];   
            int left = i+1;
            int right = nums.length - 1;
            while (left < right){
                if (nums[left] + nums[right] > target){
                    right--;
                } else if (nums[left] + nums[right] < target){
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    // avoid duplication，moving one direction is enough, since
                    // if one side changes, the other side has the change
                    while (left < right && nums[left] == nums[left-1]) left++;
                }
            }
        }
        
        return result;
    }
}
