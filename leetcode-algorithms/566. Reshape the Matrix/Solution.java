/**
 * Brute force
 * Time : O(N^2)
 * Space: O(1)
 */
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        
        // when not possible
        if (r*c != nums.length * nums[0].length){
            return nums;
        }
        
        int[][] result = new int[r][c];
        int curRow = 0;
        int curCol = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums[0].length; j++){
                result[curRow][curCol++] = nums[i][j];
                if (curCol >= c){
                    curCol = 0;
                    curRow++;
                }
            }
        }
        
        return result;
    }
}
