/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null){
            return null;
        }
        
        return DFS(root, p, q);
    }
    
    private TreeNode DFS(TreeNode root, TreeNode one, TreeNode two){
        
        // base case
        if (root == null || root == one || root == two){
            return root;
        }
        
        TreeNode left = DFS(root.left, one, two);
        TreeNode right = DFS(root.right, one, two);
        
        if (left != null && right != null){
            return root;
        }
        
        return left == null ? right:left;
    }
}
