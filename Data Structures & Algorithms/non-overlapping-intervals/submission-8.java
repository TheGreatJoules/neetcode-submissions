class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        return intervals.length - dfs(intervals, new HashMap<>(), 0, Integer.MIN_VALUE);
    }
    private int dfs(int[][] intervals, Map<Integer, Map<Integer, Integer>> memo, int next, int prev) {
        if (next == intervals.length) {
            return 0;
        }
        if (memo.containsKey(next) && memo.get(next).containsKey(prev)) {
            return memo.get(next).get(prev);
        }
        int result = dfs(intervals, memo, next + 1, prev);
        if (prev == Integer.MIN_VALUE || intervals[prev][1] <= intervals[next][0]) {
            result = Math.max(result, dfs(intervals, memo, next + 1, next) + 1);
            
        }
        memo.computeIfAbsent(next, v -> new HashMap<>()).putIfAbsent(prev, result);
        return result;
    }
}
