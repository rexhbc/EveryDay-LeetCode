/** 
 * backTrack
 * Time : O(N^N)
 * Space: O(N)
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        DFS(candidates, target, 0, 0, cur, result);
        return result;
    }
    
    private void DFS(int[] candidates, int target, int level, int preSum, List<Integer> cur, List<List<Integer>> result){
        // base case
        if (level == candidates.length){
            return;
        }
        
        // in the current level, add to the result if satisfy the condition
        for (int i = level; i < candidates.length; i++){
            preSum += candidates[i];
            cur.add(candidates[i]);
            if (preSum == target){
                result.add(new ArrayList(cur));
            } else if (preSum < target){
                DFS(candidates, target, i, preSum, cur, result);
            }
            cur.remove(cur.size()-1);
            preSum -= candidates[i];
        }
    }
}

/** 
 * backTrack
 * Time : O(N^N)
 * Space: O(N)
 * BUG  : be careful with i = level to avoid duplicate
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        DFS(candidates, target, 0, 0, cur, result);
        return result;
    }
    
    private void DFS(int[] candidates, int target, int level, int preSum, List<Integer> cur, List<List<Integer>> result){
        if (preSum > target){
            return;
        } else if (preSum == target){
            result.add(new ArrayList(cur));
            return;
        } else { // when preSum < target, you need to continue going
            for (int i = level; i < candidates.length; i++){
                preSum += candidates[i];
                cur.add(candidates[i]);
                DFS(candidates, target, i, preSum, cur, result);
                cur.remove(cur.size()-1);
                preSum -= candidates[i];
            }
        }
    }
}
