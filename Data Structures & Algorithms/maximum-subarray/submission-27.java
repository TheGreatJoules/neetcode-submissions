class Solution {
    public int maxSubArray(int[] nums) {
        int[] memo = new int[nums.length];
        int result = nums[0];
        memo[0] = result;
        for (int i = 1; i < nums.length; i++) {
            memo[i] = Math.max(nums[i], nums[i] + memo[i-1]);
            result = Math.max(result, memo[i]);
        }
        return result;
    }
}
