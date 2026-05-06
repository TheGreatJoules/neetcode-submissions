class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }
        int n = intervals.length;
        int target = newInterval[0];
        int left = 0;
        int right = n - 1;
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

        return result.toArray(new int[result.size()][]);
    }
}
