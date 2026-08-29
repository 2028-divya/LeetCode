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
    public ListNode rotateRight(ListNode head, int k) {

        // No rotation needed
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode tail = head;

        // Find length and tail
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }

        // Make the list circular
        tail.next = head;

        // Avoid unnecessary rotations
        k = k % length;

        // Find the new tail
        ListNode newTail = head;

        for (int i = 1; i <= length - k - 1; i++) {
            newTail = newTail.next;
        }

        // Node after newTail becomes the new head
        ListNode newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }
}