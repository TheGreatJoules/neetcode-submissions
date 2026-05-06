class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = nums[0];
        while (left <= right) {
            if (nums[left] < nums[right]) {
                result = Math.min(result, nums[left]);
                return result;
            }
            int mid = left + (right - left) / 2;
            result = Math.min(result, nums[mid]);
            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return result;
    }
}
