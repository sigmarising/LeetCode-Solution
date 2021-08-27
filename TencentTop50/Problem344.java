package TencentTop50;

public class Problem344 {
    public void reverseString(char[] s) {
        if (s.length == 0) return;

        int i = 0, j = s.length - 1;

        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            i++;
            j--;
        }
    }
}
