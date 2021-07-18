package TencentTop50;

public class Problem122 {
    public int maxProfit(int[] prices) {
        int days_len = prices.length;

        if (days_len < 2) {
            return 0;
        }

        int result = 0;
        for (int i = 1; i < days_len; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                result += diff;
            }
        }
        return result;
    }
}
