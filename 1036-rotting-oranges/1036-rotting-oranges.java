/*
class Solution {
    static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    //First to check whether is there any no good oranges -> 0
    // In last we have to check wether is there any good oranges -> -1
    public int orangesRotting(int[][] grid) {
        if (!isThereGoodOranges(grid)) {
            return 0;
        }

        int min = 0;
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;
        if (n == 0)
            return 0;

        Queue<Pair> queue = new LinkedList<>();
        //All rotten oranges position
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Pair curr = queue.poll();
                int i = curr.i;
                int j = curr.j;
                // grid[i][j] = 2;
                // System.out.println("i->"+i + "j->"+j);
                if (i > 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    queue.offer(new Pair(i - 1, j));
                }
                if (j > 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    queue.offer(new Pair(i, j - 1));
                }
                if (i < m - 1 && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    queue.offer(new Pair(i + 1, j));
                }
                if (j < n - 1 && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    queue.offer(new Pair(i, j + 1));
                }
            }
            min++;
        }
        // for (int i = 0; i < grid.length; i++) {
        //     for (int j = 0; j < grid[0].length; j++) {
        //         System.out.print(grid[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        if (isThereGoodOranges(grid)) {
            return -1;
        }
        return min-1;
    }

    private boolean isThereGoodOranges(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return true;
            }
        }
        return false;
    }
}
*/

// --------- REVISION ---------
/**
TC - O(n*m)
SC - O(n*m)
 */
class Solution {
    // Multi-source BFS
    class Location {
        int x;
        int y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        } 
    }
    private final int[][] DIRECTIONS = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int time = 0;
        Queue<Location> rottenQueue = new LinkedList<>();
        int freshCount = 0;

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == 2) { //Rotten Orange
                    rottenQueue.offer(new Location(i,j));
                }else if(grid[i][j] == 1) {
                    freshCount++;;
                }
            }
        }
        while(!rottenQueue.isEmpty()) {
            int size = rottenQueue.size();
            while(size-->0) {
                Location location = rottenQueue.poll();
                for(int[] dir: DIRECTIONS) {
                    int x = location.x + dir[0];
                    int y = location.y + dir[1];
                    if(x>=0 && y>=0 && x<m && y<n && grid[x][y] == 1) {
                        rottenQueue.offer(new Location(x,y));
                        grid[x][y] = 2; //Marking it rotten
                        freshCount--;
                    }
                }
            }
            if(!rottenQueue.isEmpty()) {
                time++;
            }
        }
        return (freshCount == 0) ? time : -1;
    }
}