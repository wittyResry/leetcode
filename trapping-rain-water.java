public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] rh = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1) {
                rh[i] = height[i];
            } else {
                if (rh[i+1] > height[i]) rh[i] = rh[i+1];
                else rh[i] = height[i];
            }
        }
        int[] lh = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                lh[i] = height[i];
            } else {
                if (lh[i-1] > height[i]) lh[i] = lh[i-1];
                else lh[i] = height[i];
            }
        }
        int res = 0;
        for (int i = 1; i < n-1; ++i) {
            int tmin = lh[i-1];
            if (rh[i+1] < tmin) tmin = rh[i+1];
            if (height[i] < tmin) res += tmin - height[i];
        }
        return res;
    }
}