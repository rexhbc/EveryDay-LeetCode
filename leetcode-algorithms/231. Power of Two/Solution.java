/**
 * Trick: n & (n-1)
 * Time : O(1)
 * Space: O(1)
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n&(n-1)) == 0;
    }
}

/**
 * Trick: there is only one 1 is its binary
 * Time : O(1)
 * Space: O(1)
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && countOnes(n) == 1;
    }
    
    private int countOnes(int number){
        int result = 0;
        
        while (number > 0){
            int count = number & 1;
            if (count == 1) result++;
            number = number >> 1;
        }
        
        return result;
    }
}
