char s[100005];
char res[100005];
int cnt;
class Solution {
public:
    void reverseWords(string &st) {
        strcpy(s, st.c_str());
        cnt = 0;
        int len = strlen(s);
        for (int i = 0, j = len - 1; i < j; ++i, --j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
        int i = 0;
        while (i < len) {
            while (i < len && s[i] == ' ') ++i;
            int j = i;
            while (j < len && s[j] != ' ') ++j;
            for (int t = j-1; t >= i; t--) {
                res[cnt++] = s[t];
            }
            res[cnt++] = ' ';
            i = j;
        }
        while (cnt > 0 && res[cnt-1] == ' ') cnt--;
        res[cnt] = '\0';
        st = string(res);
    }
};