/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Brute force: two pass
 * Time  :O(N)
 * Space :O(1)
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int length  = 0;
        ListNode cur = head;
        
        // find the length of the list
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        
        length -= n;
        cur = dummy;
        while (length > 0) {
            length--;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}

/**
 * Two Pointer -- one pass
 * Time  :O(N)
 * Space :O(1)
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // move the fast to n+1th positon
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // move two pointer together
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }
}
