class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int currentMin = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            currentMin = Math.min(currentMin, prices[i]);
            result = Math.max(result, prices[i] - currentMin);
        }
        return result;
    }
}
