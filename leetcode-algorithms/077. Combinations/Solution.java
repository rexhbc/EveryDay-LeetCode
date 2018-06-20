/**
 * Backtracking
 * Time : O(N choose K) = O(N!/(K!(N-K)!)) ->>> O(N!)
 * Space: O(K) since there is k levels
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        DFS(result, cur, 1, n, k);
        return result;
    }
    
    private void DFS(List<List<Integer>> result, List<Integer> cur, int startNum, int n, int k){
        if (cur.size() == k){
            result.add(new ArrayList(cur));
            return;
        }
        
        for (int i = startNum; i <= n; i++){
            cur.add(i);
            DFS(result, cur, i+1, n, k); // next level starts with i+1
            cur.remove(cur.size()-1);
        }
    }
}
