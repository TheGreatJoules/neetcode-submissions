class Solution {
    class Pair<K, V> {
        private K key;
        private V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return this.key;
        }
        public V getValue() {
            return this.value;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Integer, int[]>> maxHeap = new PriorityQueue<>((a, b) -> 
            b.getKey() - a.getKey());

        for (int[] point : points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            maxHeap.offer(new Pair<>(dist, point));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            Pair<Integer, int[]> current = maxHeap.poll();
            result[i] = current.getValue();
        }
        return result;
    }
}
