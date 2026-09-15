/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {

        if (head == null) {
            return head;
        }

        Node current = head;

        while (current != null) {

            if (current.child == null) {
                current = current.next;
            }

            else {
                Node childTail = current.child;

                // Find the tail of the child list
                while (childTail.next != null) {
                    childTail = childTail.next;
                }

                // Connect child list to the remaining main list
                childTail.next = current.next;

                if (current.next != null) {
                    current.next.prev = childTail;
                }

                // Insert child list after current node
                current.next = current.child;
                current.child.prev = current;

                // Remove child pointer
                current.child = null;
            }
        }

        return head;
    }
}