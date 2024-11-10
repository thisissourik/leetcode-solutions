
/*
 * 
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
import java.util.ArrayList;

public class Spiral_Matrix {
    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        ArrayList<Integer> spiralOrder = spiralOrder(mat);
        for (int row : spiralOrder)
            System.out.println(row);
    }

    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        return new ArrayList<Integer>();
    }
}
