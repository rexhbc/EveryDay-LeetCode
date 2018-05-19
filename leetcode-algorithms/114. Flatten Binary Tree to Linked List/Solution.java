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

/**
 * Morris Algorithm
 * Time: O(N)
 * Space:O(1)
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        
        while (root != null){
            if (root.left == null){
                root = root.right;
            } else {
                
                TreeNode cur = root.left;
                while (cur.right != null && cur.right != root) cur = cur.right;
                
                if (cur.right == null){
                    cur.right = root;
                    root = root.left;
                }
                else {
                    cur.right = root.right;
                    root.right = root.left;
                    root.left = null;
                }
            }
        }
    }
    
}
