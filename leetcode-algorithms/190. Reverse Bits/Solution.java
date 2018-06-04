/**
 * unsigned shift and signed shift
 * Time : O(1)
 * Space: O(1)
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        
        for (int i = 0; i < 32; i++){
            result += n & 1;
            n = n >>> 1; // unsigned shift 左边补0
            if (i < 31){
                result = result << 1;// 右边补0
            }
        }
        
        return result;
    }
}
