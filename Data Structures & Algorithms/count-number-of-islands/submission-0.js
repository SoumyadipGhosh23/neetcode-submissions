class Solution {
    count = 0;

    dfs(row, col, grid) {
        if (
            row < 0 ||
            col < 0 ||
            row >= grid.length ||
            col >= grid[0].length ||
            grid[row][col] === "0"
        ) {
            return;
        }

        grid[row][col] = "0";

        this.dfs(row - 1, col, grid);
        this.dfs(row + 1, col, grid);
        this.dfs(row, col - 1, grid);
        this.dfs(row, col + 1, grid);
    }

    numIslands(grid) {
        this.count = 0;
        for (let row = 0; row < grid.length; row++) {
            for (let col = 0; col < grid[0].length; col++) {
                if (grid[row][col] === "1") {
                    this.count++;      // one new island found
                    this.dfs(row, col, grid); // sink the whole island
                }
            }
        }
        return this.count;
    }
}