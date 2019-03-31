package bambooSwords.BfsDfsTree;

import java.util.HashSet;

/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
 */
public class NumOfIsland {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;

        HashSet<Pair> unvisited = new HashSet<>();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == '1') unvisited.add(new Pair(i, j));
            }
        }
        int sign = 1;
        while (unvisited.size() != 0){
            sign++;
            Pair p = unvisited.iterator().next();
            visitIsland(p, grid, sign, row, col, unvisited);
        }
        return sign - 1;
    }

    public void visitIsland(Pair p, char[][] grid, int sign, int row, int col, HashSet<Pair> unvisited){
        grid[p.a][p.b] = (char)(sign + '0');
        unvisited.remove(p);
        if (p.a + 1 < row && grid[p.a + 1][p.b] == '1'){
            visitIsland(new Pair(p.a + 1, p.b), grid, sign, row, col, unvisited);
        }
        if (p.a - 1 >= 0 && grid[p.a - 1][p.b] == '1'){
            visitIsland(new Pair(p.a - 1, p.b), grid, sign, row, col, unvisited);
        }
        if (p.b + 1 < col && grid[p.a][p.b + 1] == '1'){
            visitIsland(new Pair(p.a, p.b + 1), grid, sign, row, col, unvisited);
        }
        if (p.b - 1 >= 0 && grid[p.a][p.b - 1] == '1'){
            visitIsland(new Pair(p.a, p.b - 1), grid, sign, row, col, unvisited);
        }

    }
}
