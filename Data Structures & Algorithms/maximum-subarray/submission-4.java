class Solution {
    public int maxSubArray(int[] nums) {
        int right = 0;
        int runningSum = nums[right];
        int result = runningSum;
        int left = right++;
        while (right < nums.length) {
            int currentSum = runningSum + nums[right];
            if (nums[right] > currentSum) {
                runningSum = nums[right];
                result = Math.max(result, runningSum);
                left = right++;
                continue;
            }
            result = Math.max(result, currentSum);
            runningSum += nums[right++];
        }
        System.out.println(left + ", " + right);
        return result;
    }
}
