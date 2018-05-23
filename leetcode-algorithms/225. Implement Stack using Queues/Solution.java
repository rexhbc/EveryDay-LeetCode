/**
 * push : O(1)
 * pop  : O(1)
 * top  : O(1)
 * empty: O(1)
 */
class MyStack {

    private Deque<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.offerFirst(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.pollFirst();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peekFirst();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * push : O(N)
 * pop  : O(1)
 * top  : O(1)
 * empty: O(1)
 */
class MyStack {

    private Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        
        while (queue.peek() != x){
            queue.offer(queue.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
