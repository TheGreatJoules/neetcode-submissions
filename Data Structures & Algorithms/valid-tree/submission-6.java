class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        Set<Integer> nodes = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, -1});
        nodes.add(0);
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int parent = current[1];
            if (!graph.containsKey(node)) {
                continue;
            }
            for (int neighbor : graph.get(node)) {
                if (neighbor == parent) {
                    continue;
                }
                if (nodes.contains(neighbor)) {
                    return false;
                }
                nodes.add(neighbor);
                queue.offer(new int[] {neighbor, node});
            }
        }
        return nodes.size() == n;
    }
}
