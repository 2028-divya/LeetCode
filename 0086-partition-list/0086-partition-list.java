class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode lessThanXHead = new ListNode(-1);
        ListNode lessThanXTail = lessThanXHead;

        ListNode greaterThanXHead = new ListNode(-1);
        ListNode greaterThanXTail = greaterThanXHead;

        ListNode temp = head;

        while (temp != null) {

            ListNode insertNode = temp;
            temp = temp.next;

            if (insertNode.val < x) {
                lessThanXTail.next = insertNode;
                lessThanXTail = insertNode;
            }
            else {
                greaterThanXTail.next = insertNode;
                greaterThanXTail = insertNode;
            }
        }

        // End the second list
        greaterThanXTail.next = null;

        // Connect both lists
        lessThanXTail.next = greaterThanXHead.next;

        return lessThanXHead.next;
    }
}