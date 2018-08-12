import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {/*Version 3.0*/

    private TreeMap<Interval, Object> res = null;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        res = new TreeMap<Interval, Object>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
    }

    public void addNum(int val) {
        Interval cur = new Interval(val, val);
        Interval a = res.floorKey(cur);
        if (a != null) {
            if (a.end >= cur.end) {
                return;
            } else if (a.end +1 == cur.end) {
                cur.start = a.start;
                res.remove(a);
            }
        }
        Interval b = res.ceilingKey(cur);
        if (b != null) {
            if (b.start -1 == cur.end) {
                cur.end = b.end;
                res.remove(b);
            }
        }
        res.put(cur, new Object());
    }

    public List<Interval> getIntervals() {
        List <Interval> tmp = new ArrayList<Interval>();
        for (Interval interval:res.keySet()) {
            tmp.add(interval);
        }
        return tmp;
    }

    public void print(SummaryRanges obj) {
        List<Interval> param_2 = obj.getIntervals();
        for (Interval t : param_2) {
            System.out.println(t.start + " " + t.end);
        }
        System.out.println("===========");
    }


    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */