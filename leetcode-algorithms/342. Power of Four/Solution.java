/**
 * Trick: Since 2^n mod 3 should be 1 or -1
 *        Therefore 4^n / 3 is 1
 * Time : O(1)
 * Space: O(1)
 */
class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num % 3) == 1 && (num&(num-1)) == 0; 
    }
}
