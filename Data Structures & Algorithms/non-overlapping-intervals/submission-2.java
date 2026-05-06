class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        for (int i = 1, prev = 0; i < intervals.length; i++) {
            if (intervals[prev][1] <= intervals[i][0]) {
                count++;
                prev = i;
            }
        }
        return intervals.length - count;
    }
}
