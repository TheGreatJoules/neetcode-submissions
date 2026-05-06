class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int prevEndInterval = intervals[0][1];
        int nonOverlapCount = 1;
        for (int current = 1; current < intervals.length; current++) {
            if (prevEndInterval <= intervals[current][0]) {
                nonOverlapCount++;
                prevEndInterval = intervals[current][1];
            }
            // result = Math.max(result, dp[current]);
        }
        return intervals.length - nonOverlapCount;
    }
}
