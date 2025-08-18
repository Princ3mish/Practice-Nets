/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if( head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while( true ){
            ListNode kth = prev;
            for( int i = 0 ; i < k && kth != null ; i++) kth = kth.next;
            if( kth == null) break;

            ListNode groupNext = kth.next;
            ListNode curr = prev.next;
            ListNode prevReverse = groupNext;

            for( int i = 0 ; i < k ; i++){
                ListNode temp = curr.next;
                curr.next = prevReverse;
                prevReverse = curr;
                curr = temp;
            }
            ListNode temp = prev.next;
            prev.next = prevReverse;
            prev = temp;
        }
        return dummy.next;
    }
}