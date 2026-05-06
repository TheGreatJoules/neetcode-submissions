class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, 0, points.length - 1, k);
        return Arrays.copyOfRange(points, 0, k);
    }
    public void quickSelect(int[][] points, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int pivot = left + (right - left)/ 2;
        int partitionIndex = partition(points, left, right, pivot, k);
        if (partitionIndex > k) {
            quickSelect(points, left, partitionIndex-1, k);
        } else if (partitionIndex < k) {
            quickSelect(points, partitionIndex+1, right, k);
        } else {
            return;
        }
    }
    private int partition(int[][] points, int left, int right, int pivot, int k) {
        int pivotDiff = points[pivot][0]*points[pivot][0] + points[pivot][1]*points[pivot][1];
        swap(points, pivot, right);
        int swapIndex = left;
        for (int i = left; i < right; i++) {
            int currentDiff = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            if (currentDiff < pivotDiff) {
                swap(points, swapIndex, i);
                swapIndex++;
            }
        }
        swap(points, swapIndex, right);
        return swapIndex;
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
