package TencentTop50;

public class Problem14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        int minStrLen = Integer.MAX_VALUE;
        for (String str : strs)
            minStrLen = Math.min(minStrLen, str.length());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < minStrLen; i ++) {
            char c = strs[0].charAt(i);
            for (String str : strs)
                if (str.charAt(i) != c) return builder.toString();
            builder.append(c);
        }

        return builder.toString();
    }
}
