/**
 * Time: O(N^2)
 * Space: O(1)
 */

class Solution {
    public String longestPalindrome(String s) {
    // Write your solution here
    if (s.length() == 0){
      return new String("");
    }
    
    int left = 0;
    int right = 0;
    int globalMax = 0;
    for (int i = 0; i< s.length(); i++){
      int len1 = checkPalindrome(s, i, i);
      int len2 = checkPalindrome(s, i, i+1);
      int localMax = Math.max(len1, len2);
      
      if (localMax >= globalMax){
        globalMax = localMax;
        int len = (localMax-1)/2;
        left = i - len;
        right = i +(localMax-len);
      }
    }
    
    return s.substring(left, right);
 
  }
  
  private int checkPalindrome(String s, int left, int right){
    
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
      left--;
      right++;
    }
    
    return right-left-1;
  }
}

/**
 * DP: 注意填表的方式，这个是从从下到上，从左到右的顺序
 * Time : O(N^2)
 * Space: O(N^2)
 */

class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int left = 0;
        int right = 0;
        int globalMax = 0;
        
        for (int i = s.length() - 1; i >= 0; i--){
            for (int j = i; j < s.length(); j++){
                if (i == j){
                    dp[i][j] = true;
                }
                else if (j == i+1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = (s.charAt(i)==s.charAt(j)) && dp[i+1][j-1];
                }
                
                // updated the max left and right
                if (dp[i][j] == true && (j-i+1 > globalMax)){
                    left = i;
                    right = j+1;
                    globalMax = j - i + 1;
                }
            }
        }
        
        return s.substring(left,right);
    }
}
