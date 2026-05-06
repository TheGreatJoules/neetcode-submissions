class Solution {
    private static final int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};

    public int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int result = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        grid[i][j] = '0';
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] dir: dirs) {
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
                    queue.offer(new int[]{x, y});
                    grid[x][y] = '0';
                }
            }
        }
    }
}
