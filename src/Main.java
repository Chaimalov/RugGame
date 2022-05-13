import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        // Level 1
        System.out.println("LEVEL 1:");
        game.play();

        // Level 2
        System.out.println("LEVEL 2:");
        game.playMarathon();

        // Level 3
        System.out.println("LEVEL 3:");
        game.play(true);
        System.out.printf("\nPlayer%d Won!\n", game.getWinnerWithBestChances());
    }
}
