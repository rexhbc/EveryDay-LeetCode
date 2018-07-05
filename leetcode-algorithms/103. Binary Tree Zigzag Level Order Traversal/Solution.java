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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        int level = 1;
        
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> curList = new ArrayList<>();
            
            if (level % 2 == 1){
                for (int i = 0; i < size; i++){
                    TreeNode cur = queue.pollFirst();
                    curList.add(cur.val);
                    if (cur.left != null){
                        queue.offerLast(cur.left);
                    }
                    if (cur.right != null){
                        queue.offerLast(cur.right);
                    }
                }
            } else {
                for (int i = 0; i < size; i++){
                    TreeNode cur = queue.pollLast();
                    curList.add(cur.val);
                    if (cur.right != null){
                        queue.offerFirst(cur.right);
                    }
                    if (cur.left != null){
                        queue.offerFirst(cur.left);
                    }
                }
            }
            // changing direction
            level++;
            result.add(curList);
        }
        return result;
    }
}
