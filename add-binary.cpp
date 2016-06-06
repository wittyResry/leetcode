class Solution {
public:
    string addBinary(string a, string b) {
        int i = a.size() - 1;
        int j = b.size() - 1;
        vector<char> tmp;
        int token = 0;
        while (i >= 0 && j >= 0) {
            int t1 = a[i] - '0';
            int t2 = b[j] - '0';
            tmp.push_back('0' + (t1 + t2 + token) % 2);
            token = (t1 + t2 + token) / 2;
            --i,--j;
        }
        while (i >= 0) {
            int t = a[i] - '0';
            tmp.push_back('0' + (t + token) % 2);
            token = (t + token) / 2;
            --i;
        }
        while (j >= 0) {
            int t = b[j] - '0';
            tmp.push_back('0' + (t + token) % 2);
            token = (t + token) / 2;
            --j;
        }
        while (token > 0) {
            tmp.push_back('0' + token % 2);
            token /= 2;
        }
        string res;
        for (int i = tmp.size() - 1; i >= 0; --i) {
            res += tmp[i];
        }
        return res;
    }
};