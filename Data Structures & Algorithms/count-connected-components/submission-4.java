class Solution {
    public int countComponents(int n, int[][] edges) {
        if (edges.length == 0) {
            return n;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        int result = 0;
        Set<Integer> nodes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!nodes.contains(i)) {
                dfs(graph, nodes, i);
                result++;
            }
        }
        return result;
    }

    private void dfs(Map<Integer, List<Integer>> graph, Set<Integer> nodes, int i) {
        nodes.add(i);
        if (!graph.containsKey(i)) {
            return;
        }

        for (int neighbor : graph.get(i)) {
            if (!nodes.contains(neighbor)) {
                dfs(graph, nodes, neighbor);
            } 
        }
    }
}
