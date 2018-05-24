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
 * for each node, do findsumpath
 * Time : O(N^2) at worst, O(NlogN) for best case when tree is balanced
 * Space: O(N) since N call stack
 * 
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        
        return DFS(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int DFS(TreeNode root, int sum){        
        if (root == null){
            return 0;
        }
        
        int result = 0;
        int remainSum = sum - root.val;
        if (remainSum == 0){
            result++;
        }
        
        result += DFS(root.left, remainSum);
        result += DFS(root.right, remainSum);
        return result;
    }
}
