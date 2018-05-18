/**
 * Time: O(N)
 * Space: O(N)
 */
class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        
        int factor2 = 1;
        int factor3 = 1;
        int factor5 = 1;
        
        for (int i = 1; i < n; i++){
            factor2 = 2*ugly[index2];
            factor3 = 3*ugly[index3];
            factor5 = 5*ugly[index5];
            
            int cur = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = cur;
            
            if (cur == factor2){
                index2++;
            }
            if (cur == factor3){
                index3++;
            }
            if (cur == factor5){
                index5++;
            }
        }
        
        return ugly[n-1];
    }
}


