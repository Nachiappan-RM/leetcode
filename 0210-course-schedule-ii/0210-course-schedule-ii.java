/*
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDeg = new int[numCourses];

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            graph.computeIfAbsent(pre[1], adj -> new ArrayList<>()).add(pre[0]);
            inDeg[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int traversedCourses = 0;
        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result[traversedCourses++] = curr;
            if (graph.get(curr) == null)
                continue;

            for (int adj : graph.get(curr)) {
                inDeg[adj]--;
                if (inDeg[adj] == 0)
                    queue.offer(adj);
            }
        }

        return (traversedCourses == numCourses) ? result : new int[0];
    }
}
*/


class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0 || prerequisites == null) {
            return new int[0];
        }

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        
        for(int[] edge : prerequisites) {
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            inDegree[edge[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i =0 ; i<numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int traversedCourses = 0;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            result[traversedCourses++] = curr;
            for(int neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if(traversedCourses == numCourses) {
            return result;
        }

        return new int[0];
    }
}