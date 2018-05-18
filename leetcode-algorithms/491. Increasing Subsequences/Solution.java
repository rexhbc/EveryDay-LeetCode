/**
 * Time: O(N!)
 * Space: O(N)
 */

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        if (nums == null || nums.length == 0){
            return new ArrayList(result);
        }
        
        List<Integer> cur = new ArrayList<>();
        dfs(cur, 0, nums,result);
        
        return new ArrayList(result);
    }
    
    private void dfs(List<Integer> cur, int level, int[] nums, Set<List<Integer>> result){
        
        // base case
        if (level == nums.length){
            if (cur.size() >= 2){
                result.add(new ArrayList<>(cur));
            }
            return;
        }
        
        // each level, add it to the result
        if (cur.size() >= 2){
                result.add(new ArrayList<>(cur));
        }
        
        // resursive rule
        for (int i = level; i < nums.length; i++){
            if (cur.size() != 0 && nums[i] < cur.get(cur.size()-1)){
                continue;
            }
            
            cur.add(nums[i]);
            dfs(cur, i+1, nums, result);
            cur.remove(cur.size()-1);
        }
    }
}


