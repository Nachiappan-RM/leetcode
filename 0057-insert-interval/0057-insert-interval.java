/*
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new ArrayList<>();
        
        int ind = 0;
        int n = intervals.length;

        while(ind<n && newInterval[0]>intervals[ind][1]){
            resultList.add(intervals[ind]);
            ind++;
        }
        
        while(ind<n && newInterval[1]>=intervals[ind][0]){
            newInterval[0] = Math.min(intervals[ind][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[ind][1], newInterval[1]);
            ind++;
        }

        resultList.add(newInterval);

        while(ind<n){
            resultList.add(intervals[ind]);
            ind++;
        }
        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
*/
/**

Find an interval that has the start

Either Start or end or in middle

From that start point look for all the next intervals, Where start>currend or end > currend

if(start<=currend) move forward
get the end of the index get the max(currend, traversed end)

 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;
        int newStart = newInterval[0], newEnd = newInterval[1];

        //Phase 1: add all intervals that end before the new interval starts
        while(i<n && intervals[i][1] < newStart) {
            result.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        //Phase 2: merge all the overlapping intervals
        while(i<n && intervals[i][0] <= newEnd) {
            newStart = Math.min(newStart, intervals[i][0]);
            newEnd = Math.max(newEnd, intervals[i][1]);
            i++;
        }

        result.add(new int[]{newStart, newEnd});

        //Phase 3: append the rest of the intervals
        while( i < n) {
            result.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        //converting it back to a 2D array
        return result.toArray(new int[result.size()][]);
    }
}

//Running through testcases like below,
// [[1,3],[6,9]]

