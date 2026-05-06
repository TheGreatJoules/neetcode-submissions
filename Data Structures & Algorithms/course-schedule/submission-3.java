class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            indegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int result = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result += 1;
            for (int item : adj.get(current)) {
                indegree[item]--;
                if (indegree[item] == 0) {
                    queue.offer(item);
                }
            }
        }
        return result == numCourses;
    }
}
