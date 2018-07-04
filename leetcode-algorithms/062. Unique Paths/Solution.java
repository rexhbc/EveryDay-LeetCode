/**
 * 最基础的DP: dp[i][j]表示从点(0, 0)到(i, j)唯一路径数量
 *            dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * Time : O(M*N)
 * Space: O(M*N)
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // initialization
        for (int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        
        for (int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1]; 
            }
        }
        
        return dp[m-1][n-1];
    }
}
