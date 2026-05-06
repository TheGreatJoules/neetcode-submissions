class Solution {
    int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];
        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pacific, heights);
            dfs(ROWS-1, c, atlantic, heights);
        }

        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pacific, heights);
            dfs(r, COLS-1, atlantic, heights);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true;
        for (int[] dir : dirs) {
            int x = r + dir[0];
            int y = c + dir[1];
            if (x >= 0 && x < heights.length && y >= 0 && y < heights[0].length && !ocean[x][y] && heights[x][y] >= heights[r][c]) {
                dfs(x, y, ocean, heights);
            }
        }
    }
}
