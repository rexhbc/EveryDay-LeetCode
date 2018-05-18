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
 * Recursive way of postOrder
 * Time: O(N)
 * Space: O(N)
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        
        postOrder(root, result);
        return result;
    }
    private void postOrder(TreeNode root, List<Integer> result){
        if (root == null){
            return;
        }
        
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }
}

/**
 * stack way of postOrder
 * Time: O(N)
 * Space: O(N)
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        
        Deque<TreeNode> postOrder = new ArrayDeque<>();
        postOrder.offerFirst(root);
        
        while (!postOrder.isEmpty()){
            TreeNode cur = postOrder.poll();
            result.add(cur.val);
            
            if (cur.left != null){
                postOrder.offerFirst(cur.left);
            }
            if (cur.right != null){
                postOrder.offerFirst(cur.right);
            }
        }
        
        Collections.reverse(result);
        return result;
    }
}
