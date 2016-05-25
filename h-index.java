class Solution {
public:
    int hIndex(vector<int>& citations) {
        sort (citations.begin(), citations.end());
        for (int i = 0, j = citations.size() - 1; i < j; ++i, --j) swap(citations[i], citations[j]);
        for (int i = citations.size() - 1; i >= 0; --i) {
            if (citations[i] >= i + 1) {
                return i + 1;
            }
        }
        return 0;
    }
};