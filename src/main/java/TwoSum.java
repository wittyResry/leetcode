import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer other = target - nums[i];
            if (valueToIndex.containsKey(other)) {
                int[] res = new int[2];
                res[0] = valueToIndex.get(other);
                res[1] = i;
                return res;
            }
            valueToIndex.put(nums[i], i);
        }
        int[] res = new int[2];
        return res;
    }
}
