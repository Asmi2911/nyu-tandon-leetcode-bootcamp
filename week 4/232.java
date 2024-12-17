import java.util.Stack;

class MyQueue {
    private Stack<Integer> s1; // For pushing new elements
    private Stack<Integer> s2; // For popping/peeking elements

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    // Push element x to the back of the queue
    public void push(int x) {
        s1.push(x);
    }
    
    // Removes and returns the element from the front of the queue
    public int pop() {
        shiftStacks();
        return s2.pop();
    }
    
    // Get the front element
    public int peek() {
        shiftStacks();
        return s2.peek();
    }
    
    // Check whether the queue is empty
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    // Helper function to move elements from s1 to s2 if s2 is empty
    private void shiftStacks() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }
}
