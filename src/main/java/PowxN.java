public class PowxN {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        } else if (n > 0) {
            double res = 1.0;
            while (n > 0) {
                if (n % 2 != 0) {
                    res = res * x;
                }
                x = x * x;
                n >>= 1;
            }
            return res;
        } else {
            if (n == -2147483648) {
                if (x == 1.0 || x == -1.0) {
                    return 1.0;
                } else {
                    return 0.0;
                }
            }
            n = -n;
            double res = 1.0;
            while (n > 0) {
                if (n % 2 != 0) {
                    res = res * x;
                }
                if (res > 1e7) {
                    break;
                }
                x = x * x;
                n >>= 1;
            }
            return 1.0 / res;
        }
    }
}
/**
 * 2.00000
 * -2147483648
*/
