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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        
        while (!queue.isEmpty()){
            List<Integer> cur = new ArrayList<>();
            int size = queue.size();
            
            for (int i = 0; i < size; i++){
                TreeNode curNode = queue.pollFirst();
                cur.add(curNode.val);
                if (curNode.left != null){
                    queue.offerLast(curNode.left);
                }
                if (curNode.right != null){
                    queue.offerLast(curNode.right);
                }
            }
            
            result.add(0,cur);
        }
        
        return result;
    }
}
