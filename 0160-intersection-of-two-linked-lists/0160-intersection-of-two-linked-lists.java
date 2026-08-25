/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode currentA = headA;
        ListNode currentB = headB;

        // Find which list is longer.
        while (currentA != null && currentB != null) {
            currentA = currentA.next;
            currentB = currentB.next;
        }

        if (currentA == null) {

            int extraLengthB = 0;

            while (currentB != null) {
                extraLengthB++;
                currentB = currentB.next;
            }

            // Move B ahead by the extra nodes.
            while (extraLengthB-- > 0) {
                headB = headB.next;
            }

        } else {

            int extraLengthA = 0;

            while (currentA != null) {
                extraLengthA++;
                currentA = currentA.next;
            }

            // Move A ahead by the extra nodes.
            while (extraLengthA-- > 0) {
                headA = headA.next;
            }
        }

        // Both lists now have the same remaining length.
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}