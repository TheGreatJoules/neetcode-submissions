class Solution {
    class Pair<K, V> {
        private final K key;
        private final V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Integer, int[]>> minHeap = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        for (int[] point : points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            minHeap.offer(new Pair<>(dist, point));
        }
        int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            Pair<Integer, int[]> current = minHeap.poll();
            result[i] = current.getValue();
        }
        return result;
    }
}
