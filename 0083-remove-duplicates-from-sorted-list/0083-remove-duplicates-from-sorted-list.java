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
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode next = head.next;

        while (next != null) {

            if (current.val == next.val) {
                // Skip the duplicate node.
                current.next = next.next;
                next = current.next;
            } else {
                current = current.next;
                next = next.next;
            }
        }

        return head;
    }
}