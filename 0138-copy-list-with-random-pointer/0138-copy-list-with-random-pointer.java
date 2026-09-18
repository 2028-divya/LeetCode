/*
 // Definition for a Node.
 class Node {
     int val;
     Node next;
     Node random;

     public Node(int val) {
         this.val = val;
         this.next = null;
         this.random = null;
     }
 }
*/

class Solution {
    public Node copyRandomList(Node head) {

        // Empty list
        if (head == null) {
            return null;
        }

        // Step 1: Create a clone after every original node
        Node current = head;

        while (current != null) {

            Node cloneNode = new Node(current.val);

            // Insert clone between current node and its next node
            cloneNode.next = current.next;
            current.next = cloneNode;

            current = cloneNode.next;
        }

        // Step 2: Set random pointers of cloned nodes
        current = head;

        while (current != null) {

            Node originalNode = current;
            Node cloneNode = current.next;

            // Original random's next node is its clone
            if (originalNode.random != null) {
                cloneNode.random = originalNode.random.next;
            }

            current = cloneNode.next;
        }

        // Step 3: Separate original list and cloned list
        current = head;

        Node clonedHead = head.next;

        while (current != null) {

            Node originalNode = current;
            Node cloneNode = current.next;

            // Restore the original list
            originalNode.next = cloneNode.next;

            // Connect clone to the next clone
            if (cloneNode.next != null) {
                cloneNode.next = cloneNode.next.next;
            }

            current = current.next;
        }

        return clonedHead;
    }
}