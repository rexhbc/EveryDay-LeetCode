/**
 * In each level, you can either add or not add
 * Time : O(2^N)
 * Space: O(N)
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        DFS(result, cur, 0, nums);
        return result;
    }
    
    private void DFS(List<List<Integer>> result, List<Integer> cur, int level, int[] nums){
        if (level == nums.length){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        
        // either add or not add for each level
        cur.add(nums[level]);
        DFS(result, cur, level+1, nums);
        cur.remove(cur.size()-1);
        
        DFS(result, cur, level+1, nums);
    }
}
