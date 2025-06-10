class DetectSquares {
    //{x : {y : count }}
    //{2: {3:1, 2:2}}
    //This is (2,3),(2,2),(2,2) (2 points for 2,2 thats why its 2:2)
    Map<Integer, Map<Integer, Integer>> pointsCount;

    public DetectSquares() {
        pointsCount = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        if (!pointsCount.containsKey(x)) {
            pointsCount.put(x, new HashMap<Integer, Integer>());
        }
        if (pointsCount.get(x).containsKey(y)) {
            pointsCount.get(x).put(y, pointsCount.get(x).get(y) + 1);
        } else {
            pointsCount.get(x).put(y, 1);
        }
    }

    /**
    (x1,y) __ (x1, y1)
      |  |
    (x,y) |__| (x, y1)
    
    Only diagonal points.
     */
    public int count(int[] point) {
        int n = pointsCount.size();
        int count = 0;
        int x = point[0];
        int y = point[1];
        // System.out.println(pointsCount);
        for (Map.Entry<Integer, Map<Integer, Integer>> xcord : pointsCount.entrySet()) {
            int x1 = xcord.getKey();
            for (Map.Entry<Integer, Integer> ycord : pointsCount.get(x1).entrySet()) {
                int y1 = ycord.getKey();
                // Check if (x1, y1) forms a diagonal with (x, y)
                if (Math.abs(x - x1) != Math.abs(y - y1) || y1 == y)
                    continue;

                // Count occurrences of the 3 other points needed
                int count1 = pointsCount.getOrDefault(x1, new HashMap<>()).getOrDefault(y, 0); // (x1, y)
                int count2 = pointsCount.getOrDefault(x, new HashMap<>()).getOrDefault(y1, 0); // (x, y1)
                int count3 = pointsCount.getOrDefault(x1, new HashMap<>()).getOrDefault(y1, 0); // (x1, y1)

                count += count1 * count2 * count3;
            }
        }
        return count;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */