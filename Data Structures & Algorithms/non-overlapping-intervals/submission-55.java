class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int overlapCount = 0;
        int nonOverlapCount = 0;
        int prevEndInterval = 0;
        for (int current = 0; current < intervals.length; current++) {
            if (prevEndInterval == 0 || prevEndInterval <= intervals[current][0]) {
                prevEndInterval = intervals[current][1];
            } else {
                overlapCount++;
                prevEndInterval = Math.min(prevEndInterval, intervals[current][1]);
            }
        }
        return overlapCount;
    }
}
