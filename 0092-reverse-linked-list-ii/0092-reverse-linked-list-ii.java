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

    public ListNode reverseBetween(ListNode head, int left, int right) {

        // No reversal is needed
        if (head == null || head.next == null || left == right) {
            return head;
        }

        // Find the node just before the left position
        ListNode beforeLeft = head;

        for (int i = 1; i < left - 1; i++) {
            beforeLeft = beforeLeft.next;
        }

        // Find the first node of the portion to reverse
        ListNode current;

        if (left == 1) {
            current = head;
        } else {
            current = beforeLeft.next;
        }

        // This node becomes the tail after reversal
        ListNode reversedTail = current;

        ListNode previous = null;

        // Reverse nodes from left to right
        for (int position = left; position <= right; position++) {
            ListNode nextNode = current.next;

            current.next = previous;
            previous = current;
            current = nextNode;
        }

        // current is now the node after the reversed portion
        ListNode afterRight = current;

        // Connect the left part with the reversed portion
        if (left == 1) {
            head = previous;
        } else {
            beforeLeft.next = previous;
        }

        // Connect the reversed portion with the remaining list
        reversedTail.next = afterRight;

        return head;
    }
}