class Solution {
    public int maxSubArray(int[] nums) {
        int[][] dp = new int[nums.length+1][2];
        dp[0][1] = dp[0][0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][1] = Math.max(nums[i], nums[i] + dp[i-1][1]);
            result = Math.max(result, dp[i][1]);
        }
        return result;
    }
}
