class Solution {
    public int lengthOfLIS(int[] nums) {
        return dfs(nums, 0, Integer.MIN_VALUE);
    }

    private int dfs(int[] nums, int i, int j) {
        if (i == nums.length) {
            return 0;
        }
        int LIS = dfs(nums, i+1, j);
        if (j == Integer.MIN_VALUE || nums[j] < nums[i]) {
            LIS = Math.max(LIS, 1 + dfs(nums, i+1, i));
        }
        return LIS;
    }
}
