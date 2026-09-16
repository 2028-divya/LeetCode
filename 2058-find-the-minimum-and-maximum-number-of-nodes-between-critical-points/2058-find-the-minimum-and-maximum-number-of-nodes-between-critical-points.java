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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        if (head == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode curr = head.next;

        // Position of the current node in the linked list
        int position = 1;

        // Store positions of all critical points
        List<Integer> criticalPoints = new ArrayList<>();

        while (curr != null && curr.next != null) {

            // Current node is a local maximum
            if (curr.val > prev.val && curr.val > curr.next.val) {
                criticalPoints.add(position);
            }

            // Current node is a local minimum
            if (curr.val < prev.val && curr.val < curr.next.val) {
                criticalPoints.add(position);
            }

            // Move to the next node
            prev = prev.next;
            curr = curr.next;
            position++;
        }

        // At least two critical points are required
        // to calculate the distances
        if (criticalPoints.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDistance = Integer.MAX_VALUE;

        // Find the minimum distance between consecutive critical points
        for (int index = 1; index < criticalPoints.size(); index++) {
            minDistance = Math.min(
                minDistance,
                criticalPoints.get(index) - criticalPoints.get(index - 1)
            );
        }

        // Maximum distance is between the first and last critical point
        int maxDistance =
                criticalPoints.get(criticalPoints.size() - 1)
                - criticalPoints.get(0);

        return new int[]{minDistance, maxDistance};
    }
}