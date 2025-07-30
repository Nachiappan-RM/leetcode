/**

Given a 2D grid [][]

grid[i][j] represents the elevation at that point (i, j)

Its raining so water starts increasing gradually, At any time t
Any cell with value <= t will sunk - Making it swimmable

Starting at (0,0) return the minimum time until swimmer can reach bottom right cell

0 2
1 3
maxElev = 3


*/

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        // dist[i][j] = minimum "time" (max elevation) to reach (i, j)
        int[][] dist = new int[n][n];

        for(int i=0; i<n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        //Min-heap of (time, x, y)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});

        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};

        while(!pq.isEmpty()) {

            int[] cur = pq.poll();

            int time = cur[0], x = cur[1], y =cur[2];
            //Once we reach bottom-right thats the optimal time
            if(x == n-1 && y == n-1) {
                return time;
            }
            // If we've already better route already - we are good to skip
            if(time > dist[x][y]) {
                continue;
            }
            // Explore neightbors
            for(int[] d: dirs) {
                int nx = x + d[0], ny = y + d[1];
                if(nx >= 0 && nx<n && ny>=0 && ny<n) {
                    int newTime = Math.max(time, grid[nx][ny]);
                    if(newTime < dist[nx][ny]) {
                        dist[nx][ny] = newTime;
                        pq.offer(new int[]{newTime, nx, ny});
                    }
                }
            }
        }
        return -1; // Shouldn't be hitting this if we have a valid input 
    }
}












