import java.util.SortedSet;
import java.util.TreeSet;

public class ContainsDuplicateIii {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (0 - k >= 0 || t < 0 || nums.length < 2) return false;
        SortedSet<Long> s = new TreeSet<Long>();
        for (int i = 0; i < nums.length; ++i) {
            SortedSet<Long> subSet = s.subSet((long)nums[i] - t, (long)nums[i] + t + 1);
            if (!subSet.isEmpty()) return true;
            if (i - k >= 0) {
                s.remove((long) nums[i-k]);
            }
            s.add((long)nums[i]);
        }
        return false;
        
    }
}
