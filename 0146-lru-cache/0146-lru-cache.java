
class LRUCache{
    private class Node{
        int key;
        int value;
        Node prev;
        Node next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;
    
    public LRUCache(int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
           
        Node node = cache.get(key);
        removeNode(node);
        addToHead(node);
           
        return node.value;
    }
    public void put(int key, int value){
        //Key already exsits -> Update the value and push to head 
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
            return;
        }
        
        //capacity reached
        if(capacity<=cache.size()){
            Node leastUsed = tail.prev;
            removeNode(leastUsed);
            cache.remove(leastUsed.key);
        }
        
        //add new node
        Node newNode = new Node(key, value);
        addToHead(newNode);
        cache.put(key, newNode); 
    }
    
    
    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void addToHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */