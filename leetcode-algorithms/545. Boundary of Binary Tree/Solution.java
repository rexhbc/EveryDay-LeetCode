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
 * top one- left-leaves -right
 * Time : O(N)
 * Space: O(N)
 * BUG: for left and right bound, need to consider the case where you dont add the leaves nodes
 */
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        
        // add root
        result.add(root.val);
        // add leftBound
        leftBound(root.left, result);
        // add leaves
        // need to do two times to avoid the case when there is only root
        leaves(root.left, result);
        leaves(root.right, result);
        // add rightBound
        rightBound(root.right, result);
        
        return result;
    }
    
    private void leftBound(TreeNode root, List<Integer> result){
        // it is either at the end or at the leave node, then you need to return
        if (root == null || (root.left == null && root.right == null)) return;
        result.add(root.val);
        
        if (root.left == null) leftBound(root.right, result);
        else leftBound(root.left, result);
    }
    
    private void leaves(TreeNode root, List<Integer> result){
        if (root == null) return;
        
        // when determines to add
        if (root.left == null && root.right == null){
            result.add(root.val);
            return;
        }
        leaves(root.left, result);
        leaves(root.right, result);
    }
    
    private void rightBound(TreeNode root, List<Integer> result){
        if (root == null || (root.right == null && root.left == null)) return;
        
        if (root.right == null) rightBound(root.left, result);
        else rightBound(root.right, result);
        
        // after visiting all of them, then adding
        result.add(root.val);
    }
}
