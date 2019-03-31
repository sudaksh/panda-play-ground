package bambooSwords.BfsDfsTree;

import org.junit.Test;

public class NumOfIslandTest {

    @Test
    public void test(){
        NumOfIsland numOfIsland = new NumOfIsland();
        char[][] grid = new char[][]{
                {'1','1','1'},{'1','0','1'},{'1','1','1'}
        };
        numOfIsland.numIslands(grid);

        System.out.print((int)Math.sqrt(12));

    }
}
