/**
 * Stack
 * Time : O(N)
 * Space: O(N)
 */
class Solution {
    public int scoreOfParentheses(String S) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (char c : S.toCharArray()){
            if (c == '('){
                stack.offerFirst(0);
            } else {
                int cur = 0;
                while (stack.peekFirst() != 0){
                    cur += stack.pollFirst();
                }
                
                // removing the 0 indicating removing the "("
                stack.pollFirst();

                if (cur == 0){
                    stack.offerFirst(1);
                } else {
                    stack.offerFirst(cur*2);
                }
            }
        }
        int result = 0;
        while (!stack.isEmpty()){
            result += stack.pollFirst();
        }
        
        return result;
    }
}
