class MedianFinder {
public:

    // Adds a number into the data structure.
    void addNum(int num) {
        preHeap.push(num);
        postHeap.push(-preHeap.top());
        preHeap.pop();
        if (postHeap.size()-preHeap.size() > 1 && postHeap.size() > 0) {
            preHeap.push(-postHeap.top());
            postHeap.pop();
        }
    }

    // Returns the median of current data stream
    double findMedian() {
        if (preHeap.size() == 0 && postHeap.size() == 0) return 0.0;
        return postHeap.size() > preHeap.size() ? -1.0 * postHeap.top(): 0.5 * (preHeap.top() - postHeap.top());
    }
private:
    priority_queue<int>preHeap, postHeap;
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf;
// mf.addNum(1);
// mf.findMedian();