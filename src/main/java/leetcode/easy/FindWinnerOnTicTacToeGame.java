package leetcode.easy;

public class FindWinnerOnTicTacToeGame {

    public static void main(String[] args) {
        FindWinnerOnTicTacToeGame s = new FindWinnerOnTicTacToeGame();
        int[][] moves = {{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}};
        s.tictactoe(moves);
    }

    public String tictactoe(int[][] moves) {
        char[][] desk = new char[3][3];

        for (int i = 0; i < moves.length; i++) {
            desk[moves[i][0]][moves[i][1]] = i % 2 == 0 ? 'X' : 'O';
            if (check(desk, moves[i][0], moves[i][1], desk[moves[i][0]][moves[i][1]])) {
                return i % 2 == 0 ? "A" : "B";
            }
        }

        if (moves.length == 9) {
            return "Draw";
        }

        return "Pending";
    }

    public boolean check(char[][] a, int x, int y, char pl) {
        int n = a.length;

        boolean isDone = true;

        // check row
        for (int j = 0; j < n; j++) {
            if (a[x][j] != pl) {
                isDone = false;
                break;
            }
        }

        if (isDone) {
            return true;
        }

        isDone = true;

        // check column
        for (int i = 0; i < n; i++) {
            if (a[i][y] != pl) {
                isDone = false;
                break;
            }
        }

        if (isDone) {
            return true;
        }

        isDone = true;

        // first
        for (int i = 0; i < n; i++) {
            if (a[i][i] != pl) {
                isDone = false;
                break;
            }
        }

        if (isDone) {
            return true;
        }

        isDone = true;

        for (int i = 0; i < n; i++) {
            if (a[i][n - i - 1] != pl) {
                isDone = false;
                break;
            }
        }

        if (isDone) {
            return true;
        }

        return false;
    }
}
