public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int cnt = 0;
        int[] a = new int[nums.length];
        if (nums.length == 0) return new int[0];//new int [1]是错的，我去
        int front = 0;
        int tail= 0;
        int i = 0;
        for (; i < k - 1 && i < nums.length; ++i) {
            if (front == tail) {
                a[front++] = nums[i];
            } else {
                while (front > tail && a[front - 1] < nums[i]) --front;
                a[front++] = nums[i];
            }
        }
        if (i == nums.length) {
            res[cnt++] = a[tail];
            return res;
        }
        for (; i < nums.length; ++i) {
            if (front == tail) {
                a[front++] = nums[i];
            } else {
                while (front > tail && a[front - 1] < nums[i]) --front;
                a[front++] = nums[i];
            }
            if (i - k >= 0 && nums[i - k] == a[tail]) ++tail;
            res[cnt++] = a[tail];
        }
        return res;
        
    }
}
