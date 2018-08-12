class Solution {
public:
    char tmp[32];
    string get_str(int begin, int pre) {
        tmp[0]='\0';
        sprintf(tmp, "%d", begin);
        if (begin == pre) {
            return string(tmp);
        }
        string res(tmp);
        sprintf(tmp, "%d", pre);
        return res + string("->") + string(tmp);
    }
    vector<string> summaryRanges(vector<int>& nums) {
        vector<string>res;
        if (nums.size() == 0) return res;
        int begin = -1, pre;
        for (int i = 0; i < nums.size(); ++i) {
            if (begin == -1) {
                begin = nums[i];
            } else {
                if (nums[i] != pre+1) {
                    res.push_back(get_str(begin, pre));
                    begin = nums[i];
                }
            }
            pre = nums[i];
        }
        res.push_back(get_str(begin, nums[nums.size() - 1]));
        return res;
    }
};