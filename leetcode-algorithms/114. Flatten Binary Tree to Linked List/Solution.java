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
 * Time: O(N^2)
 * Space:O(H)
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        
        // 切断路线
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        
        // dfs
        flatten(left);
        flatten(right);
        
        // 重新组合
        root.right = left;
        TreeNode cur = root;
        
        // iterate though util the right end
        while (cur.right != null){
            cur = cur.right;
        }
        
        cur.right = right;
    }
    
}
