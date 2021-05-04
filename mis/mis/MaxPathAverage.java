package mis;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a square matrix of size N*N, where each cell is associated with a specific cost. A path is defined as a specific sequence of cells which starts from top left cell move only right or down and ends on bottom right cell. We want to find a path with maximum average over all existing paths. Average is computed as total cost divided by number of cells visited in path.
 *
 * Input : Matrix = [1 , 2, 3
 *                   4, 5, 6
 *                   7, 8, 9]
 * Output : 5.8
 * Path with maximum average is, 1 -> 4 -> 7 -> 8 -> 9
 */
public class MaxPathAverage {

    public static double getMaxAveragePath(Integer[][] matrix, Integer n) {
        for (Integer i = 0; i < n; i++) {
            for (Integer j = 0; j < n; j++) {
                List<Integer> elementsFromAllPaths = getElementsFromAllPath(i, j, matrix);
                if (elementsFromAllPaths.size() > 1) {
                    matrix[i][j] = Math.max(elementsFromAllPaths.get(0), elementsFromAllPaths.get(1)) + matrix[i][j];
                } else if (elementsFromAllPaths.size() > 0) {
                    matrix[i][j] = elementsFromAllPaths.get(0) + matrix[i][j];
                }

            }

        }

        return (double) matrix[n - 1][n - 1] / ((2 * n) - 1);
    }

    public static List<Integer> getElementsFromAllPath(Integer i, Integer j, Integer[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (i - 1 >= 0) {
            list.add(matrix[i - 1][j]);
        }
        if (j - 1 >= 0) {
            list.add(matrix[i][j - 1]);
        }
        return list;
    }


    public static void main(String[] args) {
        Integer[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(getMaxAveragePath(matrix, 3));//5.2
    }
}
