#include<stack>
class MinStack {
public:
    void push(int x) {
        st.push(x);
        if (st1.empty() || x <= st1.top()) {
            st1.push(x);
        }
    }

    void pop() {
        int x = st.top(); st.pop();
        while (st1.top() > x) {
            st1.pop();
        }
        if (st1.top() == x) {
            st1.pop();
        }
    }

    int top() {
        return st.top();
    }

    int getMin() {
        return st1.top();
    }
private:
    stack<int> st;
    stack<int> st1;
};