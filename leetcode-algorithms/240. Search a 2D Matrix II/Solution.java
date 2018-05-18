/**
 * REDUCE search space
 * Time: O(M+N)
 * Space: O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        
        int i = matrix.length - 1;
        int j = 0;
        
        while (j < matrix[0].length && i >= 0){
            if (matrix[i][j] == target){
                return true;
            } else if (matrix[i][j] > target){
                i--;
            } else {
                j++;
            }
        }
        
        return false;
    }
}


