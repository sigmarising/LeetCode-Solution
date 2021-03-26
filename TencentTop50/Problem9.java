package TencentTop50;

import java.util.ArrayList;
import java.util.List;

public class Problem9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        else if (x == 0) return true;

        List<Integer> digitsList = new ArrayList<>();

        while (x != 0) {
            digitsList.add(x % 10);
            x /= 10;
        }

        for(int i = 0, j = digitsList.size() - 1; i < digitsList.size() / 2; i++, j--){
            if (!digitsList.get(i).equals(digitsList.get(j))) return false;
        }

        return true;
    }
}
