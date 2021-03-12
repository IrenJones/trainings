package leetcode.medium.matrix;

public class GameOfLife {

	public static void main(String[] args) {
		int[][] arr = {
				{0,1,0},
				{0,0,1},
				{1,1,1},
				{0,0,0}
		};

		GameOfLife solution = new GameOfLife();
		solution.gameOfLife(arr);
	}

	public void gameOfLife(int[][] board) {

		if(board.length == 0 || board[0].length == 0) {
			return;
		}

		int n = board.length;
		int m = board[0].length;

		int[][] res = new int[n][m];

		for(int i=0; i< n; i++){
			res[i] = new int[m];
		}

		for(int i=0; i< n; i++){
			for(int j=0; j< m; j++) {
				res[i][j] = calculate(i, j, board, n, m);
			}
		}

		for(int i=0; i< n; i++){
			System.arraycopy(res[i], 0, board[i], 0, m);
		}
	}


	public int calculate(int x, int y, int[][] board, int n, int m){

		int count = 0;

		for(int i = x - 1; i <= x + 1; i++) {
			for(int j = y - 1; j <= y + 1; j++) {
				if(i >= 0 && i < n && j >= 0 && j < m){
					if(!(x == i && y == j)) {
						count += board[i][j];
					}
				}
			}
		}

		if(board[x][y] == 1 && (count > 3 || count < 2)) {
			return 0;
		}

		if(board[x][y] == 0 && count == 3) {
			return 1;
		}

		return board[x][y];
	}

	public void gameOfLifeInPlace(int[][] board) {
		if(board.length == 0 || board[0].length == 0) {
			return;
		}

		int n = board.length;
		int m = board[0].length;

		for(int i=0; i< n; i++){
			for(int j=0; j< m; j++) {
				board[i][j] = calculateWithTrick(i, j, board, n, m);
			}
		}

		for(int i=0; i< n; i++){
			for(int j=0; j< m; j++) {
				if(board[i][j] == -1) {
					board[i][j] = 0;
				} else if(board[i][j] == 2) {
					board[i][j] = 1;
				}
			}
		}
	}

	public int calculateWithTrick(int x, int y, int[][] board, int n, int m){

		int count = 0;

		for(int i = x - 1; i <= x + 1; i++) {
			for(int j = y - 1; j <= y + 1; j++) {
				if(i >= 0 && i < n && j >= 0 && j < m){
					if(!(x == i && y == j)) {
						count += (Math.abs(board[i][j]) % 2);
					}
				}
			}
		}

		if(board[x][y] == 1 && (count > 3 || count < 2)) {
			return -1;
		}

		if(board[x][y] == 0 && count == 3) {
			return 2;
		}

		return board[x][y];
	}
}
