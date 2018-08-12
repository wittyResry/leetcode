import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateIi {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> s = new HashSet<Integer>();
        Map<Integer, Integer> s1 = new HashMap<Integer, Integer>();
        for (int i = 0, tail = 0; i < nums.length; ++i) {
            if (i - tail > k) {
                s1.put(nums[tail], 0);
                tail++;
            }
            if (s1.containsKey(nums[i]) && s1.get(nums[i]) == 1) {
                return true;
            } else {
                s1.put(nums[i], 1);
            }
        }
        return false;
    }
}
