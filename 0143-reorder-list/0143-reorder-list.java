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

    // Reverse linked list
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode forwd = curr.next;

            curr.next = prev;
            prev = curr;
            curr = forwd;
        }

        return prev;
    }

    // Find middle of linked list
    public ListNode findMiddle(ListNode head) {
        ListNode temp = head;
        int len = 0;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        temp = head;
        int mid = len / 2;

        for (int i = 1; i <= mid; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public void reorderList(ListNode head) {

        // Find middle
        ListNode mid = findMiddle(head);

        // Reverse second half
        ListNode head2 = reverseList(mid.next);

        // Split the list
        mid.next = null;

        // First half
        ListNode head1 = head;

        // Merge alternately
        while (head1 != null && head2 != null) {

            ListNode next1 = head1.next;
            ListNode next2 = head2.next;

            head1.next = head2;
            head2.next = next1;

            head1 = next1;
            head2 = next2;
        }
    }
}