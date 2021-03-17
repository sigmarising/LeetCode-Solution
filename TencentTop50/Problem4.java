package TencentTop50;

public class Problem4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        boolean evenLen = (len1 + len2) % 2 == 0;

        int pos1 = (len1 + len2) / 2;
        int pos2 = pos1 + 1;

        int i = 0, j = 0, total = 1;
        int x = 0, y = 0;
        while (total <= pos2) {
            int current;

            if (i == len1) {
                current = nums2[j];
                j++;
            } else if (j == len2) {
                current = nums1[i];
                i++;
            } else if (nums1[i] <= nums2[j]) {
                current = nums1[i];
                i++;
            } else {
                current = nums2[j];
                j++;
            }

            if (total == pos1) x = current;
            else if (total == pos2) y = current;

            total++;
        }

        return evenLen ? (double) (x + y) / 2.0 : (double) y;
    }

    public static void main(String[] args) {
        Problem4 obj = new Problem4();
        int[] a = {0, 0, 0, 0, 0};
        int[] b = {-1, 0, 0, 0, 0, 0, 1};
        System.out.println(obj.findMedianSortedArrays(a, b));
    }
}
