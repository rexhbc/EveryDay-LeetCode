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
 * each level, compare two child node, if they dont both return non-null,
 * meaning that the root is the LCA, return the current statues to previou level
 * Time : O(N)
 * Space: O(H) -> O(H)
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

/**
 * we know that the relation is one.val <= LCA.val <= two.val 
 * Time : O(N)
 * Space: O(H) -> O(H)
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null){
            return null;
        }
        
        return DFS(root, p, q);
    }
    
    private TreeNode DFS(TreeNode root, TreeNode one, TreeNode two){
        if (one.val < root.val && two.val < root.val){
            return DFS(root.left, one, two);
        } else if (one.val > root.val && two.val > root.val){
            return DFS(root.right, one, two);
        } else {
            return root;
        }
    }
}

/**
 * iterative method
 * Time : O(N)
 * Space: O(1)
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null){
            return null;
        }
        
        return DFS(root, p, q);
    }
    
    private TreeNode DFS(TreeNode root, TreeNode one, TreeNode two){
        
        // determines they are both larger are both smaller,
        // then you need to go to the next level
        while ((root.val - one.val) * (root.val - two.val) > 0){
            if (one.val < root.val){
                root = root.left;
            } else {
                root = root.right;
            }
            
        }   
        
        return root;
    }
}
