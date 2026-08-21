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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // If the list has only one node.
        if (head.next == null) {
            return null;
        }

        ListNode prev = head;
        ListNode curr = head;
        ListNode temp = null;

        // Move curr n nodes ahead.
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }

        // If curr becomes null, head is the node to remove.
        if (curr == null) {
            return head.next;
        }

        // Keep temp one node behind prev.
        while (curr != null) {
            temp = prev;
            prev = prev.next;
            curr = curr.next;
        }

        // Remove prev.
        temp.next = prev.next;

        return head;
    }
}