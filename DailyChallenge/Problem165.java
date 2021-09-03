package DailyChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem165 {
    public int compareVersionV1(String version1, String version2) {
        List<String> v1Arr = new ArrayList<>(Arrays.asList(version1.split("\\.")));
        List<String> v2Arr = new ArrayList<>(Arrays.asList(version2.split("\\.")));

        while (v1Arr.size() != v2Arr.size())
            if (v1Arr.size() > v2Arr.size()) v2Arr.add("0");
            else v1Arr.add("0");

        int pathIndex = 0;
        while (pathIndex < v1Arr.size() && pathIndex < v2Arr.size()) {
            int v1Path = Integer.parseInt(v1Arr.get(pathIndex));
            int v2Path = Integer.parseInt(v2Arr.get(pathIndex));

            if (v1Path > v2Path) return 1;
            if (v1Path < v2Path) return -1;

            pathIndex += 1;
        }

        return 0;
    }

    public int compareVersion(String version1, String version2) {
        String[] v1Arr = version1.split("\\.");
        String[] v2Arr = version2.split("\\.");

        int pathIndex = 0;
        while (pathIndex < v1Arr.length || pathIndex < v2Arr.length) {
            int v1Path = pathIndex < v1Arr.length ? Integer.parseInt(v1Arr[pathIndex]) : 0;
            int v2Path = pathIndex < v2Arr.length ? Integer.parseInt(v2Arr[pathIndex]) : 0;

            if (v1Path > v2Path) return 1;
            if (v1Path < v2Path) return -1;

            pathIndex += 1;
        }

        return 0;
    }
}
