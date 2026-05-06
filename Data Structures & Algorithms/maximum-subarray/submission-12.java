class Solution {
    public int maxSubArray(int[] nums) {
        int[][] dp = new int[nums.length+1][2];
        dp[0][1] = dp[0][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][1] = Math.max(nums[i], nums[i] + dp[i-1][1]);
            dp[i][0] = Math.max(dp[i-1][0], dp[i][1]);
        }
        return dp[nums.length-1][0];
    }
}
