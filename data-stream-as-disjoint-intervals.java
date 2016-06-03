import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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

    class Interval {
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

// public class SummaryRanges {/*Version 2.0*/

//     private TreeSet<Interval> res = null;
//     /** Initialize your data structure here. */
//     public SummaryRanges() {
//         res = new TreeSet<Interval>(new Comparator<Interval>() {
//             @Override
//             public int compare(Interval o1, Interval o2) {
//                 return o1.start - o2.start;
//             }
//         });
//     }

//     public void addNum(int val) {
//         Interval cur = new Interval(val, val);
//         Interval a = res.floor(cur);
//         if (a != null) {
//             if (a.end >= cur.end) {
//                 return;
//             } else if (a.end +1 == cur.end) {
//                 cur.start = a.start;
//                 res.remove(a);
//             }
//         }
//         Interval b = res.ceiling(cur);
//         if (b != null) {
//             if (b.start -1 == cur.end) {
//                 cur.end = b.end;
//                 res.remove(b);
//             }
//         }
//         res.add(cur);
//     }

//     public List<Interval> getIntervals() {
//         return Arrays.asList(res.toArray(new Interval[0]));
//     }

//     class Interval {
//         int start;
//         int end;

//         Interval() {
//             start = 0;
//             end = 0;
//         }

//         Interval(int s, int e) {
//             start = s;
//             end = e;
//         }
//     }

//     public void main() {
//         SummaryRanges obj = new SummaryRanges();
//         obj.addNum(1);
//         print(obj);
//         obj.addNum(3);
//         print(obj);

//         obj.addNum(7);
//         print(obj);
//         obj.addNum(2);
//         print(obj);
//         obj.addNum(6);
//         print(obj);
//     }
//     public void print(SummaryRanges obj) {
//         List<Interval> param_2 = obj.getIntervals();
//         for (Interval t : param_2) {
//             System.out.println(t.start + " " + t.end);
//         }
//         System.out.println("===========");
//     }

//     public static void main(String[] args) {
//         new SummaryRanges().main();
//     }
// }
//public class SummaryRanges {/*Version 1.0*/
//
//    private List<Interval> res = null;
//    /** Initialize your data structure here. */
//    public SummaryRanges() {
//        res = new ArrayList<Interval>();
//    }
//
//    public void addNum(int val) {
//        List<Interval> preN = new ArrayList<Interval>();
//        List<Interval> postN = new ArrayList<Interval>();
//        Interval cur = new Interval(val, val);
//        boolean tag = false;
//        for (Interval interval : res) {
//            if (cur.end + 1 == interval.start) {
//                cur.end = interval.end;
//            } else if (cur.start -1 == interval.end) {
//                cur.start = interval.start;
//            } else if (cur.end + 1 < interval.start) {
//                postN.add(interval);
//            } else if (cur.start - 1 > interval.end) {
//                preN.add(interval);
//            } else {
//                //Keep it in its original state
//                //release heap
//                preN.clear();
//                postN.clear();
//                cur = null;
//                return;
//            }
//        }
//        List<Interval> tmp = new ArrayList<Interval>();
//        for (Interval interval : preN) {
//            tmp.add(interval);
//        }
//        if (!tag) {
//            tmp.add(cur);
//        }
//        for (Interval interval : postN) {
//            tmp.add(interval);
//        }
//        //release heap
//        preN.clear();
//        postN.clear();
//        this.res.clear();
//        cur = null;
//        this.res = tmp;
//    }
//
//    public List<Interval> getIntervals() {
//        return res;
//    }
//
//    class Interval {
//        int start;
//        int end;
//
//        Interval() {
//            start = 0;
//            end = 0;
//        }
//
//        Interval(int s, int e) {
//            start = s;
//            end = e;
//        }
//    }
//
//    public void main() {
//        SummaryRanges obj = new SummaryRanges();
//        obj.addNum(1);
//        print(obj);
//        obj.addNum(3);
//        print(obj);
//
//        obj.addNum(7);
//        print(obj);
//        obj.addNum(2);
//        print(obj);
//        obj.addNum(6);
//        print(obj);
//    }
//    public void print(SummaryRanges obj) {
//        List<Interval> param_2 = obj.getIntervals();
//        for (Interval t : param_2) {
//            System.out.println(t.start + " " + t.end);
//        }
//        System.out.println("===========");
//    }
//
//    public static void main(String[] args) {
//        new SummaryRanges().main();
//    }
//}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */