class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        directions = [[1,0],[-1,0],[0,1],[0,-1]]
        ROWS, COLS = len(grid), len(grid[0])
        result = 0
        def dfs(r, c):
            if (r < 0 or r >= ROWS or c < 0 or c >= COLS or grid[r][c] == "0"):
                return
            grid[r][c] = "0"
            for x, y in directions:
                dfs(r + x, c + y)

        for row in range(ROWS):
            for col in range(COLS):
                if grid[row][col] == "1":
                    result += 1
                    dfs(row, col)
            
        return result