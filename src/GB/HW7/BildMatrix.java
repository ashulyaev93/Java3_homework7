package GB.HW7;

import java.util.Arrays;

public class BildMatrix {
    public static void main(String[] args) {
        int w = 5;
        int h = 5;
        int n = 5;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                matrix[i][j] = s(w, h, j, i) + 1;
            }
        }
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }

    private static int s(int w, int h, int x, int y) {
        return y != 0 ? w + s(h - 1, w, y - 1, w - x - 1) : x;
    }
}
