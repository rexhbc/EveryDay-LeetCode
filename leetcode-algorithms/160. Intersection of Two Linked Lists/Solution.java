/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * Find the length of two linkedList, find the diff
 * move the longer list to the diff position, and move together
 * until you find the same node
 * Time : O(N)
 * Space: O(1)
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n = getLength(headA);
        int m = getLength(headB);
        
        int diff = 0;
        if (n > m) {
            diff = n-m;
            for (int i = 0; i < diff; i++){
                headA = headA.next;
            }
        } else {
            diff = m-n;
            for (int i = 0; i < diff; i++){
                headB = headB.next;
            }
        }
        
        while (headA != null && headB != null){
            if (headA == headB){
                return headB;
            }
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
    
    private int getLength(ListNode head){
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        return length;
    }
}
