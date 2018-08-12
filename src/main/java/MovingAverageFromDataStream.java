import java.util.LinkedList;

public class MovingAverageFromDataStream {
    private LinkedList<Integer> dequeue = new LinkedList<>();
    private int size;
    private long sum;

    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        if (dequeue.size() == size) sum -= dequeue.removeFirst();
        dequeue.addLast(val);
        sum += val;
        // System.out.printf("size=%d, val=%d, dequeue=%s, sum=%d\n", size, val, dequeue, sum);
        return (double)sum / dequeue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
