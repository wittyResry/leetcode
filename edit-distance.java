#include<cstring>
#include<vector>
class Solution {
public:
    int getEditDistance(char *s1, char *s2) {
        int len1 = strlen(s1);
        int len2 = strlen(s2);
        if (len1 == 0 || len2 ==0) return len1 + len2;
        vector<vector<int> > d;
        for (int i = 0; i <= len1; ++i) {
            vector<int> td;
            for (int j = 0; j <= len2; ++j) {
                td.push_back(0);
            }
            d.push_back(td);
        }
        for (int i = 0; i <= len1; ++i) d[i][0] = i;
        for (int j = 0; j <= len2; ++j) d[0][j] = j;
        for (int i = 1; i <= len1; ++i) {
            char s1_i = s1[i-1];
            for (int j = 1; j <= len2; ++j) {
                char s2_j = s2[j-1];
                int ct = 1;
                if (s1_i == s2_j) ct = 0;
                else ct = 1;
                d[i][j] = d[i-1][j] + 1;
                if (d[i][j-1] + 1 < d[i][j]) d[i][j] = d[i][j-1] + 1;
                if (d[i-1][j-1] + ct < d[i][j]) d[i][j] = d[i-1][j-1] + ct;
            }
        }
        return d[len1][len2];
    }
    int minDistance(string word1, string word2) {
        char s1[10005];
        char s2[10005];
        strcpy(s1, word1.c_str());
        strcpy(s2, word2.c_str());
        
        return getEditDistance(s1, s2);
    }
};