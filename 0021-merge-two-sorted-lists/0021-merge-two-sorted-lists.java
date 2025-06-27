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
    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    //     if(list1 == null){
    //         return list2;
    //     }else if(list2 == null){
    //         return list1;
    //     }

    //     // ListNode head = (list1.val<list2.val) ? list1 : list2;
    //     // ListNode
    //     // while(list1.next!=null && list2.next!=null){
    //     //     if(list1.val<list2.val){
    //     //         head
    //     //     }
    //     // }

    //     // return head;

    //     ListNode firstList = list1;
    //     ListNode secondList = list2;
    //     ListNode merged =null;

    //     if(firstList.val<secondList.val){
    //         merged = firstList;
    //         firstList = firstList.next;
    //     }else{
    //         merged = secondList;
    //         secondList = secondList.next;
    //     }

    //     ListNode head = merged;
    //     while(firstList!=null && secondList!=null){
    //         if(firstList.val<secondList.val){
    //             merged.next = firstList;
    //             merged = merged.next;
    //             firstList = firstList.next;
    //         }else{
    //             merged.next = secondList;
    //             merged = merged.next;
    //             secondList = secondList.next;
    //         }
    //     }

    //     while(firstList!=null){
    //         merged.next = firstList;
    //         merged = merged.next;
    //         firstList = firstList.next;
    //     }
    //     while(secondList!=null){
    //         merged.next = secondList;
    //         merged = merged.next;
    //         secondList = secondList.next;
    //     }

    //     return head;
    // }

    // ------REVISION------
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }

        ListNode h1 = list1;
        ListNode h2 = list2;

        ListNode result = null;
        ListNode head = null;

        while (h1 != null || h2 != null) {
            if (h1 != null && h2 != null) {
                if (h1.val < h2.val) {
                    if (head == null) {
                        head = h1;
                        result = h1;
                    } else {
                        result.next = h1;
                        result = result.next;
                    }
                    h1 = h1.next;
                } else {
                    if (head == null) {
                        head = h2;
                        result = h2;
                    } else {
                        result.next = h2;
                        result = result.next;
                    }

                    h2 = h2.next;
                }
            } else if (h1 != null) {
                if (head == null) {
                    head = h1;
                    result = h1;
                } else {
                    result.next = h1;
                    result = result.next;
                }
                h1 = h1.next;
            } else {
                if (head == null) {
                    head = h2;
                    result = h1;
                } else {
                    result.next = h2;
                    result = result.next;
                }
                
                h2 = h2.next;
            }
        }
        result.next = null;
        return head;
    }
}