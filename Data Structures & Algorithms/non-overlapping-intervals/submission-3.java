class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        return intervals.length - dfs(intervals, 0, -1);
    }
    private int dfs(int[][] intervals, int index, int prev) {
        if (index == intervals.length) {
            return 0;
        }
        int result = dfs(intervals, index + 1, prev);
        if (prev == - 1 || intervals[prev][1] <= intervals[index][0]) {
            result = Math.max(result, dfs(intervals, index + 1, index) + 1);
        }
        return result;
    }
}
