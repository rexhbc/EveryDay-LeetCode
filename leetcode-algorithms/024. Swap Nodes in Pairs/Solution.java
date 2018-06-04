/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Recursion
 * Time : O(N)
 * Space: O(N)
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode next = swapPairs(head.next.next);
        
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = next;
        
        return newHead;
    }
}

/**
 * Iterative
 * Time : O(N)
 * Space: O(1)
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        
        while (cur.next != null && cur.next.next != null){
            ListNode next = cur.next.next;
            cur.next.next = cur.next.next.next;
            next.next = cur.next;
            cur.next = next;
            cur = cur.next.next;
        }
        
        return dummy.next;
    }
}
