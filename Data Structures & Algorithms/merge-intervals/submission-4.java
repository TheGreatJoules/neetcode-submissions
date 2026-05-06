class Solution {
    public int[][] merge(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);
        }
        System.out.println(map);
        int activeIntervalCnt = 0;
        int leftInterval = 0;
        int rightInterval = 0;
        List<int[]> result = new ArrayList<>();
        for (int point : map.keySet()) {
            if (activeIntervalCnt == 0) {
                leftInterval = point;
            }
            activeIntervalCnt += map.get(point);
            if (activeIntervalCnt == 0) {
                rightInterval = point;
                result.add(new int[] {leftInterval, rightInterval});
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
