/**
 * Using stack to keep track of operations
 * Time : O(N)
 * Space: O(N)
 */
class Solution {
    public int evalRPN(String[] tokens) {
        
	Deque<Integer> stack = new ArrayDeque<>();
	for (String s: tokens){
		if (s.equals("+")){
			int num1 = stack.pollFirst();
			int num2 = stack.pollFirst();
			stack.offerFirst(num2+num1);
        } else if (s.equals("-")){
            int num1 = stack.pollFirst();
			int num2 = stack.pollFirst();
			stack.offerFirst(num2-num1);
        } else if (s.equals("*")){
	        int num1 = stack.pollFirst();
			int num2 = stack.pollFirst();
			stack.offerFirst(num2*num1);
        } else if (s.equals("/")){
	        int num1 = stack.pollFirst();
			int num2 = stack.pollFirst();
			stack.offerFirst(num2/num1);
        } else {
	        stack.offerFirst(Integer.parseInt(s));
        }
	}

	return stack.peekFirst();
}

}
