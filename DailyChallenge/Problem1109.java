package DailyChallenge;

public class Problem1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];

        for (int[] subArr : bookings) {
            for (int i = subArr[0] - 1; i < subArr[1]; i++)
                result[i] += subArr[2];
        }

        return result;
    }

    public int[] betterSolve(int[][] bookings, int n) {
        int[] delta = new int[n];
        for (int[] booking : bookings) {
            delta[booking[0] - 1] += booking[2];

            if (booking[1] < n) {
                delta[booking[1]] -= booking[2];
            }
        }

        int[] result = new int[n];
        result[0] = delta[0];
        for (int i = 1; i < n; ++i) {
            result[i] = result[i - 1] + delta[i];
        }
        return result;
    }
}
