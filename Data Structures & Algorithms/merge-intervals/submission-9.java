class Solution {
    public int[][] merge(int[][] intervals) {
        int max = Arrays.stream(intervals)
                        .flatMapToInt(Arrays::stream).max()
                        .orElse(0);
        int[] dp = new int[max + 1];
        boolean zeros = false;
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start == 0 && end == 0) {
                zeros = true;
            }
            System.out.println(start + ", " + end);
            dp[start] = Math.max(dp[start], end);
        }
        int right = 0;
        int intervalStart = Integer.MIN_VALUE;
        int intervalEnd = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] != 0 || zeros) {
                intervalStart = intervalStart != Integer.MIN_VALUE ? intervalStart : i;
                intervalEnd = Math.max(intervalEnd, dp[i]);
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
