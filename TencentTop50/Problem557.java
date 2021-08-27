package TencentTop50;

public class Problem557 {
    public String reverseWords(String s) {
        String[] list = s.split(" ");

        for (int i = 0; i < list.length; i++)
            list[i] = new StringBuffer(list[i]).reverse().toString();

        return String.join(" ", list);
    }
}
