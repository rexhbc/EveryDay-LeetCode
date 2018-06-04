/**
 * DFS
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

/**
 * Union-Find
 * Time: O(M*N)
 * Space: O(M*N)
 */
class Solution {
  class UnionFind {
    int count; // # of connected components
    int[] parent;
    int[] rank;

    public UnionFind(char[][] grid) { 
      count = 0;
      int m = grid.length;
      int n = grid[0].length;
      parent = new int[m * n];
      rank = new int[m * n];
      for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
          if (grid[i][j] == '1') {
            parent[i * n + j] = i * n + j;
            ++count;
          }
          rank[i * n + j] = 0;
        }
      }
    }

    public int find(int i) { // path compression
      if (parent[i] != i) parent[i] = find(parent[i]);
      return parent[i];
    }

    public void union(int x, int y) { // union with rank
      int rootx = find(x);
      int rooty = find(y);
      if (rootx != rooty) {
        if (rank[rootx] > rank[rooty]) {
          parent[rooty] = rootx;
        } else if (rank[rootx] < rank[rooty]) {
          parent[rootx] = rooty;
        } else {
          parent[rooty] = rootx; rank[rootx] += 1;
        }
        --count;
      }
    }

    public int getCount() {
      return count;
    }
  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int nr = grid.length;
    int nc = grid[0].length;
    int num_islands = 0;
    UnionFind uf = new UnionFind(grid);
    for (int r = 0; r < nr; ++r) {
      for (int c = 0; c < nc; ++c) {
        if (grid[r][c] == '1') {
          grid[r][c] = '0';
          if (r - 1 >= 0 && grid[r-1][c] == '1') {
            uf.union(r * nc + c, (r-1) * nc + c);
          }
          if (r + 1 < nr && grid[r+1][c] == '1') {
            uf.union(r * nc + c, (r+1) * nc + c);
          }
          if (c - 1 >= 0 && grid[r][c-1] == '1') {
            uf.union(r * nc + c, r * nc + c - 1);
          }
          if (c + 1 < nc && grid[r][c+1] == '1') {
            uf.union(r * nc + c, r * nc + c + 1);
          }
        }
      }
    }

    return uf.getCount();
  }
}
