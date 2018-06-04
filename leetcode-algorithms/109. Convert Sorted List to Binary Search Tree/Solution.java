/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
 * recursion: the middle node is the root
 * Time : O(N)
 * Space: O(N)
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return construct(head, null);
    }
    
    private TreeNode construct(ListNode head, ListNode tail){
        if (head == tail) return null;
        
        // find the middle node and the middle node is the root
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        root.left = construct(head, slow);
        root.right = construct(slow.next, tail);
        return root;        
    }
}
