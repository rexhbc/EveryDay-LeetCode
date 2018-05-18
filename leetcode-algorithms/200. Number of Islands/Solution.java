/*
* Time: O(M*N)
* Space: O(H) -> O(M*N)
*/
class Solution {
    public int numIslands(char[][] grid) {
        
        // sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int numIsland = 0;
        // check every position, if one, then do dfs
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    numIsland++;
                    dfs(grid, i, j, grid.length, grid[0].length);
                }
            }
        }
        
        return numIsland;
    }
    
    private void dfs(char[][] grid, int i, int j, int rows, int cols){
        
        // base case: if out of bound or there is water, you cannot anywhere
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0'){
            return;
        }
        
        // mark the position as water meaning visited
        grid[i][j] = '0';
        
        // going four directions
        dfs(grid, i-1, j, rows, cols);
        dfs(grid, i+1, j, rows, cols);
        dfs(grid, i, j-1, rows, cols);
        dfs(grid, i, j+1, rows, cols);
    }
}




