/**
 * Stack
 * Time : O(M+N)
 * Space: O(M+N)
 */
class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Deque<Character> ans = new ArrayDeque();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.offerFirst(c);
            else if (!ans.isEmpty())
                ans.pollFirst();
        }
        return String.valueOf(ans);
    }
}

/**
 * Two pointer
 * Time : O(M+N)
 * Space: O(1)
 */
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int backS = 0;
        int backT = 0;
        int i = S.length() - 1;
        int j = T.length() - 1;
        
        while (i >= 0 || j >= 0){
            // find the index of the possible character of S
            while (i >= 0){
                if (S.charAt(i) == '#'){
                    backS++;
                    i--;
                } else if (backS > 0){
                    backS--;
                    i--;
                } else break;
            }
            
            // find the index of the possible character of S
            while (j >= 0){
                if (T.charAt(j) == '#'){
                    backT++;
                    j--;
                } else if (backT > 0){
                    backT--;
                    j--;
                } else break;
            }
            
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)){
                return false;
            } else if ( (i >= 0) != (j >= 0)){
                return false;
            }
            
            i--;
            j--;
        }
        return true;
    }
}
