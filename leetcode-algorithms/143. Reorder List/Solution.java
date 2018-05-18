/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Solution: cut the list in two halfs, reverse the second half, and merge back.
 * Time: O(N)
 * Space: O(1)
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        
        // find the middle node
        ListNode mid = findMiddle(head);
        ListNode firstHalf = head;
        ListNode secondHalf = mid.next;
        
        // cut the middle
        mid.next = null;
        
        // reverse second half and merge
        head = merge(firstHalf, reverse(secondHalf));
    }
    
    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    
    private ListNode merge(ListNode one, ListNode two){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null && two != null){
            cur.next = one;
            one = one.next;
            cur.next.next = two;
            two = two.next;
            cur = cur.next.next;
        }
        
        if (one != null){
            cur.next = one;
        }
        if (two != null){
            cur.next = two;
        }
        
        return dummy.next;
    }
}
