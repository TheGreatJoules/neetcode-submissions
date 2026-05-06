class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect2(nums, 0, nums.length-1, nums.length - k);
    }

    private int quickSelect2(int[] nums,  int left, int right, int k) {
        int mid = left + (right - left) / 2;
        int pivotValue = nums[mid];
        int pivotIndex = left;
        swap(nums, mid, right);
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(nums, right, pivotIndex);
        if (pivotIndex > k) {
            return quickSelect2(nums, left, pivotIndex-1, k);
        } else if (pivotIndex < k) {
            return quickSelect2(nums, pivotIndex+1, right, k);
        } else {
            return nums[pivotIndex];
        }
        
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }




















    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivotValue = nums[right];
        int ptr = left;
        for (int i = left; i < right; i++) {
            if (nums[i] <= pivotValue) {
                int temp = nums[ptr];
                nums[ptr] = nums[i];
                nums[i] = temp;
                ptr++;
            }
        }
        int temp = nums[ptr];
        nums[ptr] = nums[right];
        nums[right] = temp;

        if (ptr > k) {
            return quickSelect(nums, left, ptr-1, k);
        } else if (ptr < k) {
            return quickSelect(nums, ptr+1, right, k);
        } else {
            return nums[ptr];
        }
        
    }
}