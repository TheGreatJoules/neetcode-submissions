class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int index = 0;
        List<int[]> result = new ArrayList<>();
        while (index < intervals.length && intervals[index][1] < newInterval[0]) {
            result.add(intervals[index++]);
        }
        while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
            index++;
        }
        result.add(newInterval);
        while (index < intervals.length) {
            result.add(intervals[index++]);
        }
        return result.toArray(new int[result.size()][]);
    }
}
