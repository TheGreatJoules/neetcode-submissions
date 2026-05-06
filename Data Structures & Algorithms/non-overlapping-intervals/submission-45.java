class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int[] memo = new int[intervals.length];
        return intervals.length - dfs(intervals, 0);
    }

    private int dfs(int[][] intervals, int current) {
        if (current >= intervals.length) {
            return 0;
        }
        int result = 1;
        for (int next = current + 1; next < intervals.length; next++) {
            if (intervals[current][1] <= intervals[next][0]) {
                result = Math.max(result, 1 + dfs(intervals, next));
            }
        }
        return result;
    }
}
