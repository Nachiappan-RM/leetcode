
// class LRUCache{
//     private class Node{
//         int key;
//         int value;
//         Node prev;
//         Node next;
        
//         public Node(int key, int value){
//             this.key = key;
//             this.value = value;
//             this.prev = null;
//             this.next = null;
//         }
//     }
    
//     private int capacity;
//     private HashMap<Integer, Node> cache;
//     private Node head;
//     private Node tail;
    
//     public LRUCache(int capacity){
//         this.capacity = capacity;
//         this.cache = new HashMap<>();
//         this.head = new Node(-1, -1);
//         this.tail = new Node(-1, -1);
//         head.next = tail;
//         tail.prev = head;
//     }
    
//     public int get(int key){
//         if(!cache.containsKey(key)){
//             return -1;
//         }
           
//         Node node = cache.get(key);
//         removeNode(node);
//         addToHead(node);
           
//         return node.value;
//     }
//     public void put(int key, int value){
//         //Key already exsits -> Update the value and push to head 
//         if(cache.containsKey(key)){
//             Node node = cache.get(key);
//             node.value = value;
//             removeNode(node);
//             addToHead(node);
//             return;
//         }
        
//         //capacity reached
//         if(capacity<=cache.size()){
//             Node leastUsed = tail.prev;
//             removeNode(leastUsed);
//             cache.remove(leastUsed.key);
//         }
        
//         //add new node
//         Node newNode = new Node(key, value);
//         addToHead(newNode);
//         cache.put(key, newNode); 
//     }
    
    
//     private void removeNode(Node node){
//         node.prev.next = node.next;
//         node.next.prev = node.prev;
//     }
    
//     private void addToHead(Node node){
//         node.next = head.next;
//         node.prev = head;
//         head.next.prev = node;
//         head.next = node;
//     }
// }


// --------REVISION------------
/**
We need to maintain a list based on Recency
We do delete and insert frequently -> DLL -> O(1)

We also need to store the value for a key -> HashMap
So for every key we can store a node with value.

When the size is full we can remove thhe first(Least recently used) node from the lists <- Evict
and remove that from HashMap as well.<-For which we can use key as well inside the node
 */
class LRUCache {
    class Node{
        int key;
        int value;
        Node next = null;
        Node prev = null;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> cache = new HashMap<>();
    Node front;
    Node rear;
    int size;
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        front = new Node(-1,-1);
        rear = new Node(-1,-1);
        front.next = rear;
        rear.prev = front;
        size = capacity;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }

        //Remove the Node from wherever it is and Attach it to the last to update access
        Node node = cache.get(key);
        remove(node);
        insertToEnd(node);

        return node.value; //Return the value
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            // cache.remove(node);
            node.value = value;
            // cache.put(key, node);
            insertToEnd(node);
        }else{
            if(cache.size()==size) {
                cache.remove(front.next.key);
                remove(front.next);
            }
            Node node = new Node(key, value);
            cache.put(key, node);
            insertToEnd(node);
        }
    }

    private void insertToEnd(Node node){
        Node prev = rear.prev;
        node.next = rear;  // node->
        node.prev = prev; // <-node
        prev.next = node; // ->node
        rear.prev = node; // node<-
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev; 
    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */