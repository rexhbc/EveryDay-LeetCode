/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * Using a stack to store the data
 * Time : O(1) for hasNext; O(1) average for next, worst is O(H)
 * Space: O(H) 
 */
public class BSTIterator {

    Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        // push all left to get the smallest values at the top of the stack
        pushLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pollFirst();
        pushLeft(node.right);
        return node.val;
    }
    
    private void pushLeft(TreeNode root){
        while (root != null){
            stack.offerFirst(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
