class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        return intervals.length - dfs(intervals, 0, -1);
    }
    private int dfs(int[][] intervals, int index, int prev) {
        if (index == intervals.length) {
            return 0;
        }
        int left = dfs(intervals,  index + 1, prev);
        int right = Integer.MIN_VALUE;
        if(prev == -1 || intervals[prev][1] <= intervals[index][0]) {
            right = dfs(intervals, index + 1, index) + 1;
        }
        return Math.max(left, right);
    }
}
