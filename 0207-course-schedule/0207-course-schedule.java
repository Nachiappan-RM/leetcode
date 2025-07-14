// class Solution {
//     // //Cycle detection - BFS
//     // public boolean canFinish(int numCourses, int[][] prerequisites) {
        
//     //     int[] indeg = new int[numCourses]; // To Get this info so that we can start the cycle detection

//     //     HashMap<Integer, List<Integer>> graph = new HashMap<>();
//     //     for(int[] prereq: prerequisites){
//     //         if(!graph.containsKey(prereq[1])){
//     //             graph.put(prereq[1], new ArrayList());
//     //         }
//     //         graph.get(prereq[1]).add(prereq[0]);
//     //         indeg[prereq[0]]++; //increasing the inward deg
//     //     }

//     //     // Creating edge from course -> prereq
        
//     //     //BFS
//     //     Queue<Integer> queue = new LinkedList<>();
//     //     int completedCourse = 0;

//     //     for(int i=0; i<numCourses; i++){
//     //         if(indeg[i] == 0){
//     //             queue.offer(i);
//     //         }
//     //     }

//     //     while(queue.size()>0){
//     //         int curr = queue.poll();
//     //         completedCourse++;
//     //         for(int course : graph.getOrDefault(curr, new ArrayList<Integer>())){
//     //             indeg[course]--;
//     //             if(indeg[course] == 0){
//     //                 queue.offer(course);
//     //             }
//     //         }
//     //     }

        
//     //     return completedCourse == numCourses;
//     // }
    
//     //Cycle detections - Kahn's Algorithm / Topological sort
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         int[] inDeg = new int[numCourses];

//         HashMap<Integer, List<Integer>> graph = new HashMap<>();
//         for(int[] pre : prerequisites){
//             graph.computeIfAbsent(pre[1], adj -> new ArrayList<>()).add(pre[0]);
//             inDeg[pre[0]]++;
//         }
//         Queue<Integer> queue = new LinkedList<>();
//         int traversedCourses = 0;

//         for(int i=0; i<numCourses; i++){
//             if(inDeg[i] == 0){
//                 queue.offer(i);
//             }
//         }
//         while(!queue.isEmpty()){
//             int curr = queue.poll();
//             traversedCourses++;
//             if(graph.get(curr) == null) continue;

//             for(int adj: graph.get(curr)){
//                 inDeg[adj]--;
//                 if(inDeg[adj] == 0) queue.offer(adj);
//             }
//         }

//         return traversedCourses==numCourses;
//     }
// }

// -------------- REVISION ----------------
/**
Question is like -> There exsist any topological order for this graph?
Topological sort using BFS and in degree.
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if(numCourses <= 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
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

        int traversedCourses = 0;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            traversedCourses++;
            for(int neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return traversedCourses == numCourses;
    }
}