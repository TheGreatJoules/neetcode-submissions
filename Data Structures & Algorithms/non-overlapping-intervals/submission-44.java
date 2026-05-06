class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int[] memo = new int[intervals.length];
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.fill(memo, -1);
        // int max = Arrays.stream(intervals).flatMapToInt(Arrays::stream).max().orElse(0);
        return intervals.length - dfs(intervals, memo, 0);
    }

    private int dfs(int[][] intervals, int[] memo, int current) {
        if (current >= intervals.length) {
            return 0;
        }
        if (memo[current] != -1) {
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
