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
 * key: at the leaf level check if the remainSum is 0
 * Time : O(N)
 * Space: O(H) -> O(N)
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        
        // base case
        if (root == null){
            return false;
        }
        
        // check the remianSum only at leaf node
        int remainSum = sum - root.val;
        if (root.left == null && root.right == null && remainSum == 0){
            return true;
        }
        
        return hasPathSum(root.left, remainSum) || hasPathSum(root.right, remainSum);
    }
}
