/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Solution: Take one element from each list into the minHeap
 * Time: O(KlogK + NlogK)
 * Space: O(K)
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(11, new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                if (l1.val == l2.val){
                    return 0;
                }
                return l1.val < l2.val? -1:1;
            }
        });
        
        for (ListNode node: lists){
            if (node != null){
                minHeap.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (!minHeap.isEmpty()){
            cur.next = minHeap.poll();
            if (cur.next.next != null){
                minHeap.offer(cur.next.next);
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
