/**
 * expand from center
 * Time : O(N^2)
 * Space: O(1)
 */
class Solution {
    public int countSubstrings(String s) {
        int[] counter = new int[]{0};
        for (int i = 0; i < s.length(); i++){
            // two way of expand
            expandFromCenter(s,i,i,counter);
            expandFromCenter(s,i,i+1,counter);
        }
        
        return counter[0];
    }
    
    private void expandFromCenter(String s, int i, int j, int[] counter){
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            counter[0]++;
            i--;
            j++;
        }
    }
}

/**
 * Dp: almost same as the longest palindrome substring
 * Time : O(N^2)
 * Space: O(N^2)
 */
class Solution {
    public int countSubstrings(String s) {
        
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length()-1; i >= 0; i--){
            dp[i][i] = true;
            count++;
            for (int j = i+1; j < s.length(); j++){
                if (j == i + 1){
                    if (s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                        count++;
                    } 
                } else{
                    if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}
