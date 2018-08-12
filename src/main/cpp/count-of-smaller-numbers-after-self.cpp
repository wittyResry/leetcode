#define N 100005
class Solution {
public:
    int a[N];
    vector<int> tmp;
    vector<int> res;
    int n;
    int findIndex(int val) {
        int left = 0, right = n-1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (tmp[left] == val || tmp[right] == val || tmp[mid] == val) {
                if (tmp[left] == val) return left + 1;
                if (tmp[right] == val) return right + 1;
                if (tmp[mid] == val) return mid + 1;
            }
            if (val < tmp[mid]) right = mid;
            else left = mid;
        }
        return left + 1;
    }
    void addValue(int begin) {
        if (begin <= 0) {
            while(true);
            return;
        }
        for (int idx = begin; idx < N; idx += idx&(-idx)) {
            a[idx] += 1;
        }
    }
    int getValue(int index) {
        int sum = 0;
        for (int idx = index; idx > 0; idx -= idx&(-idx)) {
            sum += a[idx];
        }
        return sum;
    }
    vector<int> countSmaller(vector<int>& nums) {
        n = nums.size();
        tmp.clear();
        for (int i = 0; i < nums.size(); ++i) {
            tmp.push_back(nums[i]);
            res.push_back(0);
            a[i+1] = 0;
        }
        sort(tmp.begin(), tmp.end());
        for (int i = nums.size() - 1; i >= 0; --i) {
            int idx = findIndex(nums[i]);
            addValue(idx);
            res[i] = getValue(idx - 1);
        }
        return res;
    }
};