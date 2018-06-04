/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * find mid, reverse the first half, check parlindrom
 * Time : O(N)
 * Space: O(1)
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        
        // find mid
        ListNode mid = findMid(head);
        ListNode midNext = mid.next;
        
        // reverse first half
        ListNode pre = null;
        while (pre != mid){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        
        // two case: null<-1<-2 2->1->null ||  null<-1<-2 1->null
        return isPalindrome(mid,midNext) || isPalindrome(mid.next, midNext);
    }
    
    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private boolean isPalindrome(ListNode one, ListNode two){
        while (one != null && two != null){
            if (one.val != two.val){
                return false;
            }
            one = one.next;
            two = two.next;
        }
        
        // if there is some remaining node left, it is NOT palindrome
        if (one != null || two != null){
            return false;
        }
        
        return true;
    }
}
