package graph;

public class islandNum200 {
    //思路就是，遇到一个1，那么就把这个1所属的island全部变成0，然后再往下走，看看还有没有其他的1，有 islandNum++
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Iterate through each cell in the grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // When we find a piece of land, initiate a DFS/BFS to mark all the connected land
                if (grid[r][c] == '1') {
                    numIslands++;
                    dfs(grid, r, c);
                }
            }
        }

        return numIslands;
    }

    // Helper method to mark connected land (DFS approach)
    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // If out of bounds or on water, return
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0') {
            return;
        }

        // Mark the current cell as visited (turn it into water)
        grid[r][c] = '0';

        // Explore all 4 directions (up, down, left, right)
        dfs(grid, r - 1, c); // Up
        dfs(grid, r + 1, c); // Down
        dfs(grid, r, c - 1); // Left
        dfs(grid, r, c + 1); // Right
    }
}
