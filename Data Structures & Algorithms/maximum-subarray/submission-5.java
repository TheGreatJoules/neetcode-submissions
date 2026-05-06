class Solution {
    public int maxSubArray(int[] nums) {
        int right = 0;
        int sum = nums[right];
        int result = sum;
        int left = right++;
        while (right < nums.length) {
            int currentSum = sum + nums[right];
            if (nums[right] > currentSum) {
                sum = nums[right];
                result = Math.max(result, sum);
                left = right++;
                continue;
            }
            result = Math.max(result, currentSum);
            sum += nums[right++];
        }
        System.out.println(left + ", " + right);
        return result;
    }
}
