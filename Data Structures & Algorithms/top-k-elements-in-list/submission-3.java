class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            heap.offer(new Pair<>(entry.getValue(), entry.getKey()));
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll().getValue();
        }
        return result;
    }
}
