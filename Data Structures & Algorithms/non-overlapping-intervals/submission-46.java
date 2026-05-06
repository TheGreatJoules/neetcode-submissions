class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int[] memo = new int[intervals.length];
        Arrays.fill(memo, Integer.MIN_VALUE);
        return intervals.length - dfs(intervals, memo, 0);
    }

    private int dfs(int[][] intervals, int[] memo, int current) {
        if (current >= intervals.length) {
            return 0;
        }
        if (memo[current] != Integer.MIN_VALUE) {
            return memo[current];
        }
        int result = 1;
        for (int next = current + 1; next < intervals.length; next++) {
            if (intervals[current][1] <= intervals[next][0]) {
                result = Math.max(result, 1 + dfs(intervals, memo, next));
            }
        }
        memo[current] = result;
        return result;
    }
}
