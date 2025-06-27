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
    // public boolean hasCycle(ListNode head) {
    //     int pos = -1;

    //     //Floyd detection algo

    //     if(head == null || head.next == null){
    //         return false;
    //     }
    //     ListNode slow = head;
    //     ListNode fast = head;

    //     while(fast!=null && fast.next !=null){
    //         slow = slow.next;
    //         fast = fast.next;
    //         if(fast!=null){
    //             fast = fast.next;
    //         }

    //         if(fast == slow){
    //             break;
    //         }
    //     }

    //     return fast==slow;


    //     // /*
    //     // Flord's Cycle detection method
    //     // */

    //     // ListNode slow = head;
    //     // ListNode fast = head;

    //     // while(fast!=null && fast.next!=null){
    //     //     slow = slow.next;
    //     //     fast = fast.next.next;
    //     //     if(slow==fast){
    //     //         return true;
    //     //     }
    //     // }
    //     // return false;
    // }


    //---------REVISION--------
    public boolean hasCycle(ListNode head){
        //Floyd Detection
        if(head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}