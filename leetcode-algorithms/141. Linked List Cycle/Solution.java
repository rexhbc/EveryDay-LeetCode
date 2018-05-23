/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * fast and slow pinter
 * Time : O(N)
 * Space: O(1)
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        // if contains no or one element, there is no cycle
        if (head == null || head.next == null){
            return false;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        
        return false;
    }
}
