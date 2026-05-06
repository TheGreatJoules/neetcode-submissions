class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> current = new ArrayList<>();
        for (int num : nums) {
            int index = binarySearch(current, num);
            if (index < 0) {
                index = -(index + 1);
            }
            if (index == current.size()) {
                current.add(num);
            } else {
                current.set(index, num);
            }
        }
        return current.size();
    }

    private int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() -1;
        while (left <= right) {
            int mid = left + (right- left)/2;
            int pivotValue = list.get(mid);
            if (target == pivotValue) {
                return mid;
            } else if (target < pivotValue) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -(left + 1);
    }
}
