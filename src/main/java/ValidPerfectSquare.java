
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long left = 1, right = 1000000, ct = 0;
        while (left < right && ct < 100) {
            long mid = (left + right) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            ++ct;
        }
        if (left * left == num || right * right == num) {
            return true;
        }
        return false;
    }
}
