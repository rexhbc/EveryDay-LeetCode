/**
 * key: sort first then skip all the duplicate in each level
 * Time : O(2^N)
 * Space: O(N)
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        DFS(result, cur, 0, nums);
        return result;
    }
    
    private void DFS(List<List<Integer>> result, List<Integer> cur, int level, int[] nums){
        if (level == nums.length){
            result.add(new ArrayList<>(cur));
            return;
        }
        
        // add the current
        cur.add(nums[level]);
        DFS(result, cur, level+1, nums);
        cur.remove(cur.size()-1);
        
        // skip all the same element util the new index of the next new element
        // careful with level < nums.length - 1 since this cannot be at the last level
        while (level < nums.length-1 && nums[level] == nums[level+1]){
            level++;
        }
        
        DFS(result, cur, level+1, nums);
    }
}
