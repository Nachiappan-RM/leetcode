
// class Solution {
//     public int[][] merge(int[][] intervals) {

//         /*
//             Sort based on index 0 of every element - O(nlogn)
//             Run overlapping algorithm find overall of end(i) and compare with upcoming start(i+1)
//         */

//         sort(intervals, 0, intervals.length-1); //O(nlogn)

//         // print2D(intervals);
        
//         // int[][] res = new int[intervals.length][2];
//         // res[0] = intervals[0]; // Assign first interval to res
//         List<int[]> mergedIntervals = new ArrayList<>();
//         mergedIntervals.add(intervals[0]);
//         int interval = 0;
//         for(int i=1; i<intervals.length; i++){
//             int[] currentInterval = intervals[i];
//             int[] lastInterval = mergedIntervals.get(mergedIntervals.size() - 1);

//             if (lastInterval[1] >= currentInterval[0]) {
//                 lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
//             } else {
//                 mergedIntervals.add(currentInterval);
//             }
//             // if(res[interval][1]>=intervals[i][0]){
//             //     res[interval][1] = intervals[i][1];
//             // }else{
//             //     res[++interval] = intervals[i];
//             // }
//         }

//         // Convert List<int[]> to int[][]
//         int[][] res = new int[mergedIntervals.size()][2];
//         for (int i = 0; i < mergedIntervals.size(); i++) {
//             res[i] = mergedIntervals.get(i);
//         }

//         return res;
//     }

//     private static void sort(int[][] intervals, int l, int r){
//         if(l>r){
//             return;
//         }
//         //Quick sort
//         int pivotInd = partition(intervals, l, r);
//         sort(intervals, l, pivotInd-1);
//         sort(intervals, pivotInd+1, r);
//     }

//     private static int partition(int[][] intervals, int l, int r){
//         int pivotInd = l;

//         for(int i=l; i<r; i++){
//             if(intervals[i][0]<intervals[r][0]){
//                 swapIn2D(intervals, i, pivotInd++);
//             }
//         }
//         swapIn2D(intervals, r, pivotInd);
//         return pivotInd;
//     }

//     private static void swapIn2D(int[][] intervals, int i, int p){
//         int[] temp = intervals[i];
//         intervals[i] = intervals[p];
//         intervals[p] = temp;
//     }

//     private static void print2D(int mat[][])
//     {
//         // Loop through all rows
//         for (int[] row : mat)
 
//             // converting each row as string
//             // and then printing in a separate line
//             System.out.println(Arrays.toString(row));
//     }
// }

/**
Brute force,
- Repeatedly comparing each interval with every other interval and merge the overlapping ones. Keep repeating this until no more merges can happen
Time : O(n^3) -> Every merge have to recheck all pairs, there could be O(n) merges, each checking O(n^2) pairs.
Space : O(n) -> store intervals in a list


Optimized Approach,
- First Sort based on start time, then iterating through them, merging as we go.

Time - O(n)
Space - O(n)

*/
class Solution {
    public int[][] merge(int[][] intervals) {
        // If there no intervals, return empty array
        if(intervals.length == 0) {
            return new int[0][];
        }

        //sort intervals by start time
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0]; //compare based of start time
            }
        });

        List<int[]> result = new ArrayList<>();

        //Add the first interval to result
        result.add(new int[]{intervals[0][0], intervals[0][1]});

        //Loop through the rest of the intervals
        for(int i=1; i<intervals.length; i++) {
            int[] last = result.get(result.size() - 1);
            int[] current = intervals[i]; //current interval

            // if current interval overlaps with the last, merge them
            if(current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                //No overlap, add current interval to the result
                result.add(new int[]{current[0], current[1]});
            }
        }

        //convert result list to array
        return result.toArray(new int[result.size()][]);
    }
}