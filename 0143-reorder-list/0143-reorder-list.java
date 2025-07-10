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
// class Solution {
//     public void reorderList(ListNode head) {
//         /*
//         Travel till middle start pushing the nodes into stack - 2nd halve
//         Start Weaving
//         */

//         ListNode slow = head;
//         ListNode fast = head;

//         while(fast!=null && fast.next!=null){
//             slow = slow.next;
//             fast = fast.next;
//             if(fast.next!=null) fast = fast.next;
//         }

//         // if(fast==null){ //even
//             ListNode temp = slow;
//             slow = slow.next;
//             temp.next = null;
//         // }

//         Stack<ListNode> secondHalve = new Stack<>();

//         while(slow!=null){
//             secondHalve.push(slow);
//             slow = slow.next;
//         }
        
//         ListNode start = head;
//         while(start!=null && !secondHalve.isEmpty()){
//             ListNode right = start.next;
//             start.next = secondHalve.pop();
//             start.next.next = right;
//             start = right;
//         }
//     }
// }

// --------- REVISION ------------
class Solution {
    /**
    Reverse the second half of the list and reorder
     */
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Slow is in the middle of the list - start of second half
        ListNode second = reverseList(slow.next);
        slow.next = null;

        ListNode first = head;
        while(second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    private ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    } 
}