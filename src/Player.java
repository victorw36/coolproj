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

