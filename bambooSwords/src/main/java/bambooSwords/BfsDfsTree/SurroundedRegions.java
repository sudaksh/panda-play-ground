package bambooSwords.BfsDfsTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegions {
    public class Dot{
        int x;
        int y;
        public Dot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private int[] dirX = new int[]{-1, 1, 0, 0};
    private int[] dirY = new int[]{0, 0, -1, 1};
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int row = board.length;
        int col = board[0].length;

        for (int j = 0; j < col; j++){
            bfsTravel(board, 0, j);
            bfsTravel(board, row - 1, j);
        }

        for (int i = 0; i < row; i++){
            bfsTravel(board, i, 0);
            bfsTravel(board, i, col - 1);
        }

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (board[i][j] == 'T'){
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }
    public void bfsTravel(char[][] board, int x, int y){
        if (board[x][y] == 'O'){
            Queue<Dot> que = new LinkedList<>();
            que.offer(new Dot(x, y));
            while (!que.isEmpty()){
                Dot cur = que.poll();
                System.out.println(cur.x + " " + cur.y);
                board[cur.x][cur.y] = 'T';
                for (int i = 0; i < 4; i++){
                    if (cur.x + dirX[i] >= 0
                            && cur.x + dirX[i] < board.length
                            && cur.y + dirY[i] >= 0
                            && cur.y + dirY[i] < board[0].length
                            && board[cur.x + dirX[i]][cur.y + dirY[i]] == 'O'){
                        board[cur.x + dirX[i]][cur.y + dirY[i]] = 'T';
                        que.offer(new Dot(cur.x + dirX[i], cur.y + dirY[i]));
                    }
                }
            }
        }

    }
}
