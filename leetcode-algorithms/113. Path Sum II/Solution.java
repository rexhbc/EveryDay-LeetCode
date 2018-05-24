/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * Each level, add the current the go to the next level if not null
 * Time : O(N)
 * Space: O(H) -> O(N)
 * Bug  : forgot to check null in current level for the left and right children
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        
        List<Integer> cur = new ArrayList<>();
        DFS(root, sum, cur, result);
        return result;
    }
    
    private void DFS(TreeNode root, int remainSum, List<Integer> cur, List<List<Integer>> result){
        // base case
        if (root.left == null && root.right == null){
            cur.add(root.val);
            if (remainSum - root.val == 0){
                result.add(new ArrayList(cur));
            }
            cur.remove(cur.size()-1);
            return;
        }
        
        // in the current level, add the current value and the go to next level
        cur.add(root.val);
        if (root.left != null){
            DFS(root.left, remainSum - root.val, cur, result);
        }
        if (root.right != null){
            DFS(root.right, remainSum - root.val, cur, result);
        }
        cur.remove(cur.size()-1);
    }
}
