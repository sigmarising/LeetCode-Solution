package TencentTop50;

public class Problem5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";

        for (int absPos = 0; absPos < n; absPos++) {
            for (int i = 0; i + absPos < n; i++) {
                int j = i + absPos;
                boolean isIJEqual = s.charAt(i) == s.charAt(j);

                switch (absPos) {
                    case 0:
                        dp[i][j] = true;
                        break;
                    case 1:
                        dp[i][j] = isIJEqual;
                        break;
                    default:
                        dp[i][j] = isIJEqual && dp[i + 1][j - 1];
                }

                if (dp[i][j] && absPos + 1 > ans.length()) ans = s.substring(i, i + absPos + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Problem5 obj = new Problem5();
        obj.longestPalindrome("aaaa");
    }
}
