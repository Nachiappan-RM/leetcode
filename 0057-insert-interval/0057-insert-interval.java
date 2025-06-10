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

/**

Find an interval that has the start

Either Start or end or in middle

From that start point look for all the next intervals, Where start>currend or end > currend

if(start<=currend) move forward
get the end of the index get the max(currend, traversed end)

 */