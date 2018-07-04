/**
 * fast and slow index
 * Time : O(N)
 * Space: O(1)
 * BUG  : becareful with index moving, define the index first
 */
class Solution {
    public int compress(char[] chars) {
        int slow = 0;
        int fast = 0;
        while (fast < chars.length){
            char cur = chars[fast];
            chars[slow++] = cur; // assign the current index and move the slow index
            int counter = 0;
            while (fast < chars.length && chars[fast] == cur){
                fast++;
                counter++;
            }
            if (counter > 1){
                for ( char c : Integer.toString(counter).toCharArray()){
                    chars[slow++] = c;
                }
            }
            
        }
        
        return slow;
    }
}
