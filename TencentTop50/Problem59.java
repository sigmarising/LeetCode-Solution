package TencentTop50;

import java.util.ArrayList;
import java.util.List;

public class Problem59 {
    public int[][] generateMatrix(int n) {
        int total = n * n;
        int[][] matrix = new int[n][n];

        int[][] actions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int currentAction = 0;

        int i = 0, j = 0;
        for (int count = 1; count <= total; count++) {
            matrix[i][j] = count;

            int nextI = i + actions[currentAction][0];
            int nextJ = j + actions[currentAction][1];
            if (nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n || matrix[nextI][nextJ] != 0)
                currentAction = (currentAction + 1) % 4;

            i += actions[currentAction][0];
            j += actions[currentAction][1];
        }

        return matrix;
    }

}
