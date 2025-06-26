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
    // public ListNode reverseList(ListNode head) {
    //     if(head == null || head.next == null) return head;
    //     ListNode prev = null;
    //     ListNode curr = head;

    //     while(curr!=null){
    //         ListNode n = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = n;
    //     }

    //     return prev;

    // }

    // -------REVISION---------
    /**
    
    A->B->C->D->E
    A<-B->C->D->E

    first = A
    second = B
    temp = C (second.next);
    second.next = first;
    first = second;
    second = temp
     */
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) {
            return head;
        }
        ListNode first = null;
        ListNode second = head;

        while(second!=null){
            ListNode third = second.next;
            second.next = first;
            first = second;
            second = third;
        }

        return first;
    }
}