import java.util.Scanner;

public class ConnectFourGame {
    private ConnectFourBoard board;
    private Player player1;
    private Player player2;
    private int currentPlayerIndex;

    public ConnectFourGame(Player player1, Player player2) {
        board = new ConnectFourBoard();
        this.player1 = player1;
        this.player2 = player2;
        currentPlayerIndex = 0;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            board.printBoard();
            Player currentPlayer = (currentPlayerIndex == 0) ? player1 : player2;
            System.out.println(currentPlayer.getName() + "'s turn. Enter column (0-6): ");
            int col;
            if (currentPlayer instanceof AI) {
                col = generateAIMove();
                System.out.println("AI chose column: " + col);
            } else {
                col = scanner.nextInt();
            }
            if (board.dropToken(currentPlayer, col)) {
                if (board.checkWin(currentPlayer.getToken())) {
                    board.printBoard();
                    System.out.println(currentPlayer.getName() + " wins!");
                    break;
                }
                currentPlayerIndex = (currentPlayerIndex + 1) % 2;
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
        scanner.close();
    }

    private int generateAIMove() {
        return (int) (Math.random() * 7);
    }
}

