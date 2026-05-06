class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> store = new HashSet<>();
        for (int num : nums) {
            store.add(num);
        }
        for (int num : nums) {
            int streak = 0;
            int current = num;
            while (store.contains(current)) {
                streak++;
                current++;
            }
            result = Math.max(result, streak);
        }
        return result;
    }
}
