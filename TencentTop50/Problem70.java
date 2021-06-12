package TencentTop50;

public class Problem70 {
    public int climbStairs(int n) {
        int a = 0, b = 0, result = 1;

        for (int i = 1; i <= n; ++i) {
            a = b;
            b = result;
            result = a + b;
        }

        return result;
    }
}
