/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Base case: If list is empty or has only one node with no loop
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        // Step 1: Detect if a cycle exists (LeetCode 141 logic)
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Moves 1 step
            fast = fast.next.next;    // Moves 2 steps

            if (slow == fast) {       // Overtake happened! Cycle detected.
                hasCycle = true;
                break;
            }
        }

        // If there is no cycle, we cannot find a starting point
        if (!hasCycle) {
            return null;
        }

        // Step 2: Find the entry point of the cycle (Floyd's Magic Trick)
        slow = head; // Move slow pointer back to the starting head

        // Move both pointers 1 step at a time until they meet again
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next; // Note: fast moves only 1 step here!
        }

        // Both pointers are now pointing to the exact node where the cycle begins
        return slow; 
    }
}
