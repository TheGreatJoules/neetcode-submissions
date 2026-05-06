class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int max = Arrays.stream(intervals).flatMapToInt(Arrays::stream).max().orElse(0);
        return intervals.length - dfs(intervals, new int[intervals.length+1][max+1], 0, Integer.MIN_VALUE);
    }
    private int dfs(int[][] intervals, int[][] memo, int next, int prev) {
        if (next >= intervals.length || prev >= intervals.length) {
            return 0;
        }
        
        if (prev < 0) {
            Arrays.fill(memo[next], Integer.MIN_VALUE);
        } else {
            if (memo[next][prev] != Integer.MIN_VALUE) {
                return memo[next][prev];
            }
        }
        int result = dfs(intervals, memo, next + 1, prev);
        if (prev < 0 || intervals[prev][1] <= intervals[next][0]) {
            result = Math.max(result, dfs(intervals, memo, next + 1, next) + 1); 
        } else {
            memo[next][prev] = result;
        }
        return result;
    }
}
