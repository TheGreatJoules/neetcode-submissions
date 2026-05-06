class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, nums.length - k);
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