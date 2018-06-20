/**
 * brute force
 * Time : O(N^2)
 * Space: O(1)
 */
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++){
            reverse(i, A);
        }
        
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A[0].length; j++){
                if (A[i][j] == 0){
                    A[i][j] = 1;
                } else {
                    A[i][j] = 0;
                }
            }
        }
        
        return A;
    }
    
    private void reverse(int i, int[][] A){
        int start = 0; 
        int end = A[i].length-1;
        while (start < end){
            int tmp = A[i][start];
            A[i][start] = A[i][end];
            A[i][end] = tmp;
            start++;
            end--;
        }
    }
}
