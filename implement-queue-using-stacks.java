class MyQueue {
    Stack<Integer>in = new Stack<Integer>();
    Stack<Integer>out = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        in.push(x);
    }
    
    private void move() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
    }
    // Removes the element from in front of queue.
    public void pop() {
        if (out.isEmpty()) {
            move();
        }
        if (!out.isEmpty()) {
            out.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if (out.isEmpty()) {
            move();
        }
        if (!out.isEmpty()) {
            return out.peek();
        } else {
            return -1;
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}