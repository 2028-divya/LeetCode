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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Dummy node creation
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        // Loop runs ONLY when BOTH lists have elements to compare
        while(list1 != null && list2 != null) {

            if(list1.val <= list2.val) {
                tail.next = list1;
                tail = list1; 
                list1 = list1.next; // Fixed variable name from 'list' to 'list1'
            }
            else { // If list1.val > list2.val
                tail.next = list2;
                tail = list2; 
                list2 = list2.next; // Fixed variable name from 'list' to 'list2'
            }
        } 

        // Attach the remaining nodes of whichever list is left over
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        // Return the actual head, skipping the fake -1 node
        return dummy.next;
    }
}
