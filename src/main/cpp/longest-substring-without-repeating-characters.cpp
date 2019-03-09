class Solution {
public:
//�ⷨһ��
    int lengthOfLongestSubstring(string s) {
        char mp[128] = {0};
        for (int i = 0; i < 128; ++i) {
            mp[i] = 0;
        }
        int n = s.size(), res = 0;
        for (int i = 0, j = 0; i < n || j < n;) {
            if (j < n && !mp[s[j]]) {
                mp[s[j++]] = 1;
            } else {
                //���Ի������ڳ�ջ��ֱ��mp[s[j]] == 0��������һ���Ż�����Ծ�����ұ�s[j]��index+1�������Ͳ���һ��һ������
                mp[s[i++]] = 0;
            }
            res = max(res, j - i);
        }
        return res;
    }
//�ⷨ����
    int lengthOfLongestSubstring(string s) {
        int mp[128];//��¼��ǰɨ�赽���ַ����±�λ��Max��-1������ַ�û�г��ֹ�
        for (int i = 0; i < 128; i++) mp[i] = -1;
        int n = s.size(), res = 0, i = -1;
        for (int j = 0; j < n; ++j) {
            if (mp[s[j]] != -1)  {
                i = max(i, mp[s[j]]);
            }
            mp[s[j]] = max(mp[s[j]], j);
            res = max(res, j - i);
        }
        return res;
    }
};