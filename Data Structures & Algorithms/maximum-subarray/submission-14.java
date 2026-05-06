class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
