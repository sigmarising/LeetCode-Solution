package TencentTop50;

import java.util.HashMap;
import java.util.Map;

public class Problem8 {
    static class AutoMachine {
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private final Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "inNumber", "end"});
            put("signed", new String[]{"end", "end", "inNumber", "end"});
            put("inNumber", new String[]{"end", "end", "inNumber", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        public void get(char c) {
            state = table.get(state)[getStateNum(c)];
            if ("inNumber".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int getStateNum(char c) {
            if (c == ' ') return 0;
            else if (c == '+' || c == '-') return 1;
            else if (Character.isDigit(c)) return 2;

            return 3;
        }
    }

    public int myAtoi(String str) {
        AutoMachine autoMachine = new AutoMachine();
        int length = str.length();

        for (int i = 0; i < length; i++) {
            autoMachine.get(str.charAt(i));
        }

        return (int) (autoMachine.sign * autoMachine.ans);
    }
}
