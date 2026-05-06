class Solution {
    public int[][] merge(int[][] intervals) {
        int max = Arrays.stream(intervals)
                        .flatMapToInt(Arrays::stream).max()
                        .orElse(0);
        int min = Arrays.stream(intervals)
                        .flatMapToInt(Arrays::stream).min()
                        .orElse(0);
        int[] dp = new int[max + 1];
        boolean zeros = false;
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start == 0 && end == 0) {
                zeros = true;
            }
            dp[start] = Math.max(dp[start], end);
        }
        int intervalStart = Integer.MAX_VALUE;
        int intervalEnd = Integer.MIN_VALUE;
        LinkedList<int[]> result = new LinkedList<>();
        if (zeros) {
            result.add(new int[] {0 , 0});
        }
        for (int i = min; i < dp.length; i++) {
            if (dp[i] != 0) {
                intervalStart = Math.min(intervalStart, i);
                intervalEnd = Math.max(intervalEnd, dp[i]);
            }
            if (intervalEnd == i) {
                result.add(new int[] {intervalStart, intervalEnd});
                intervalStart = Integer.MAX_VALUE;
                intervalEnd = Integer.MIN_VALUE;
            }
        }
        if (intervalStart != Integer.MAX_VALUE) {
            result.add(new int[] {intervalStart, intervalEnd});
        }
        return result.toArray(new int[result.size()][]);
    }
}