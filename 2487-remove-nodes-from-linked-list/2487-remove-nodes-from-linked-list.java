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
    public ListNode removeNodes(ListNode head) {

        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;

        // Traverse through the linked list
        while (temp != null) {

            // Remove nodes from stack that are smaller
            // than the current node
            while (!st.isEmpty() && st.peek().val < temp.val) {
                st.pop();
            }

            // Push the current node into the stack
            st.push(temp);

            // Move to the next node
            temp = temp.next;
        }

        // Reconstruct the linked list from the stack
        ListNode newHead = null;

        while (!st.isEmpty()) {
            ListNode top = st.pop();

            top.next = newHead;
            newHead = top;
        }

        return newHead;
    }
}