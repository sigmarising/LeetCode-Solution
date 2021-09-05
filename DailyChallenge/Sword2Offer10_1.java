package DailyChallenge;

public class Sword2Offer10_1 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        final int MOD = 1000000007;
        int x = 0, y = 0, result = 1;

        for (int i = 2; i <= n; i += 1) {
            x = y;
            y = result;
            result = (x + y) % MOD;
        }

        return result;
    }
}
