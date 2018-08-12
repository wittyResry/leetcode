#include<algorithm>
#include<vector>
class Solution {
public:
    void sortColors(vector<int>& nums) {
        int a[3] = {0};
        for (int i = 0; i < nums.size(); ++i) {
            int idx = nums[i];
            ++a[idx];
        }
        int cnt = 0;
        for (int i = 0; i < 3; ++i) {
            while(a[i] > 0) {
                nums[cnt++] = i;
                --a[i];
            }
        }
    }
};