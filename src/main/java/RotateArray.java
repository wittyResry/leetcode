public class RotateArray {
    public void rotate(int[] nums, int k) {
        int[]res = new int[nums.length];
        int cnt = 0;
        k %= nums.length;
        int begin = 0 - k + nums.length;
        if (begin == nums.length) begin = 0;
        for (int i = 0; i < nums.length; ++i) {
            res[cnt++] = nums[begin++];
            if (begin == nums.length) begin = 0;
        }
        for (int i = 0; i < nums.length; ++i) nums[i] = res[i];
    }
}
