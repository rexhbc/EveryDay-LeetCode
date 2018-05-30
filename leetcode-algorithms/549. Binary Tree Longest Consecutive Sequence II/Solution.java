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
 * key: each level, determines the increasing number and decreasing number
 *      and return the current increasing and decreasing to previous level
 * Time : O(N)
 * Space: O(H) -> O(N)
 */
class Solution {
    public int longestConsecutive(TreeNode root) {        
        int[] result = new int[]{0};
        DFS(root, result);
        return result[0];
    }
    
    private int[] DFS(TreeNode root, int[] result){
        if (root == null){
            return new int[]{0,0};
        }
        
        int[] left = DFS(root.left, result);
        int[] right = DFS(root.right, result);
        
        int inc = 1;
        int dec = 1;
        if (root.left != null){
            if (root.val == root.left.val + 1){
                dec = Math.max(dec, left[1] + 1);   
            } else if (root.val == root.left.val - 1){
                inc = Math.max(inc, left[0] + 1);
            }
        }
        
        if (root.right != null){
            if (root.val == root.right.val + 1){
                dec = Math.max(dec, right[1] + 1);
            } else if (root.val == root.right.val - 1){
                inc = Math.max(inc, right[0] + 1);
            }
        }
        
        result[0] = Math.max(result[0], inc + dec - 1);
        
        return new int[]{inc, dec};
    }
}
