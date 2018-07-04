/**
 * Stack
 * Time : O(N)
 * Space: O(N)
 */
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            if ((c == '(') || (c == '[') || (c == '{')){
                stack.offerFirst(c);
            } else if (c == ')'){
                if (!stack.isEmpty() && stack.peekFirst() == '('){
                    stack.pollFirst();
                } else return false;
            } else if (c == ']'){
                if (!stack.isEmpty() && stack.peekFirst() == '['){
                    stack.pollFirst();
                } else return false;
            } else{
                if (!stack.isEmpty() && stack.peekFirst() == '{'){
                    stack.pollFirst();
                } else return false;
            }
        }
        
        return stack.isEmpty();
    }
}

/**
 * Stack with trick
 * Time : O(N)
 * Space: O(N)
 */
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            if (c == ('(')){
                stack.offerFirst(')');
            } else if (c == '['){
                stack.offerFirst(']');
            } else if (c == '{'){
                stack.offerFirst('}');
            } else{
                if (stack.isEmpty() || stack.peekFirst() != c){
                    return false;
                } else {
                    stack.pollFirst();
                }
            }
        }
        
        return stack.isEmpty();
    }
}
