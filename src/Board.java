public class Board {
    private final char[][] grid;
    private final int sor = 6;
    private final int oszlop = 7;
    private final char cella = '_';

    public Board() {
        grid = new char[sor][oszlop];
        for (int i = 0; i < sor; i++) {
            for (int j = 0; j < oszlop; j++) {
                grid[i][j] = cella;
            }
        }
    }

    public boolean dropDisc(int col, char disc) {
        if (col < 0 || col >= oszlop || grid[0][col] != cella) {
            return false; // invalid move
        }

        for (int i = sor - 1; i >= 0; i--) {
            if (grid[i][col] == cella) {
                grid[i][col] = disc;
                return true;
            }
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < sor; i++) {
            for (int j = 0; j < oszlop; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isFull() {
        for (int j = 0; j < oszlop; j++) {
            if (grid[0][j] == cella) {
                return false;
            }
        }
        return true;
    }

    public boolean checkWin(char disc) {
        // Check horizontal, vertical, and diagonal wins
        return checkHorizontal(disc) || checkVertical(disc) || checkDiagonal(disc);
    }

    private boolean checkHorizontal(char disc) {
        for (int i = 0; i < sor; i++) {
            for (int j = 0; j <= oszlop - 4; j++) {
                if (grid[i][j] == disc && grid[i][j + 1] == disc && grid[i][j + 2] == disc && grid[i][j + 3] == disc) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVertical(char disc) {
        for (int i = 0; i <= sor - 4; i++) {
            for (int j = 0; j < oszlop; j++) {
                if (grid[i][j] == disc && grid[i + 1][j] == disc && grid[i + 2][j] == disc && grid[i + 3][j] == disc) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonal(char disc) {
        // Check / diagonal
        for (int i = 3; i < sor; i++) {
            for (int j = 0; j <= oszlop - 4; j++) {
                if (grid[i][j] == disc && grid[i - 1][j + 1] == disc && grid[i - 2][j + 2] == disc && grid[i - 3][j + 3] == disc) {
                    return true;
                }
            }
        }
        // Check \ diagonal
        for (int i = 0; i <= sor - 4; i++) {
            for (int j = 0; j <= oszlop - 4; j++) {
                if (grid[i][j] == disc && grid[i + 1][j + 1] == disc && grid[i + 2][j + 2] == disc && grid[i + 3][j + 3] == disc) {
                    return true;
                }
            }
        }
        return false;
    }
}
