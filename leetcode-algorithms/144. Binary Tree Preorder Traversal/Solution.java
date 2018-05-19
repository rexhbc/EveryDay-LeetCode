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
 * Recursion way of Pre-Order Traversal
 * Time:  O(N)
 * Space: O(Height) -> O(N)
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        
        preOrder(root, result);
        
        return result;
    }
    
    private void preOrder(TreeNode root, List<Integer> result){
        if (root == null){
            return;
        }
        
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }
}

/**
 * Stack way of Pre-Order Traversal
 * Time:  O(N)
 * Space: O(N)
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        if (root == null){
            return preOrder;
        }
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        
        while (!stack.isEmpty()){
            TreeNode cur = stack.pollFirst();
            preOrder.add(cur.val);
            
            if (cur.right != null){
                stack.offerFirst(cur.right);
            }
            
            if (cur.left != null){
                stack.offerFirst(cur.left);
            }
        }
        
        return preOrder;
    }
}

/**
 * Morris way of Pre-Order Traversal
 * Time:  O(N)
 * Space: O(1)
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        if (root == null){
            return preOrder;
        }
        
        while (root != null){
            if (root.left == null){
                preOrder.add(root.val);
                root = root.right;
            } else {
                // find the inorder predecessor 
                TreeNode cur = root.left;
                while (cur.right != null && cur.right != root) cur = cur.right;
                
                if (cur.right == root){
                    cur.right = null;
                    root = root.right;
                }
                else {
                    preOrder.add(root.val);
                    cur.right = root;
                    root = root.left;
                }
            }
        }
        
        return preOrder;
    }
}
