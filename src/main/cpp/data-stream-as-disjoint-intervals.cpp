/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class SummaryRanges {
public:
    /** Initialize your data structure here. */
    SummaryRanges() {
        
    }
    
    void addNum(int val) {
        vector<Interval> tmp;
        Interval cur(val, val);
        int index = 0;
        for (int i = 0; i < res.size(); ++i) {
            if (cur.end + 1 == res[i].start) {
                cur.end = res[i].end;
            } else if (cur.start -1 == res[i].end) {
                cur.start = res[i].start;
            } else if (cur.end + 1 < res[i].start) {
                tmp.push_back(res[i]);
            } else if (cur.start - 1 > res[i].end) {
                tmp.push_back(res[i]);
                ++index;
            } else {
                cur.start = min(cur.start, res[i].start);
                cur.end = max(cur.end, res[i].end);
            }
        }
        tmp.insert(tmp.begin() + index, cur);
        res.clear();
        res = tmp;
    }
    
    vector<Interval> getIntervals() {
        return res;
    }
    private:
    vector<Interval> res;
};

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * vector<Interval> param_2 = obj.getIntervals();
 */