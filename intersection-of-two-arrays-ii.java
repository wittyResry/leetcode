import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public Solution() {
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                ++i;
                ++j;
            } else if (nums1[i] < nums2[j]) {
                ++i;
            } else {
                ++j;
            }
        }
        int[] tmp = new int[res.size()];
        int cnt = 0;
        for (Integer t:res) {
            tmp[cnt] = res.get(cnt);
            cnt++;
        }
        System.out.println(Arrays.deepToString(res.toArray()));
        return tmp;
    }

    public void main() {
        int[] nums = new int[] { 3, 1, 1, 2, 2, 1 };
        int k = 2;
        System.out.println(new Solution().intersect(nums, nums));
    }

    public static void main(String[] args) {
        new Solution().main();
    }
}