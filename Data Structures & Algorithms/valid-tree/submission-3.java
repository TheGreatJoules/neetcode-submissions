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
        Set<Integer> visited = new HashSet<>();
        if (!dfs(graph, visited, 0, -1)) {
            return false;
        }
        return visited.size() == n;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int node, int parent) {
        if (visited.contains(node)) {
            return false;
        }
        
        visited.add(node);

        if (!graph.containsKey(node)) {
            return true;
        }
        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) {
                continue;
            }
            if (!dfs(graph, visited, neighbor, node)) {
                return false;
            }
        }
        return true;
    }
}
