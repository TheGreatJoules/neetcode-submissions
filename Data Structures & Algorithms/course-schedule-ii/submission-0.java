class Solution {
    List<Integer> result;
    Map<Integer, List<Integer>> adj;
    int[] indegree;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.computeIfAbsent(i, v -> new ArrayList<>());
        }
        indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }
        result = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                dfs(i);
            }
        }
        if (result.size() != numCourses) {
            return new int[0];
        }
        return result.stream()
                    .mapToInt(Integer::valueOf)
                    .toArray();
    }

    private void dfs(int node) {
        result.add(node);
        indegree[node]--;
        for (int course : adj.get(node)) {
            indegree[course]--;
            if (indegree[course] == 0) {
                dfs(course);
            }
        }
    }
}
