/**
 * Time:  O(N!)
 * Space: O(N^2): N call stack and N elemnt in the used Set
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null){
            return result;
        }
        
        List<Integer> cur = new ArrayList<>();
        dfs(cur, 0, nums, result);
        
        return result;
    }
    
    private void dfs(List<Integer> cur, int level, int[] nums, List<List<Integer>> result){
        if (level == nums.length){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        
        Set<Integer> used = new HashSet<>();
        
        for (int i = level; i < nums.length; i++){
            
            // if successfully added, meaning wont be any duplicate, otherwise, skip to the next
            if (used.add(nums[i])){
                swap(nums, i, level);
                cur.add(nums[level]);
                dfs(cur, level+1, nums, result);
                swap(nums, i, level);
                cur.remove(cur.size()-1);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}


