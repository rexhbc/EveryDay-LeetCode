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
