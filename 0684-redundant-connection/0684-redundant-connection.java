/*
class Solution {
    
    private boolean union(int[] par, int x, int y){
        int xRoot = find(par, x);
        int yRoot = find(par, y);

        if(yRoot==xRoot){
            return false; //Already connected
        }
        par[xRoot] = yRoot;
        return true;
    }

    private int find(int[] par, int x){
        if(par[x] == x) return x;
        return find(par, par[x]);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] par = new int[n+1];
        for(int i=1; i<=n; i++){
            par[i] = i; //Self Root
        }
        int res[] = new int[2];
        for(int[] edge: edges){
            if(!union(par, edge[0], edge[1])){
                res = edge;
            }
        }

        return res;
    }
}

*/

/**
thinking of the disjoint sets
 */
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1]; 
        int[] rank = new int[n+1]; 
        //Starting from 1
        for(int i=1; i<parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge: edges) {
            if(!union(edge[0], edge[1], parent, rank)) {
                return edge;
            }
        }

        return new int[0]; //Technically it shouldn't reach here
    }

    private int find(int node, int[] parent) {
        if(node != parent[node]) {
            parent[node] = find(parent[node], parent);
        }
        return parent[node];
    }
    
    private boolean union(int node1, int node2, int[] parent, int[] rank) {
        int root1 = find(node1, parent);
        int root2 = find(node2, parent);
        if(root1 == root2) {
            return false;
        }
        if(rank[root1] < rank[root2]) {
            parent[root1] = root2;
            rank[root2] += rank[root1];
        }else{
            parent[root2] = root1;
            rank[root1] += rank[root2];
        }

        return true;
    }
}