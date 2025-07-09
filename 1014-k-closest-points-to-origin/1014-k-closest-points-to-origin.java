/*
class Solution {
    class PointDistance{
        int[] point;
        double distance;
        public PointDistance(int[] point, double distance){
            this.point = point;
            this.distance = distance;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<PointDistance> maxHeap =  new PriorityQueue<>(
            new Comparator<>(){
                @Override
                public int compare(PointDistance p1, PointDistance p2){
                    return Double.compare(p2.distance, p1.distance);
                }
            }
        );

        for(int[] point: points){
            int x1 = point[0];
            int y1 = point[1];
            int x2 = 0;
            int y2 = 0;
            double dist = Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
            if(maxHeap.size()<k){
                maxHeap.offer(new PointDistance(point, dist));
            }else if(maxHeap.peek().distance>dist){
                maxHeap.poll();
                maxHeap.offer(new PointDistance(point, dist));
            }
        }
        int[][] kClosestPoints = new int[k][];
        for(int i=0; i<k; i++){
            kClosestPoints[i] = maxHeap.poll().point;
        }
        return kClosestPoints;
    }
}
*/

// ----------- REVISION -----------
class Solution {
    class Point {
        int x;
        int y;
        int distance;

        Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.distance = d;
        }
    }

    // closest -> list of max distance heap of k
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b.distance, a.distance));
        for(int p[]: points){
            int dis = (int)Math.pow(p[0]-0, 2) + (int)Math.pow(p[1]-0, 2);
            if(maxHeap.size() < k){
                Point point = new Point(p[0], p[1], dis);
                maxHeap.offer(point);
            }else if(maxHeap.size() == k && maxHeap.peek().distance>dis){
                Point point = new Point(p[0], p[1], dis);
                maxHeap.poll();
                maxHeap.offer(point);
            }
        }

        int[][] result = new int[k][2];
        int i =0;
        while(maxHeap.size()>0){
            Point point = maxHeap.poll();
            int[] p = new int[2];
            p[0] = point.x;
            p[1] = point.y;
            result[i++] = p;
        }
        return result;
    }
}