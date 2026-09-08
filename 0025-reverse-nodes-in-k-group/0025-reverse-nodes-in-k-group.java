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

        // Find the length of the linked list
        int length = 0;
        ListNode current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        // If fewer than k nodes are available, don't reverse them
        if (length < k) {
            return head;
        }

        // Reverse the first k nodes
        ListNode previous = null;
        current = head;

        for (int i = 1; i <= k; i++) {
            ListNode nextNode = current.next;

            current.next = previous;
            previous = current;
            current = nextNode;
        }

        // Reverse the remaining groups recursively
        ListNode reversedRemainingHead = reverseKGroup(current, k);

        // 'head' is now the tail of the reversed group
        head.next = reversedRemainingHead;

        // 'previous' is the new head of this reversed group
        return previous;
    }
}