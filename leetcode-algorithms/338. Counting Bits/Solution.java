/*
 * DP + most sigfinicant bit
 * Time : O(N)
 * Space: O(N)
 */
class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        int i = 0;
        int b = 1; // know that [0,b) is calculated
        
        while (b <= num){
            // generate [b, 2b) or [b, num) from [0, b)
            while (i < b && i+b <= num){
                result[i+b] = result[i]+1;
                i++;
            }
            i = 0; // reset i
            b <<= 1; // b = 2b
        }
        
        return result;
    }
}

/*
 * DP + least sigfinicant bit
 * Time : O(N)
 * Space: O(N)
 */
public class Solution {
  public int[] countBits(int num) {
      int[] ans = new int[num + 1];
      for (int i = 1; i <= num; ++i)
        ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
      return ans;
  }
}
