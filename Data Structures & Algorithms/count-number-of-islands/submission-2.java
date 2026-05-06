class Solution {
    public static int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int result = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        for (int[] dir: dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] == '1') {
                dfs(grid, visited, x, y);
            }
            
        }
    }
}
