package bambooSwords.array;
/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int n = matrix.length - 1;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < (n + 2) / 2; j++){
                int temp = matrix[0][n - i];
                matrix[j][n - i - j] = matrix[n][n - i - j];
                matrix[n][n - i - j] = matrix[i][n];
                matrix[i][n] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
