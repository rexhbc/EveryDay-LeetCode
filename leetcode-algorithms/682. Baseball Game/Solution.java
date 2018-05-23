/**
 * Using stack to store the process
 * Time : O(N)
 * Space: O(N)
 */
class Solution {
    public int calPoints(String[] ops) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < ops.length; i++){
            if (ops[i].equals("C")){
                stack.pollFirst();
            } else if (ops[i].equals("D")){
                stack.offerFirst(2*stack.peekFirst());
            } else if (ops[i].equals("+")){
                int round2 = stack.pollFirst();
                int round1 = stack.pollFirst();
                stack.offerFirst(round1);
                stack.offerFirst(round2);
                stack.offerFirst(round1+round2);
            } else { // it is a number, just insert
                stack.offerFirst(Integer.parseInt(ops[i]));
            }
        }
        
        int totalPoint = 0;
        while (!stack.isEmpty()){
            totalPoint += stack.pollFirst();
        }
        
        return totalPoint;
    }
}
