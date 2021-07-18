package TencentTop50;

public class Problem121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int maxVal = 0;
        int fiMin = 0, fi = 0;
        for (int i = 1; i <  prices.length; i++) {
            fi = Math.max(fiMin + prices[i] - prices[i-1],  0);
            maxVal = Math.max(fi, maxVal);
            fiMin = fi;
        }

        return maxVal;
    }
}
