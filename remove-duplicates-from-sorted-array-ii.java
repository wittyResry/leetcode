public class Solution {
    public int removeDuplicates(int[] A) {
        Arrays.sort(A);
        int cnt = 0;
        int pre1 = 0, pre2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (i < 2) {
                A[cnt++] = A[i];
                if (i == 0) pre2 = A[i];
                else pre1 = A[i];
            } else {
                if (pre1 == A[i] && pre2 == A[i])
                    continue;
                A[cnt++] = A[i];
                pre2 = pre1;
                pre1 = A[i];
            }
        }
        return cnt;
    }
}