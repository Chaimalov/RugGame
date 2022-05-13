import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        System.out.println("LEVEL 1:");
        game.play(); // Level 1

        System.out.println("LEVEL 2:");
        game.playMarathon(); // Level 2

        System.out.println("LEVEL 3:");
        game.play(true); // Level 3
        System.out.println("Player number " + game.getWinnerWithBestChances());
    }
}
