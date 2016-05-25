class Solution {
public:
    char st[100005];
    bool isValid(string s) {
        int top = 0;
        for (int i = 0; i < s.size(); ++i) {
            if (s.at(i) == '(' || s.at(i) == '[' || s.at(i) == '{') {
                st[top++] = s.at(i);
            } else {
                if (s.at(i) == ')') {
                    if (top > 0 && st[top-1] == '(') top--;
                    else return false;
                } else if (s.at(i) == ']') {
                    if (top > 0 && st[top - 1] == '[') top--;
                    else return false;
                } else if (s.at(i) == '}') {
                    if (top > 0 && st[top - 1] == '{') top--;
                    else return false;
                }
            }
        }
        return top == 0;
    }
};