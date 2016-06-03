import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    /** 最大堆 */
    private final PriorityQueue<Integer> preHeap  = new PriorityQueue<Integer>(100000,
                                                new Comparator<Integer>() {
                                                    @Override
                                                    public int compare(Integer o1, Integer o2) {
                                                        return o2 - o1;
                                                    }

                                                    @Override
                                                    public boolean equals(Object obj) {
                                                        return this.equals(obj);
                                                    }
                                                });

    /** 最小堆 */
    private final PriorityQueue<Integer> postHeap = new PriorityQueue<Integer>(100000);

    // Adds a number into the data structure.
    public void addNum(int num) {
        preHeap.add(num);
        postHeap.add(preHeap.peek());
        preHeap.remove(preHeap.peek());
        // balance both heap
        while (postHeap.size() - preHeap.size() > 1) {
            Integer val = postHeap.peek();
            postHeap.remove(val);
            preHeap.add(val);
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (preHeap.size() == 0 && postHeap.size() == 0)
            return 0.0;
        return (postHeap.size() > preHeap.size()) ? (double) postHeap.peek()
            : (postHeap.peek() + preHeap.peek()) / 2.0;
    }

    public void main() {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
        obj.addNum(7);
        System.out.println(obj.findMedian());
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(6);
        //        System.out.println(findMedian());
        //        postHeap.add(1);
        //        postHeap.add(10);
        //        System.out.println(postHeap.peek());
    }

    public static void main(String[] args) {
        new MedianFinder().main();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();