public class Solution {
    int abs(int a) {
        if (a < 0) return -a;
        return a;
    }
    int max(int a, int b) {
        if (a > b) return a;
        return b;
    }
    int min(int a, int b) {
        if (a < b) return a;
        return b;
    }
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = abs(C - A) * abs(D - B);
        int area2 = abs(G - E) * abs(H - F);
        int res = area1 + area2;
        int A1 = max(A, E), B1 = max(B, F), C1 = min(C, G), D1 = min(D, H);
        if (A1 >= C1 || B1 >= D1) return res;
        return res - abs(C1 - A1) * abs(D1 - B1);
    }
}