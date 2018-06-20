/**
 * backtrack with swap-swap
 * Time : O(N!)
 * Space: O(N)
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        DFS(result, cur, 0, nums);
        return result;
    }
    
    private void DFS(List<List<Integer>> result, List<Integer> cur, int level, int[] nums){
        // base case
        if (cur.size() == nums.length){
            result.add(new ArrayList(cur));
            return;
        }
        
        for (int i = level; i < nums.length; i++){
            swap(nums, i, level);
            cur.add(nums[level]);
            DFS(result, cur, level+1, nums);
            swap(nums, i, level);
            cur.remove(cur.size()-1);
        }
    }
    
    private void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}

/**
 * backtrack with "brute force"
 * Time : O(N!)
 * Space: O(N)
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        DFS(result, cur, nums);
        return result;
    }
    
    private void DFS(List<List<Integer>> result, List<Integer> cur, int[] nums){
        // base case
        if (cur.size() == nums.length){
            result.add(new ArrayList(cur));
            return;
        }
        
        for (int i = 0; i < nums.length; i++){
            if (cur.contains(nums[i])) continue;
            cur.add(nums[i]);
            DFS(result, cur, nums);
            cur.remove(cur.size()-1);
        }
    }
    
}
