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

    public ListNode getMidElement(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Slow moves one step, fast moves two steps.
        while (fast != null) {
            fast = fast.next;

            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }

        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode middle = getMidElement(head);

        // Disconnect the first half from the second half.
        ListNode lastFirstHalf = head;

        while (lastFirstHalf.next != middle) {
            lastFirstHalf = lastFirstHalf.next;
        }

        lastFirstHalf.next = null;

        // Reverse the second half.
        ListNode secondHalf = reverse(middle);

        ListNode first = head;
        ListNode second = secondHalf;

        // Compare both halves.
        while (first != null && second != null) {
            if (first.val != second.val) {
                return false;
            }

            first = first.next;
            second = second.next;
        }

        return true;
    }
}