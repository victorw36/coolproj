import java.util.ArrayList;
import java.util.Scanner;

class Player {
    private String name;
    private char token;

    public Player(String name, char token) {
        this.name = name;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public char getToken() {
        return token;
    }
}

class ConnectFourBoard {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final char EMPTY_SLOT = '-';
    private char[][] board;

    public ConnectFourBoard() {
        board = new char[ROWS][COLS];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = EMPTY_SLOT;
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    public boolean dropToken(Player player, int col) {
        if (col < 0 || col >= COLS || board[0][col] != EMPTY_SLOT) {
            return false;
        }

        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][col] == EMPTY_SLOT) {
                board[i][col] = player.getToken();
                return true;
            }
        }
        return false;
    }

    public boolean checkWin(char token) {
        return checkHorizontalWin(token) || checkVerticalWin(token) || checkDiagonalWin(token);
    }

    private boolean checkHorizontalWin(char token) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j <= COLS - 4; j++) {
                if (board[i][j] == token && board[i][j + 1] == token && board[i][j + 2] == token && board[i][j + 3] == token) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVerticalWin(char token) {
        for (int i = 0; i <= ROWS - 4; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == token && board[i + 1][j] == token && board[i + 2][j] == token && board[i + 3][j] == token) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonalWin(char token) {
        // Check diagonals from top-left to bottom-right
        for (int i = 0; i <= ROWS - 4; i++) {
            for (int j = 0; j <= COLS - 4; j++) {
                if (board[i][j] == token && board[i + 1][j + 1] == token && board[i + 2][j + 2] == token && board[i + 3][j + 3] == token) {
                    return true;
                }
            }
        }

        // Check diagonals from top-right to bottom-left
        for (int i = 0; i <= ROWS - 4; i++) {
            for (int j = 3; j < COLS; j++) {
                if (board[i][j] == token && board[i + 1][j - 1] == token && board[i + 2][j - 2] == token && board[i + 3][j - 3] == token) {
                    return true;
                }
            }
        }

        return false;
    }
}