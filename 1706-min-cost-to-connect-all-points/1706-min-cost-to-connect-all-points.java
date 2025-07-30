/**
Return min cost to make all points connected.
Example;
input: points = [[3,12],[-2,5],[-4,1]]
Output: 18

Cost of connecting two points : distance between them: |xi - xj| + |yi - yj|
*/

class Solution {
    public int minCostConnectPoints(int[][] points){
        int n = points.length;
        boolean[] inMST = new boolean[n]; //Track if a point is in MST
        int[] minDist = new int[n]; //Min cost to connect each point to MST
    
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0; //Start from the first point so its cost is 0
    
    
        //Priorirty queue to pick the next point with smallest connection cost
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        //Each element in pq is [cost, pointInd]
        pq.offer(new int[]{0,0}); //start with first point
    
        int totalCost = 0; //Total cost of connecting all points
        int pointsUsed = 0; //no of points in mst
        while(pointsUsed<n) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int u = curr[1];
    
            if(inMST[u]) continue; //Skip it because its already in MST
    
            inMST[u] = true;
            totalCost += cost;
            pointsUsed++;
    
            //Update the min cost to connect each remaining points
            for(int v = 0; v<n; v++) {
                if(!inMST[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    //If this connection is cheaper, update it
                    if(dist < minDist[v]) {
                        minDist[v] = dist;
                        pq.offer(new int[]{dist, v});
                    }
                }
            }
        }
    
        return totalCost; 
    }
}
