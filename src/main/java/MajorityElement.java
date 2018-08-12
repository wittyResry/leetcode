public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 1;
        int select = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (count == 0 || nums[i] == select) {
                ++count;
                select = nums[i];
            } else {
                --count;
            }
        }
        return select;
    }
}
