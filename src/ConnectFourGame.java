import java.util.ArrayList;
import java.util.Scanner;


    public class ConnectFourGame {
        private ConnectFourBoard board;
        private ArrayList<Player> players;
        private int currentPlayerIndex;

        public ConnectFourGame(Player player1, Player player2) {
            board = new ConnectFourBoard();
            players = new ArrayList<>();
            players.add(player1);
            players.add(player2);
            currentPlayerIndex = 0;
        }

        public void playGame() {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                board.printBoard();
                Player currentPlayer = players.get(currentPlayerIndex);
                System.out.println(currentPlayer.getName() + "'s turn. Enter column (0-6): ");
                int col = scanner.nextInt();
                if (board.dropToken(currentPlayer, col)) {
                    if (board.checkWin(currentPlayer.getToken())) {
                        board.printBoard();
                        System.out.println(currentPlayer.getName() + " wins!");
                        break;
                    }
                    currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
                } else {
                    System.out.println("Invalid move. Please try again.");
                }
            }
            scanner.close();
        }
    }