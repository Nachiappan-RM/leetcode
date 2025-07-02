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

/**
Thinking of priority qeueue to have all the data.
- Push all the non null head nodes to priority queue(Min Heap)
- Move the head -> head.next
- Remove the root of min heap add it to the 
 */
class Solution {
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a.val, b.val));

    ListNode result = null;
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = result;

        for(ListNode l: lists){
            ListNode e = l;
            while(e!=null){
                minHeap.offer(e);
                e = e.next;
            }
        }

        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            if(head == null || result == null){
                result = node;
                head = node;
            }else{
                head.next = node;
                head = head.next;
            }
        }
        if(head!=null){
            head.next=null;
        }
        return result;
    }
}