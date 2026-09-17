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

    // Reverse the linked list
    public static ListNode reverse(ListNode head) {

        ListNode previous = null;
        ListNode current = head;

        while (current != null) {

            // Store the next node before changing the link
            ListNode nextNode = current.next;

            // Reverse the current node's link
            current.next = previous;

            previous = current;
            current = nextNode;
        }

        return previous;
    }

    public ListNode doubleIt(ListNode head) {

        // Reverse the list to process digits from right to left
        head = reverse(head);

        ListNode dummy = new ListNode(-1);
        ListNode currentResult = dummy;

        ListNode current = head;
        int carry = 0;

        while (current != null) {

            int digit = current.val;

            // Double the current digit and add carry
            int sum = digit + digit + carry;

            // Get the digit to store in the result
            int newDigit = sum % 10;

            // Calculate carry for the next digit
            carry = sum / 10;

            currentResult.next = new ListNode(newDigit);
            currentResult = currentResult.next;

            current = current.next;
        }

        // Add the remaining carry if present
        if (current == null && carry != 0) {
            currentResult.next = new ListNode(carry);
        }

        // Move to the actual result list
        dummy = dummy.next;

        // Reverse the result to restore the original order
        head = reverse(dummy);

        return head;
    }
}