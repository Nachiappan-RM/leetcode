/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
/*
class Solution {
    public Node cloneGraph(Node node) {

        HashMap<Node, Node> cloneMap = new HashMap<>();
        if(node == null){
            return node;
        }
        Queue<Node> queue = new LinkedList<Node>();
        
        queue.offer(node);
        
        Node clone = new Node(node.val);
        cloneMap.put(node, clone);

        while(queue.size()>0){
            int size = queue.size();
            while(size-->0){
                Node current = queue.poll();
                List<Node> clonedNeighbors = new ArrayList<>();
                for(Node n: current.neighbors){
                    if(!cloneMap.containsKey(n)){
                        cloneMap.put(n, new Node(n.val));
                        queue.offer(n);
                    }
                    clonedNeighbors.add(cloneMap.get(n));
                }
                cloneMap.get(current).neighbors = clonedNeighbors;
            }
        }
        return clone;
    }
}
*/

// ------------- REVISION -------------- 
/**
BFS - with isVisited flags

No Cycles
Connected graph

Thinking of HashMap to create clone node for all the nodes
and use BFS to recreate the graph components/edges
 */
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }
        HashMap<Node, Node> cloneMap = new HashMap<>();

        createCloneNodes(node, cloneMap); //DFS
        createCloneGraph(node, cloneMap); //BFS;

        return cloneMap.get(node);
    }

    private void createCloneNodes(Node node, Map<Node, Node> cloneMap) {
        
        if(cloneMap.containsKey(node)) {
            return;
        }

        cloneMap.put(node, new Node(node.val));

        for(Node neighbor: node.neighbors) {
            createCloneNodes(neighbor, cloneMap);
        }
    }

    private void createCloneGraph(Node node, Map<Node, Node> cloneMap) {
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        HashSet<Node> isVisited = new HashSet<>();
        isVisited.add(node);

        while(!queue.isEmpty()) {
            Node currNode = queue.poll();
            List<Node> clonedNeighbors = new ArrayList<>();
            for(Node neighbor: currNode.neighbors) {
                clonedNeighbors.add(cloneMap.get(neighbor));
                if(!isVisited.contains(neighbor)) {
                    queue.offer(neighbor);
                    isVisited.add(neighbor);
                }
            }
            cloneMap.get(currNode).neighbors = clonedNeighbors;
        }
        
    }
}