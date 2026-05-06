class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }
        int target = newInterval[0];
        int left = 0;
        int right = intervals.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid][1] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < left; i++) {
            result.add(intervals[i]);
        }
        while(left < intervals.length && intervals[left][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[left][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[left][1]);
            left++;
        }
        result.add(newInterval);
        for (int i = left; i < intervals.length; i++) {
            result.add(intervals[i]);
        }
        // LinkedList<int[]> merged = new LinkedList<>();
        // for (int[] interval : result) {
        //     if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
        //         merged.add(interval);
        //     } else {
        //         merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
        //     }
        // }
        // return merged.toArray(new int[merged.size()][]);
        return result.toArray(new int[result.size()][]);
    }
}
