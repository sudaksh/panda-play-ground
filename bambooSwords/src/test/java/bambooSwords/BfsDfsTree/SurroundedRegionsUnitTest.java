package bambooSwords.BfsDfsTree;

import org.junit.Test;

public class SurroundedRegionsUnitTest {
    @Test
    public void test(){
        SurroundedRegions s = new SurroundedRegions();
        char[][] board = new char[][]{{'O','O','O','O','O','O','O','O','X','O','O','O','O','O','X','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'X','O','O','X','O','X','O','O','O','O','X','O','O','X','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','X','O'},
                {'O','X','X','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','X','O','O','O','O','O','O','X','O','O','O','O','O','X','X','O'},
                {'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},{
            'O','O','O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','O'},
                {'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','X','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},
                {'X','O','O','O','O','O','O','O','O','X','X','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','X','O','O','O','O','O','O','O','O','X','O','O','O','O','O','X'},
                {'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','X','O','X','O','O'},
                {'O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','X','X','O','O','O','X','O','O','X','O','O','X'},
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'}};
        s.solve(board);
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
