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
 * DFS
 * Time : O(N)
 * Space: O(N)
 */
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null){
            return root;
        }
        
        return inverse(root);
    }
    
    private TreeNode inverse(TreeNode root){
        if (root.left == null){
            return root;
        }
        
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        
        root.left.left = root.right;
        root.left.right = root;
        root.right = null;
        root.left = null;
        
        return newRoot;
    }
}
