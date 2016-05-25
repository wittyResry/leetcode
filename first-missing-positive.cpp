#include <alogirthm>
const int M = 10000;
class Solution {
public:
    int L[M] = {0};
    int cnt = 0;
    int firstMissingPositive(vector<int>& nums) {
        cnt = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] >= 1 && nums[i] < M) {
                L[cnt++] = nums[i];
            }
        }
        sort(L, L + cnt);
        int ccnt = 1;
        for (int i = 1; i < cnt; ++i) {
            if (L[i] != L[i-1]) {
                L[ccnt++] = L[i];
            }
        }
        for (int i = 0; i < ccnt; ++i) {
            if (L[i] != i+1) {
                return i+1;
            }
        }
        return ccnt + 1;
    }
};