#include <vector>
#include <string>
#include <cstring>
class Solution {
public:
    char res[11];
    char begin[11] = {'0', '0', 'a', 'd', 'g', 'j', 'm', 'p', 't', 'w'};
    char end[11] =   {'0', '0', 'c', 'f', 'i', 'l', 'o', 's', 'v', 'z'};
    char digits[11];
    vector<string> output;
    void dfs(char *res, int deep, int n) {
        if (deep >= n) {
            res[n] = '\0';
            output.push_back(res);
            return;
        }
        for (char tmp = begin[digits[deep] - '0']; tmp <= end[digits[deep] - '0']; tmp++) {
            res[deep] = tmp;
            dfs(res, deep + 1, n);
        }
    }
    vector<string> letterCombinations(string d) {
        output.clear();
        if (d == "") return output;
        strcpy(digits, d.c_str());
        int n = strlen(digits);
        dfs(res, 0, n);
        return output;
    }
};