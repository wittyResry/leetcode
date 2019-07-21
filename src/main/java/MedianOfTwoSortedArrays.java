class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0, right = m;
        while (left <= right) {
            int mid = (left + right) / 2;
            int i = mid;
            int j = (m + n + 1) / 2 - i;
            if (i - 1 >= 0 && j < n && nums1[i-1] > nums2[j]) {
                right = mid - 1;
            } else if (i < m && j - 1 >= 0 && nums1[i] < nums2[j-1]) {
                left = mid + 1;
            } else {
                int leftCut;
                if (i == 0) {
                    System.out.println(j-1);
                    leftCut = nums2[j-1];
                } else if (j == 0) {
                    leftCut = nums1[i-1];
                } else {
                    leftCut = Math.max(nums1[i-1], nums2[j-1]);
                }
                if ((m + n) % 2 == 1) {
                    return leftCut;
                }
                int rightCut;
                if (i == m) {
                    rightCut = nums2[j];
                } else if (j == n) {
                    rightCut = nums1[i];
                } else {
                    rightCut = Math.min(nums1[i], nums2[j]);
                }
                return (leftCut + rightCut) / 2.0;
            }
        }
        System.out.println("error");
        return 0;
    }
}
