class Stack {
public:
    queue<int>q1;
    queue<int>q2;
    // Push element x onto stack.
    void push(int x) {
        q1.push(x);
    }

    // Removes the element on top of the stack.
    void pop() {
        while (q1.size() > 1) {
            q2.push(q1.front());q1.pop();
        }
        if (!q1.empty()) {
            q1.pop();
        }
        while (!q2.empty()) {
            q1.push(q2.front());q2.pop();
        }
    }

    // Get the top element.
    int top() {
        int tmp=-1;
        while (q1.size() > 1) {
            q2.push(q1.front());q1.pop();
        }
        if (!q1.empty()) {
            tmp=q1.front();
            q2.push(q1.front());q1.pop();
        }
        while (!q2.empty()) {
            q1.push(q2.front());q2.pop();
        }
        return tmp;
    }

    // Return whether the stack is empty.
    bool empty() {
        return q1.empty();
    }
};