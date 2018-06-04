/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * recursion
 * Time: O(N)
 * Space: O(N) since there is N/K level, and each level, you do K times
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // base case checking whether how many node left
        int count = 0;
        ListNode cur = head;
        while (cur != null && count < k){
            cur = cur.next;
            count++;
        }
        
        // if less then k node left, we should return head
        // since we dont need reverse
        if (count < k){
            return head;
        }
        
        // cur points to k+1 node
        ListNode pre = reverseKGroup(cur, k);
        
        // reverse k times
        for (int i = 0; i < k; i++){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        
        return pre;
    }
}
