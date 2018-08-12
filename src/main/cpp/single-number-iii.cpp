class Solution {
public:
    int getNum(vector<int>& nums) {
        int s = 0;
        for (int i = 0; i < nums.size(); ++i) {
            s ^= nums[i];
        }
        return s;
    }
    vector<int> singleNumber(vector<int>& nums) {
        int s = 0;
        for (int i = 0; i < nums.size(); ++i) {
            s ^= nums[i];
        }
        int tmp = s & (-s);
        vector<int> vec1;
        vector<int> vec2;
        for (int i = 0; i < nums.size(); ++i) {
            if ((nums[i] & tmp) == 0) {
                vec1.push_back(nums[i]);
            } else {
                vec2.push_back(nums[i]);
            }
        }
        vector<int> vec;
        int res1 = getNum(vec1);
        vec.push_back(res1);
        vec.push_back(s ^ res1);
        return vec;
    }
};