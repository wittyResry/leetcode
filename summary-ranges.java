public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String>res = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add("" + nums[0]);
            return res;
        }
        int begin = -1, pre = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (begin == -1) {
                begin = nums[i];
            } else {
                if (nums[i] != pre+1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(begin);
                    if (pre != begin) {
                        sb.append("->").append(pre);
                    }
                    res.add(sb.toString());
                    begin = nums[i];
                }
            }
            pre = nums[i];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(begin);
        if (nums[nums.length - 1] != begin) {
            sb.append("->").append(nums[nums.length - 1]);
        }
        res.add(sb.toString());
        return res;
    }
}