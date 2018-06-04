/**
 * loop and count
 * Time : O(1)
 * Space: O(1)
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++){
            if ((n&mask) != 0){
                count++;
            }
            mask = mask << 1;// or  n = n >> 1;
        }
        
        return count;
    }
}
