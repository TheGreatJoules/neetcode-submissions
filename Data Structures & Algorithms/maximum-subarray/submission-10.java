class Solution {
    public int maxSubArray(int[] nums) {
        int left = 0;
        int sum = nums[left];
        int result = sum;
        int right = left + 1;
        while (right < nums.length) {
            int current = sum + nums[right];
            if (nums[right] <= current) {
                sum += nums[right];
            } else {
                sum = nums[right];
                left = right;
            }
            result = Math.max(result, sum);
            right++;
        }
        return result;
    }
}
