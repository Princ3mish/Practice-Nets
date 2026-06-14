class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode current = slow;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        int maxTwinSum = 0;
        ListNode firstHalf = head;
        ListNode secondHalf = prev; 
        while (secondHalf != null) {
            int currentSum = firstHalf.val + secondHalf.val;
            maxTwinSum = Math.max(maxTwinSum, currentSum);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return maxTwinSum;
    }
}