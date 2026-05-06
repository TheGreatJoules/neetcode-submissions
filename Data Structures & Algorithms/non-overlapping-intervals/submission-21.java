class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        return intervals.length - dfs(intervals, new int [intervals.length+1][intervals[0].length + 1], 0, Integer.MIN_VALUE);
    }
    private int dfs(int[][] intervals, int[][] memo, int next, int prev) {
        if (next >= intervals.length || prev >= intervals.length) {
            return 0;
        }
        int result = dfs(intervals, memo, next + 1, prev);
        if (prev == Integer.MIN_VALUE || intervals[prev][1] <= intervals[next][0]) {
            result = Math.max(result, dfs(intervals, memo, next + 1, next) + 1); 
        }
        return result;
    }
}
