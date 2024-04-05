import java.util.Scanner;

public class GameInitializer {
    public static Player[] initializePlayers() {
        Scanner scanner = new Scanner(System.in);
        Player[] players = new Player[2];
        System.out.println("Choose game mode:");
        System.out.println("1. Play against AI");
        System.out.println("2. Play with a friend");
        int choice = scanner.nextInt();
        scanner.nextLine();

        Player player1 = new Player("Player 1", 'X');
        players[0] = player1;

        if (choice == 1) {
            Player player2 = new AI("AI", 'O');
            players[1] = player2;
        } else {
            System.out.println("Enter name for Player 2:");
            String player2Name = scanner.nextLine();
            Player player2 = new Player(player2Name, 'O');
            players[1] = player2;
        }

        return players;
    }
}
