class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int nonOverlapCount = 0;
        int prevEndInterval = Integer.MIN_VALUE;
        for (int current = 0; current < intervals.length; current++) {
            if (prevEndInterval == Integer.MIN_VALUE || prevEndInterval <= intervals[current][0]) {
                nonOverlapCount += 1;
                prevEndInterval = intervals[current][1];
            }
        }
        return intervals.length - nonOverlapCount;
    }
}
