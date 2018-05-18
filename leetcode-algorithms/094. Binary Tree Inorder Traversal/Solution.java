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
 * recursion way of inOrder
 * Time: O(N)
 * Space: O(N)
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        
        inOrder(root, result);
        return result;
    }
    
    private void inOrder (TreeNode root, List<Integer> result){
        if (root == null){
            return;
        }
        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }
}

/**
 * stack way of inOrder
 * Time: O(N)
 * Space: O(N)
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = stack.pollFirst();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        
        return result;
    }
}
