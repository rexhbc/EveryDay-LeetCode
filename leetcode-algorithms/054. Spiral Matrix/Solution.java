/**
 * Iterative method
 * Time : O(M*N)
 * Space: O(1)
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        int m = matrix.length;
        
        // we need to check m first
        // if m is 0, matrix[0].length will throw exception
        if (m == 0){
            return list;
        }
        int n = matrix[0].length;
        
        int left = 0;
        int right = n-1;
        int up = 0;
        int down = m-1;
        
        while(left < right && up < down){
            for (int i = left; i <= right; i++){
                list.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down-1; i++){
                list.add(matrix[i][right]);
            }
            for (int i = right; i >= left; i--){
                list.add(matrix[down][i]);
            }
            for (int i = down - 1; i >= up + 1; i--){
                list.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            down--;
        }
        
        // // if there is nothing left, return already
        // if (left > right || up > down){
        //     return list;
        // }
        
        // if there is one column left
        if (left == right){
            for (int i = up; i <= down; i++){
                list.add(matrix[i][left]);
            }
        } else if (up == down) { // there is one row left
            for (int i = left; i <= right; i++){
                list.add(matrix[up][i]);
            }
        }
        
        return list;
    }
}
