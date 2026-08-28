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
    public ListNode removeElements(ListNode head, int val) {
        // 1. Create a dummy node and point it to the original head of the list
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 2. Initialize the prev pointer at the dummy node and curr at the actual head
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            // If the target value is found, break the connection to delete the node
            if (curr.val == val) {
                prev.next = curr.next;
                curr = curr.next; // Move curr forward while keeping prev at the same position
            } 
            // If the node is safe, shift both pointers one step forward
            else {
                prev = curr;
                curr = curr.next;
            }
        }

        // 3. The actual new head of the modified list starts right after the dummy node
        return dummy.next;
    }
}

