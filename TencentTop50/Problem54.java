package TencentTop50;

import java.util.ArrayList;
import java.util.List;

public class Problem54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int rows = matrix.length;
        int columns = matrix[0].length;
        int total = rows * columns;
        boolean[][] visited = new boolean[rows][columns];

        int[][] actions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int currentAction = 0;

        int i = 0, j = 0;
        for (int count = 0; count < total; count++) {
            result.add(matrix[i][j]);
            visited[i][j] = true;

            int nextI = i + actions[currentAction][0];
            int nextJ = j + actions[currentAction][1];
            if (nextI < 0 || nextI >= rows || nextJ < 0 || nextJ >= columns || visited[nextI][nextJ])
                currentAction = (currentAction + 1) % 4;

            i += actions[currentAction][0];
            j += actions[currentAction][1];
        }

        return result;
    }
}
