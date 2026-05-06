class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int[] dp = new int[intervals.length];
        int result = Integer.MIN_VALUE;
        for (int current = 0; current < intervals.length; current++) {
            dp[current] = 1;
            for (int prev = 0; prev < current; prev++) {
                if (intervals[prev][1] <= intervals[current][0]) {
                    dp[current] = Math.max(dp[current], 1 + dp[prev]);
                }
            }
            result = Math.max(result, dp[current]);
        }
        return intervals.length - result;
    }
}
