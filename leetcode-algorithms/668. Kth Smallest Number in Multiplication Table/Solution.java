/**
 * Time: O((M+N)(logMN))
 * Space: O(1)
 */
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m*n;
        
        while (left < right){
            int mid = left + (right-left)/2;
            int count = 0;
            int j = n;
            for (int i = 1; i <= m; i++){
                while (j >= 0 && i*j > mid) j--;
                count += j;
            }
            
            if (count < k) left = mid+1;
            else right = mid;
        }
        
        return left;
    }
}
