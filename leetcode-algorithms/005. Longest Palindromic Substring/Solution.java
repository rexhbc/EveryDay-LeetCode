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
