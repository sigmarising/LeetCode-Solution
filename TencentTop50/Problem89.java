package TencentTop50;

import java.util.ArrayList;
import java.util.List;

public class Problem89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>() {{
            add(0);
        }};

        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = result.size() - 1; j >= 0; j--)
                result.add(head + result.get(j));
            head <<= 1;
        }

        return result;
    }
}
