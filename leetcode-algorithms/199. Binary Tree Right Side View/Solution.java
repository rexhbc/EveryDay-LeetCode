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
 * BFS
 * Time : O(N)
 * Space: O(N)
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerFirst(root);
        
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                if (i == 0){
                    result.add(queue.peekLast().val);
                }
                TreeNode cur = queue.pollLast();
                if (cur.right != null){
                    queue.offerFirst(cur.right);
                }
                if (cur.left != null){
                    queue.offerFirst(cur.left);
                }
            }
        }
        
        return result;
    }
}

/**
 * DFS
 * Time : O(N)
 * Space: O(N)
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();        
        DFS(root, result,0);
        return result;
    }
    
    private void DFS(TreeNode root, List<Integer> result, int level){
        if (root == null){
            return;
        }
        
        if (level == result.size()){
            result.add(root.val);
        }
        
        DFS(root.right, result, level+1);
        DFS(root.left, result, level+1);
        
    }
}
