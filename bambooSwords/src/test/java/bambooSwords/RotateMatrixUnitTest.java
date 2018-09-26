package bambooSwords;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class RotateMatrixUnitTest {
	
	private RotateMatrix rotateMatrix;
	
	
    @Before
    public void setup(){
    	rotateMatrix = new RotateMatrix();
    }
    
    @Test
    public void testRotateSquareMatrix() {
    	int[][] input = new int[4][4];
    	input[0] = new int[]{1,2,3,4};
    	input[1] = new int[]{5,6,7,8};
    	input[2] = new int[]{9,10,11,12};
    	input[3] = new int[]{13,14,15,16};
    	printMatrix(input);
    	
    	rotateMatrix.rotateSquareMatrix(input);
    	printMatrix(input);
    	fail();
    }


	private void printMatrix(int[][] input) {
		
		
		for(int[] row : input) {
			for(int element : row) {
				String delimiter = element > 9 ? "  " : "   ";
				System.out.print(element + delimiter);
			}
			System.out.println();
		}
		
		
		System.out.println("---------------------------");
		
		
	}

}
