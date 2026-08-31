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
    public ListNode swapNodes(ListNode head, int k) {

        ListNode firstNode = head;
        ListNode secondNode = head;

        // Find kth node from the beginning
        for (int i = 1; i < k; i++) {
            firstNode = firstNode.next;
        }

        // Start second pointer after kth node
        ListNode current = firstNode.next;

        // Move secondNode until firstNode reaches the end
        while (current != null) {
            current = current.next;
            secondNode = secondNode.next;
        }

        // Swap values
        int tempValue = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tempValue;

        return head;
    }
}