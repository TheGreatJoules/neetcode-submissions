class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDecrease = new LinkedList<>();
        Deque<Integer> minIncrease = new LinkedList<>();
        
        int left = 0;
        int result = 0;
        for (int r = 0; r < nums.length; r++) {
            while (!maxDecrease.isEmpty() && nums[r] > maxDecrease.peekFirst()) {
                maxDecrease.removeLast();
            }
            while (!minIncrease.isEmpty() && nums[r] < minIncrease.peekFirst()) {
                minIncrease.removeLast();
            }
            maxDecrease.addLast(nums[r]);
            minIncrease.addLast(nums[r]);
            // Violation
            while (maxDecrease.peekFirst() - minIncrease.peekFirst() > limit) {
                if (nums[left] == maxDecrease.peekFirst()) {
                    maxDecrease.removeFirst();
                }
                if (nums[left] == minIncrease.peekFirst()) {
                    minIncrease.removeFirst();
                }
                left++;
            }
            result = Math.max(result, r - left + 1);
        }
        return result;
    }
}