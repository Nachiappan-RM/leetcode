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
/**

Planning on using HashMap to have key node(original) to value node(cloned)
 */
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node, Node> originalToClone = new HashMap<>();
        
        Node h = head;
        
        //Creating head
        Node clone = new Node(h.val);
        originalToClone.put(h, clone);
        h = h.next;

        //Temp
        
        Node c = clone;
        //cloning the next
        while(h!=null){
            Node node = new Node(h.val);
            originalToClone.put(h, node);
            c.next = node;
            c = c.next;
            h = h.next;
        }

        //Cloning the random
        h = head;
        c = clone;
        while(h!=null){
            c.random = originalToClone.get(h.random);
            c = c.next;
            h = h.next;
        }

        return clone;
    }
}

/*
- Each node has next and random(can be null)
- Deep copy all nodes and execpt random
- Run a loop and copy random pointer

Random pointer observation,
    - If curr.random!=null
        - Possiblity to be on right -> if traverse.next found null
        - Possibility to be on left -> if traverse.next == curr.next
        
*/