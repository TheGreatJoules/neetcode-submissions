class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        return intervals.length - dfs(intervals, 0, Integer.MIN_VALUE);
    }
    private int dfs(int[][] intervals, int left, int right) {
        if (left == intervals.length) {
            return 0;
        }
        int result = dfs(intervals, left + 1, right);
        if (right == Integer.MIN_VALUE || intervals[right][1] <= intervals[left][0]) {
            result = Math.max(result, dfs(intervals, left + 1, left) + 1);
        }
        return result;
    }
}
