class Practical12 {
    static int N = 6;
    static int solutions = 0;
 
    static boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < row; i++) if (board[i][col] == 1) return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1) return false;
        return true;
    }
 
    static void solve(int[][] board, int row, boolean printFirst) {
        if (row == N) {
            solutions++;
            if (printFirst && solutions == 1) {
                System.out.println("One solution for " + N + "-Queen:");
                for (int[] r : board) System.out.println(Arrays.toString(r));
            }
            return;
        }
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                solve(board, row + 1, printFirst);
                board[row][col] = 0;
            }
        }
    }
 
    static void run() {
        System.out.println("===== Practical 12: N-Queen Problem =====");
        int[][] board = new int[N][N];
        solutions = 0;
        solve(board, 0, true);
        System.out.println("Total solutions for N=" + N + ": " + solutions);
        System.out.println();
    }
}
 