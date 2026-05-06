class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> monoDecrease = new LinkedList<>(); // leading max
        Deque<Integer> monoIncrease = new LinkedList<>(); // leading min
        int left = 0;
        int result = 0;
        for (int r = 0; r < nums.length; r++) {
            while (!monoIncrease.isEmpty() && nums[r] < monoIncrease.peekFirst()) {
                // evict, find new min
                monoIncrease.removeLast();
            }
            while (!monoDecrease.isEmpty() && nums[r] > monoDecrease.peekFirst()) {
                monoDecrease.removeLast();
            }
            monoIncrease.addLast(nums[r]);
            monoDecrease.addLast(nums[r]);
            while (monoDecrease.peekFirst() - monoIncrease.peekFirst() > limit) {
                if (nums[left] == monoDecrease.peekFirst()) {
                    monoDecrease.removeFirst();
                }
                if (nums[left] == monoIncrease.peekFirst()) {
                    monoIncrease.removeFirst();
                }
                left++;
            }
            result = Math.max(result, r - left + 1);
        }
        return result;
    }
}