class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, 0, points.length - 1, k);
        return Arrays.copyOfRange(points, 0, k);
    }
    private void quickSelect(int[][] points, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int pivotIndex = left + (right - left) / 2;
        int partitionIndex = partition(points, left, right, pivotIndex);
        if (partitionIndex > k) {
            quickSelect(points, left, partitionIndex - 1, k);
        } else if (partitionIndex < k) {
            quickSelect(points, partitionIndex+1, right, k);
        } else {
            return;
        }
    }

    private int partition(int[][] points, int left, int right, int pivotIndex) {
        int pivotDist = points[pivotIndex][0]*points[pivotIndex][0] 
                        + points[pivotIndex][1]*points[pivotIndex][1];
        swap(points, pivotIndex, right);
        int swapIndex = left;
        for (int i = left; i < right; i++) {
            int currentDist = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            if (currentDist - pivotDist < 0) {
                swap(points, i, swapIndex);
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
