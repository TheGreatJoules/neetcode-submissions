class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int max = Arrays.stream(intervals).flatMapToInt(Arrays::stream).max().orElse(0);
        return intervals.length - dfs(intervals, new int[intervals.length+1][max+1], 0, Integer.MIN_VALUE);
    }

    private int dfs(int[][] intervals, int[][] memo, int current, int prev) {
        if (current >= intervals.length || prev >= intervals.length) {
            return 0;
        }
        if (prev >= 0 && memo[current][prev] != Integer.MIN_VALUE) {
            return memo[current][prev];
        }
        Arrays.fill(memo[current], Integer.MIN_VALUE);
        int resultCurrent = dfs(intervals, memo, current+1, prev);
        if (prev < 0 || intervals[prev][1] <= intervals[current][0]) {
            resultCurrent = Math.max(resultCurrent, 1 + dfs(intervals, memo, current+1, current));
        }
        if (prev >= 0) {
            memo[current][prev] = resultCurrent;
        }
        return resultCurrent;
    }
}
