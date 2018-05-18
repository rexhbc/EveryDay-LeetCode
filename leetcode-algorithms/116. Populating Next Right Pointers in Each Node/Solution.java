/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

/**
 * Time: O(N)
 * Space: O(1)
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        
        while (root != null){
            TreeLinkNode curLevel = root;
            
            while (curLevel != null){
                if (curLevel.left != null){
                    curLevel.left.next = curLevel.right;
                }
                
                if (curLevel.right != null && curLevel.next != null){
                    curLevel.right.next = curLevel.next.left;
                }
                curLevel = curLevel.next;
            }
            root = root.left;
        }
    }
}
