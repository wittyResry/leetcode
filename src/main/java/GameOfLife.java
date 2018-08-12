public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board.length == 0) return;
        int[][] tmp = new int[board.length][board[0].length];
        int r = board.length;
        int c = board[0].length;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                int ct = 0;
                if (i+1 < r && board[i+1][j] == 1) ++ct;
                if (i-1 >= 0 && board[i-1][j] == 1) ++ct;
                if (j+1 < c && board[i][j+1] == 1) ++ct;
                if (j-1 >= 0 && board[i][j-1] == 1) ++ct;
                if (i+1 < r && j+1 < c && board[i+1][j+1] == 1) ++ct;
                if (i+1 < r && j-1 >= 0 && board[i+1][j-1] == 1) ++ct;
                if (i-1 >= 0 && j+1 < c && board[i-1][j+1] == 1) ++ct;
                if (i-1 >= 0 && j-1 >= 0 && board[i-1][j-1] == 1) ++ct;
                if (board[i][j] == 0) {
                    if (ct == 3) {
                        tmp[i][j] = 1;
                    } else {
                        tmp[i][j] = 0;
                    }
                } else {
                    if (ct == 2 || ct == 3) {
                        tmp[i][j] = 1;
                    } else {
                        tmp[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                board[i][j] = tmp[i][j];
            }
        }
    }
}
