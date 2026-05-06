class Solution {
    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length-1);
    }

    private int binarySearch(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = left + (right - left) / 2;
        if (mid > 0 && nums[mid] < nums[mid-1]) {
            return binarySearch(nums, left, mid-1);
        } else if (mid < nums.length - 1 && nums[mid] < nums[mid+1]) {
            return binarySearch(nums, mid+1, right);
        } else {
            return mid;
        }
    }
}