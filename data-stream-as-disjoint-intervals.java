import java.util.ArrayList;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {

    private List<Interval> res = null;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        res = new ArrayList<Interval>();
    }

    public void addNum(int val) {
        List<Interval> preN = new ArrayList<Interval>();
        List<Interval> postN = new ArrayList<Interval>();
        Interval cur = new Interval(val, val);
        boolean tag = false;
        for (Interval interval : res) {
            if (cur.end + 1 == interval.start) {
                cur.end = interval.end;
            } else if (cur.start -1 == interval.end) {
                cur.start = interval.start;
            } else if (cur.end + 1 < interval.start) {
                postN.add(interval);
            } else if (cur.start - 1 > interval.end) {
                preN.add(interval);
            } else {
                //Keep it in its original state
                //release heap
                preN.clear();
                postN.clear();
                cur = null;
                return;
            }
        }
        List<Interval> tmp = new ArrayList<Interval>();
        for (Interval interval : preN) {
            tmp.add(interval);
        }
        if (!tag) {
            tmp.add(cur);
        }
        for (Interval interval : postN) {
            tmp.add(interval);
        }
        //release heap
        preN.clear();
        postN.clear();
        this.res.clear();
        cur = null;
        this.res = tmp;
    }

    public List<Interval> getIntervals() {
        return res;
    }

    // class Interval {
    //     int start;
    //     int end;

    //     Interval() {
    //         start = 0;
    //         end = 0;
    //     }

    //     Interval(int s, int e) {
    //         start = s;
    //         end = e;
    //     }
    // }

    public void main() {
        SummaryRanges obj = new SummaryRanges();
        obj.addNum(1);
        print(obj);
        obj.addNum(3);
        print(obj);

        obj.addNum(7);
        print(obj);
        obj.addNum(2);
        print(obj);
        obj.addNum(6);
        print(obj);
    }
    public void print(SummaryRanges obj) {
        List<Interval> param_2 = obj.getIntervals();
        for (Interval t : param_2) {
            System.out.println(t.start + " " + t.end);
        }
        System.out.println("===========");
    }

    public static void main(String[] args) {
        new SummaryRanges().main();
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */