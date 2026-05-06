class Solution {
    Map<Integer, List<Integer>> graph;
    Set<Integer> visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean result = false;
        graph = new HashMap<>();
        visited = new HashSet<>();
        for (int [] pre : prerequisites) {
            graph.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
        }
        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course) {
        if (visited.contains(course)) {
            return false;
        }
        if (!graph.containsKey(course)) {
            return true;
        }
        if (graph.get(course).isEmpty()) {
            return true;
        }
        visited.add(course);
        for (int pre : graph.get(course)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visited.remove(course);
        graph.put(course, new ArrayList<>());
        return true;
    }
}
