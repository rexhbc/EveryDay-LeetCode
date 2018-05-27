/**
 * HashSet to check duplicate
 * Time : O(N)
 * Space: O(N)
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> duplicate = new HashSet<>();
        
        for (int i : nums){
            if (!duplicate.add(i)){
                return true;
            }
        }
        
        return false;
    }
}

/**
 * Sorting
 * Time : O(NlogN)
 * Space: O(1)
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        
        return false;
    }
}
