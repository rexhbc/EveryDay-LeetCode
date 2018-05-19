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

/**
 * Morris way of inOrder
 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        if (root == null){
            return inOrder;
        }
        
        while (root != null){
            if (root.left == null){
                inOrder.add(root.val);
                root = root.right;
            } else {
                // find the inorder predecessor 
                TreeNode cur = root.left;
                while (cur.right != null && cur.right != root) cur = cur.right;
                
                if (cur.right == null){
                    cur.right = root;
                    root = root.left;
                }
                else {
                    inOrder.add(root.val);
                    cur.right = null;
                    root = root.right;
                }
            }
        }
        
        return inOrder;
    }
}
