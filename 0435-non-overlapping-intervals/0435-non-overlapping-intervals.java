/*
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) ->{
            int result = Integer.compare(a[0], b[0]);
            // if(result == 0) return Integer.compare(a[1], b[1]);
            return result;
        });
        // System.out.println(Arrays.deepToString(intervals));
        int remove = 0, length = intervals.length;
        int i=length-1;
        while(i>=0){
            int j =i-1;
            while(j>=0 && intervals[j][1]>intervals[i][0]){
                remove++;
                j--;
            }
            i = j;
        }
        return remove;
    }
}
*/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int i = intervals.length - 1;
        int remove = 0;

        while(i>=0) {
            int j = i - 1;
            //Check overlap
            while(j >=0 && intervals[j][1] > intervals[i][0]) {
                remove++;
                j--;
            }
            i = j;
        }

        return remove;
    }
}
