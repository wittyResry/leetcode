#include<cstring>
#include<cstdio>
#include<cstdlib>
using namespace std;

char s[1000005], next1[1000005], s1[1000005];

class Solution {
public:
    void getNext(char s[], char next[]){
      int len_s = strlen(s);
      int j, k; j = 0, k = -1;//k < j
      next[0] = -1;
      while(j < len_s) {
        if (k == -1 || s[j] == s[k]) ++j, ++k, next[j] = k;
        else k = next[k];
      }
    }
    int strStr(string haystack, string needle) {
        if (needle == "") return 0;
        strcpy(s, haystack.c_str());
        strcpy(s1, needle.c_str());
        getNext(s1, next1);
        int i = 0;
        int j = 0;
        for (; i < haystack.size();) {
            if (j == -1 || s[i] == s1[j]) ++i, ++j;
            else j = next1[j];
            if (j == needle.size()) break;
        }
        if (j == needle.size()) return i - needle.size();
        return -1;
    }
};