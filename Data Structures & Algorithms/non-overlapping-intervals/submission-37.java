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
        if (prev > 0 && memo[current][prev] != Integer.MIN_VALUE) {
            return memo[current][prev];
        }
        int result = dfs(intervals, memo, current + 1, prev);
        if (prev < 0 ) {
            Arrays.fill(memo[current], Integer.MIN_VALUE);
            return result = Math.max(result, 1 + dfs(intervals, memo, current+1, current));
        } else if (intervals[prev][1] <= intervals[current][0]) {
            return result = Math.max(result, 1 + dfs(intervals, memo, current+1, current));
        }
        
        return memo[current][prev] = result;
    }
}
