import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public Solution() {
    }
    private List<Integer> a = new ArrayList<Integer>();
    private List<Integer> tmp = new ArrayList<Integer>();
    private int n = 0;
    public List<Integer> countSmaller(int[] nums) {
        a.clear();
        tmp.clear();
        n = nums.length;
        List<Integer> res = new ArrayList<Integer>();
        a.add(0);
        for (int val : nums) {
            a.add(0);
            tmp.add(val);
            res.add(0);
        }
        Collections.sort(tmp);
        for (int i = nums.length -1; i >= 0; --i) {
            int idx = getIndex(nums[i]);
            addValue(idx);
            res.set(i, getValue(idx - 1));
        }
        return res;
    }

    private void addValue(int idx) {
        for (int i = idx; i < a.size(); i += i&(-i)) {
            a.set(i, a.get(i) + 1);
        }
    }
    private int getValue(int idx) {
        int sum = 0;
        if (idx <= 0) return 0;
        for (int i = idx; i > 0; i -= i&(-i)) {
            sum += a.get(i);
        }
        return sum;
    }

    private int getIndex(int val) {
        int left = 0, right = n-1, times = 0;
        while (left < right && times <= 65) {
            ++times;
            int mid = (left + right) / 2;
            if (tmp.get(left) == val || tmp.get(right) == val || tmp.get(mid) == val) {
                if (tmp.get(left) == val) return left + 1;
                if (tmp.get(right) == val) return right + 1;
                if (tmp.get(mid) == val) return mid + 1;
            }
            if (val < tmp.get(mid)) right = mid;
            else left = mid;
        }
        return left + 1;
    }

    public void main() {
        int[] nums = new int[] { 9, 6, 1, 8 };
        System.out.println(new Solution().countSmaller(nums));
    }

    public static void main(String[] args) {
        new Solution().main();
    }
}