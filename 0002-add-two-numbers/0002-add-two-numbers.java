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
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         /*
//         Trying to use the base 10 decimal

//         Traverse through the list and multiply the current number with 10^i 
//         where i is current iteratation count starting from 0.

//         Do the same for both lists

//         Add the number and do use the same base 10 logic to create a return list
//         */

//         if(l1 == null){
//             return l2;
//         }else if(l2 == null){
//             return l1;
//         }

//         int carry = 0;
//         ListNode res = new ListNode(0);
//         ListNode sum = res;

//         while(l1.next!=null || l2.next!=null || carry!=0){
//             int s = 0;
//             if(l1!=null){
//                 s+=l1.val;
//                 l1 = l1.next;
//             }
//             if(l2!=null){
//                 s+=l2.val;
//                 l2 = l2.next;
//             }
//             s+=carry;
//             carry = s/10;
//             res.next = new ListNode(s%10);
//         }

//         return res.next;

//         /*
//         long operand1 = getReverseNumber(l1);
//         long operand2 = getReverseNumber(l2);
    
//         // System.out.println(" Operand1=" + operand1 + " Operand2="+operand2);
//         long res = operand1 + operand2;
//         // System.out.println("Sum = "+res);

//         return createReverseListNode(res);
//         */
//     }

//     /*
//     private static long getReverseNumber(ListNode l){

//         long i=0;
//         long res = 0;
//         while(l!=null){
//             res += l.val * (Math.pow(10, i++));
//             l = l.next;
//         }
//         return res;
//     }

//     private static ListNode createReverseListNode(long nn){

//         if(nn == 0){
//             return new ListNode(0);
//         }
//         ListNode res = null;
//         ListNode l =res;
//         while(nn>0){
//             ListNode newNode = new ListNode(nn%10);
//             if(res == null){ //inserting first node
//                 res = newNode;
//                 l = res;
//             }else{
//                 res.next = newNode;
//                 res = res.next;
//             }
//             nn = nn/10;
//         }
//         return l;
//     }
//     */
// }


// ---------------- REVISION ------------- 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(head1!=null && head2!=null){
            int sum = carry+ head1.val + head2.val;
            int v = sum%10;
            carry = sum/10;
            tail.next = new ListNode(v);
            tail = tail.next;
            head1 = head1.next;
            head2 = head2.next;
        }

        while(head2!=null) {
            int sum = carry + head2.val;
            int v = sum%10;
            carry = sum/10;
            tail.next = new ListNode(v);
            tail = tail.next;
            head2 = head2.next;
        }

        while(head1!=null) {
            int sum = carry + head1.val;
            int v = sum%10;
            carry = sum/10;
            tail.next = new ListNode(v);
            tail = tail.next;
            head1 = head1.next;
        }

        while(carry>0){
            int v = carry%10;
            carry = carry/10;
            tail.next = new ListNode(v);
            tail = tail.next;
        }

        return dummy.next;
    }
}