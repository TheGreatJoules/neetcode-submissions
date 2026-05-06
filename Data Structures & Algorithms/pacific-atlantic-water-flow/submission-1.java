class Solution {
    int[][] dirs = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        for (int c = 0; c < COLS; c++) {
            pacificQueue.offer(new int[] {0, c});
            atlanticQueue.offer(new int[] {ROWS-1, c});
        }

        for (int r = 0; r < ROWS; r++) {
            pacificQueue.offer(new int[] {r, 0});
            atlanticQueue.offer(new int[] {r, COLS-1});
        }
        
        bfs(heights, pacific, pacificQueue);
        bfs(heights, atlantic, atlanticQueue);
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

    private void bfs(int[][] heights, boolean[][] ocean, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            ocean[r][c] = true;
            for (int[] dir : dirs) {
                int x = r + dir[0];
                int y = c + dir[1];
                if (x >= 0 && x < heights.length && y >= 0 && y < heights[0].length && !ocean[x][y] && heights[x][y] >= heights[r][c]) {
                    queue.offer(new int[]{x,y});
                }
            }
        }
    }
}
