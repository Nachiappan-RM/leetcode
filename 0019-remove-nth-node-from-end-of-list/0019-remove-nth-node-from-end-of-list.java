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
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     /*
    //     Approach,
    //     One run to find length
    //     next run till length-n-1 and link that to length-n+1
    //     */

    //     ListNode traverse = head;
    //     int length = 0;
    //     while(traverse!=null){
    //         length++;
    //         traverse = traverse.next;
    //     }

    //     traverse = head;
    //     int toTraverse = length-n;

    //     //Delete at the first
    //     if(toTraverse == 0){
    //         return traverse.next;
    //     }

    //     while(--toTraverse>0){
    //         traverse = traverse.next;
    //     }

    //     if(traverse!=null && traverse.next !=null){
    //         traverse.next = traverse.next.next;
    //     }

    //     return head;
    // }

    //----REVISION-------
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // One pass to compute the len
        // traverse and delete the len-n+1 th node

        int len = 0;
        ListNode h = head;

        // First pass to compute the length
        while (h != null) {
            len++;
            h = h.next;
        }

        // If we need to remove the head
        if (n == len) {
            return head.next;
        }

        // Find the (len - n)th node
        h = head;
        for (int i = 1; i < len - n; i++) {
            h = h.next;
        }

        // Skip the nth node from the end
        h.next = h.next.next;

        return head;
    }
}