class Solution {
    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length-1);
    }

    private int binarySearch(int[] nums, int left, int right) {
        int mid = left + (right- left) / 2;
        if (left == right) {
            return left;
        }
        if (0 < mid && mid < nums.length-1 && nums[mid+1] < nums[mid] && nums[mid] > nums[mid-1]) {
            return mid;
        } else if (mid < nums.length -1 && nums[mid] < nums[mid+1]) {
            return binarySearch(nums, mid +1, right);
        } else {
            return binarySearch(nums, left, mid);
        }
    }
}