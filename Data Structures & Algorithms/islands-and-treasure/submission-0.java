class Solution {
    int[][] dirs = new int[][] {{1,0},{-1,0},{0,-1},{0,1}};
    private int INF = 2147483647;
    private int ROWS, COLS;

    public int bfs(int[][] grid, int r, int c) {
        boolean[][] visited = new boolean[ROWS][COLS];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                if (grid[row][col] == 0) {
                    return steps;
                }
                for (int[] dir : dirs) {
                    int x = row + dir[0];
                    int y = col + dir[1];
                    if (x >= 0 && x < ROWS && y >= 0 && y < COLS && !visited[x][y] && grid[x][y] != -1) {
                        visited[x][y] = true;
                        queue.offer(new int[] {x, y});
                    }
                }
            }
            steps++;
        }
        return INF;
    }

    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == INF) {
                    grid[i][j] = bfs(grid, i, j);
                }
            }
        }
    }
}
