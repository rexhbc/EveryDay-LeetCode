/**
 * Push : O(1)
 * Pop  : O(1) amortized -> O(N) worst
 * Peek : O(1) amortized -> O(N) worst
 * Empty: O(1)
 */
class MyQueue {
    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.offer(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.offer(stack1.poll());
            }
        }
        
        return stack2.poll();
    }
    
    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.offer(stack1.poll());
            }
        }
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }
}
