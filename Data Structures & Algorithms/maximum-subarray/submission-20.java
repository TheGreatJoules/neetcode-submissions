class Solution {
    int result = Integer.MIN_VALUE;
    int[] dp;
    public int maxSubArray(int[] nums) {
        dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        int value = dfs(nums, nums.length-1);
        return Math.max(result, value);    
    }

    public int dfs(int[] nums, int i) {
        if (i == 0) {
            return nums[0];
        }
        if (dp[i] != Integer.MAX_VALUE) {
            return dp[i];
        }
        int current = dfs(nums, i-1);
        result = Math.max(result, current);
        // return (current < 0) ? nums[i] : current + nums[i];
        return dp[i] = (current < 0) ? nums[i] : current + nums[i];
    }
}
