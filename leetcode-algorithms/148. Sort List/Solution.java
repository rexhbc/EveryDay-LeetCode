/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Time: O(NlogN)
 * Space: O(logN)
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        // cut the list into two halves
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode secondList = slow.next;
        slow.next = null;
        ListNode firstHalf = sortList(head);
        ListNode secondHalf = sortList(secondList);
        return merge(firstHalf, secondHalf);
    }
    
    ListNode merge(ListNode one, ListNode two){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null && two != null){
            if (one.val < two.val){
                cur.next = one;
                one = one.next;
            } else {
                cur.next = two;
                two = two.next;
            }
            cur = cur.next;
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
