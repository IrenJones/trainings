package leetcode.leetcode_by_topics.array.island_problems;

public class SurroundedRegions {

	public static void main(String[] args) {

		char[][] boardNew = {
				{'O', 'O', 'O'},
				{'O', 'O', 'O'},
				{'O', 'O', 'O'}
		};
		solveNew(boardNew);

		char [][] board = new char[4][4];
		board[0] = new char[]{'X', 'X', 'X', 'X'};
		board[1] = new char[]{'X', 'O', 'O', 'X'};
		board[2] = new char[]{'X', 'X', 'O', 'X'};
		board[3] = new char[]{'X', 'O', 'X', 'X'};

		for(int i=0; i< board.length; i++){
			for(int j=0; j< board[0].length; j++){
				System.out.print(board[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println("-------------------------");
		solve(board);

		for(int i=0; i< board.length; i++){
			for(int j=0; j< board[0].length; j++){
				System.out.print(board[i][j]+ " ");
			}
			System.out.println();
		}

		System.out.println("-------------------------");

		board = new char[4][4];
		board[0] = new char[]{'X', 'X', 'X', 'X'};
		board[1] = new char[]{'X', 'O', 'O', 'X'};
		board[2] = new char[]{'X', 'O', 'O', 'X'};
		board[3] = new char[]{'X', 'O', 'X', 'X'};

		for(int i=0; i< board.length; i++){
			for(int j=0; j< board[0].length; j++){
				System.out.print(board[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println("-------------------------");
		solve(board);

		for(int i=0; i< board.length; i++){
			for(int j=0; j< board[0].length; j++){
				System.out.print(board[i][j]+ " ");
			}
			System.out.println();
		}

		System.out.println("-------------------------");

		board = new char[2][2];
		board[0] = new char[]{'O', 'O'};
		board[1] = new char[]{'O', 'O'};

		for(int i=0; i< board.length; i++){
			for(int j=0; j< board[0].length; j++){
				System.out.print(board[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println("-------------------------");
		solve(board);

		for(int i=0; i< board.length; i++){
			for(int j=0; j< board[0].length; j++){
				System.out.print(board[i][j]+ " ");
			}
			System.out.println();
		}
	}


	// Surrounded regions shouldn’t be on the border,
	// which means that any 'O' on the border of the board are not flipped to 'X'.
	// Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
	// Two cells are connected if they are adjacent cells connected horizontally or vertically.
	public static void solve(char[][] board) {

		if (board.length == 0) {
			return;
		}

		int rows = board.length;
		int columns = board[0].length;

		// need to check all regions with borders
		for (int i = 0; i < rows; i++) {
			// corners
			if (board[i][0] == 'O') {
				dfsBoundary(board, i, 0);
			}
			if (board[i][columns - 1] == 'O') {
				dfsBoundary(board, i, columns - 1);
			}
		}

		for (int i = 0; i < columns; i++) {
			// corners
			if (board[0][i] == 'O') {
				dfsBoundary(board, 0, i);
			}
			if (board[rows - 1][i] == 'O') {
				dfsBoundary(board, rows - 1, i);
			}
		}

		for (int i = 0; i < rows; i++) {
			for(int j=0; j < columns; j++){
				if(board[i][j] == 'O'){
					// convert good regions
					board[i][j] = 'X';
				} else if (board[i][j] == 'B'){
					// convert marked bad regions
					board[i][j] = 'O';
				}
			}
		}
	}

	private static void dfsBoundary(char[][] board, int i, int j) {
		if(i > board.length-1 || i < 0
				|| board[0].length < j || j < 0){
			return;
		}

		// mark as bad
		if(board[i][j] == 'O') {
			board[i][j] = 'B';
		}

		// search for next parts of the island in all possible directions
		if (i > 0 && board[i-1][j] == 'O'){
			dfsBoundary(board, i-1, j);
		}

		if (i < board.length-1 && board[i+1][j] == 'O'){
			dfsBoundary(board, i+1, j);
		}

		if(j > 0 && board[i][j-1] == 'O'){
			dfsBoundary(board, i, j-1);
		}

		if(j < board[0].length-1 && board[i][j+1] == 'O'){
			dfsBoundary(board, i, j+1);
		}
	}

	public static void solveNew(char[][] board) {
		if(board.length == 0 || board[0].length == 0) {
			return;
		}

		for(int i=0; i< board.length; i++) {
			if(board[i][0] == 'O') {
				board[i][0] = 'N';
			}

			if(board[i][board[0].length - 1] == 'O') {
				board[i][board[0].length - 1] = 'N';
			}
		}

		for(int i=0; i< board[0].length; i++) {
			if(board[0][i] == 'O') {
				board[0][i] = 'N';
			}

			if(board[board.length - 1][i] == 'O') {
				board[board.length - 1][i] = 'N';
			}
		}

		for(int i=0; i< board.length; i++) {
			for(int j=0; j < board[0].length; j++){
				if (board[i][j] == 'N') {
					mark(i, j, board, i, j);
				}
			}
		}

		for(int i=0; i< board.length; i++) {
			for(int j=0; j < board[0].length; j++){
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if(board[i][j] == 'N') {
					board[i][j] = 'O';
				}
			}
		}
	}

	public static void mark(int i, int j, char[][] board, int startI, int startJ) {
		if (i < 0 || i >= board.length  || j < 0 || j >= board[0].length ) {
			return;
		}

		if((board[i][j] == 'X' || board[i][j] == 'N' ) && (startI != i || startJ != j)) {
			return;
		}

		board[i][j] = 'N';

		mark(i + 1, j, board, startI, startJ);
		mark(i - 1, j, board, startI, startJ);
		mark(i, j + 1, board, startI, startJ);
		mark(i, j - 1, board, startI, startJ);
	}
}
