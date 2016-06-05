public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums2[j] < nums1[i]) {
                ++j;
            } else {
                if (res.size() == 0) {
                    res.add(nums1[i]);
                } else {
                    if (res.get(res.size() - 1) != nums1[i]) {
                        res.add(nums1[i]);
                    }
                }
                ++i;
                ++j;
            }
        }
        int[] tmp = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            tmp[i] = res.get(i);
        }
        return tmp;
    }
}