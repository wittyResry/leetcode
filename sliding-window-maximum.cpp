const int M = 1000005;
int a[M];
int front, tail;
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> res;
        if (nums.size() == 0) return res;
        front = 0;
        tail= 0;
        int i = 0;
        for (; i < k - 1 && i < nums.size(); ++i) {
            if (front == tail) {
                a[front++] = nums[i];
            } else {
                while (front > tail && a[front - 1] < nums[i]) --front;
                a[front++] = nums[i];
            }
        }
        if (i == nums.size()) {
            res.push_back(a[tail]);
            return res;
        }
        for (; i < nums.size(); ++i) {
            if (front == tail) {
                a[front++] = nums[i];
            } else {
                while (front > tail && a[front - 1] < nums[i]) --front;
                a[front++] = nums[i];
            }
            if (i - k >= 0 && nums[i - k] == a[tail]) ++tail;
            res.push_back(a[tail]);
        }
        return res;
    }
};