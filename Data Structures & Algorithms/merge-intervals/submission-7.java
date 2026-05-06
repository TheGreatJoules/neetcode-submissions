class Solution {
    public int[][] merge(int[][] intervals) {
        int max = Arrays.stream(intervals)
                        .flatMapToInt(Arrays::stream).max()
                        .orElse(0);
        int[] dp = new int[max + 1];
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            dp[start] = Math.max(dp[start], end + 1);
        }
        int right = 0;
        int intervalStart = Integer.MIN_VALUE;
        int intervalEnd = -1;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] != 0) {
                intervalStart = intervalStart != Integer.MIN_VALUE ? intervalStart : i;
                intervalEnd = Math.max(intervalEnd, dp[i] - 1);
            }
            if (intervalEnd == i) {
                intervals[right++] = new int[] {intervalStart, intervalEnd};
                intervalEnd = Integer.MIN_VALUE;
                intervalStart = Integer.MIN_VALUE;
            }
        }
        if (intervalStart != Integer.MIN_VALUE) {
            intervals[right++] = new int[] {intervalStart, intervalEnd};
        }
        if (intervals.length == right) {
            return intervals;
        }
        int[][] result = new int[right][];
        for (int i = 0; i < right; i++) {
            result[i] = intervals[i];
        }
        return result;
    }
}
