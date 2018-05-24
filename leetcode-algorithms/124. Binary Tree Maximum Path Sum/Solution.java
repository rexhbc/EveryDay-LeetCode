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
 * DFS: get from children, updated the sum, return maxPath to previous level
 * Time : O(N)
 * Space: O(H) -> O(N)
 * Bug: in each level, check if the leftmax or rightmax is <= 0,
 *      if this is the case, we should set to 0 since adding this
 *      will only result in a smaller result.
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        
        maxSum(root, result);
        return result[0];
    }
    
    private int maxSum(TreeNode root, int[] result){
        // base case
        if (root == null){
            return 0;
        }
        
        // get the maxSum from left and right child
        int leftMax = maxSum(root.left, result);
        int rightMax = maxSum(root.right, result);
        
        // if the max are negetive, there is no need to include
        // the sum and return them
        if (leftMax <= 0){
            leftMax = 0;
        }
        if (rightMax <= 0){
            rightMax = 0;
        }
        
        to see if i want to update the result
        result[0] = Math.max(result[0], leftMax+rightMax+root.val);
        
        return Math.max(root.val+leftMax, root.val+rightMax);
    }
}
