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
 * top-down DFS
 * Time : O(N)
 * Space: O(H)-> O(N)
 */
class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null){
            return 0;
        }
        
        int[] result = new int[]{0};
        DFS(root, 0, Integer.MIN_VALUE, result);
        return result[0];
    }
    
    private void DFS(TreeNode root, int preCount, int preNum, int[] result){
        // base case
        if (root == null){
            return;
        }
        
        int curCount = preCount;
        if (preNum == Integer.MIN_VALUE || root.val == preNum+1){
            curCount++;
        } else {
            curCount = 1;
        }
        result[0] = Math.max(result[0], curCount);
        DFS(root.left, curCount, root.val, result);
        DFS(root.right, curCount, root.val, result);
    }
}

/**
 * Bottom-up DFS
 * Time : O(N)
 * Space: O(H)-> O(N)
 */
class Solution {
    public int longestConsecutive(TreeNode root) {
        
        int[] result = new int[]{0};
        DFS(root,result);
        return result[0];
    }
    
    private int DFS(TreeNode root, int[] result){
        if (root == null){
            return 0;
        }
        
        int left = DFS(root.left, result)+1;
        int right = DFS(root.right, result)+1;
        
        // determines the left and right height of consecutive
        if (root.left != null && root.val +1 != root.left.val){
            left = 1;
        }
        
        if (root.right != null && root.val +1 != root.right.val){
            right = 1;
        }
        
        // update the result
        int curMax = Math.max(left, right);
        result[0] = Math.max(result[0], curMax);
        
        return curMax;
    }
}
