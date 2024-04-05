
public class Main {
    public static void main(String[] args) {
        Player[] players = GameInitializer.initializePlayers();
        ConnectFourGame game = new ConnectFourGame(players[0], players[1]);
        game.playGame();
    }
}