package bambooSwords;

public class RotateMatrix {

	//	[1, 2, 3, 4]
	//	[5, 6, 7, 8]
	//	[9 ,10,11,12]
	//	[13,14,15,16]

	public void rotateSquareMatrix(int [][] matrix) {

		int length = matrix.length;
		for(int i = 0 ; i < length/2 ; i++) {
			for(int j = i ; j < length - i - 1 ; j++) {
				rotate(matrix , i,j);
			}
		}

	}

	private void rotate(int[][] matrix, int i, int j) {
		
		// rotate 4 elements
		int length = matrix.length;
		int lengthOfSquare = length - i*2;
		
		int element1 = matrix[i][j];
		
		int e1Cindex = i+lengthOfSquare -1;
		int e1RIndex = j;
		int temp1 = matrix[e1RIndex][e1Cindex];
		matrix[e1RIndex][e1Cindex] = element1;
		
		
		int e2RIndex = i + lengthOfSquare - 1;
		int e2CIndex = i + lengthOfSquare - 1 - e1RIndex;
		
		int temp2 = matrix[e2RIndex][e2CIndex];
		matrix[e2RIndex][e2CIndex] = temp1;
		
		int e3CIndex = i;
		int e3RIndex = e2CIndex;
		
		temp1 = matrix[e3RIndex][e3CIndex];
		matrix[e3RIndex][e3CIndex] = temp2;
		
		matrix[i][j] = temp1;
		
		
	}

}
