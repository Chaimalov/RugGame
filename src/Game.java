import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);
    private Board board;
    private Player[] players;

    public Game() {
        board = new Board();
        players = new Player[2];
        players[0] = new Player(1);
        players[1] = new Player(2);
    }

    public Player[] getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    //Level 1
    public void setup(){
        System.out.println("Enter the Rug x-y coordinates:");
        while (!board.getRug().setTopLeftCorner(new Coords(scanner.nextInt(), scanner.nextInt()))){
            System.out.println("Rug placement isn't right.\nEnter valid x-y coordinates:");
        }
        System.out.println("Enter the Rug size:");
        while (!board.getRug().setSize(scanner.nextInt())){
            System.out.println("the rug is too big.\nEnter a smaller size:");
        }
        for (Player player: players) {
            System.out.println("Enter the Player" + player.getPlayerNumber() + " x-y coordinates:");
            while (!player.setLocation(new Coords(scanner.nextInt(), scanner.nextInt()))) {
                System.out.println("Player" + player.getPlayerNumber() + " placement isn't right.\nEnter valid x-y coordinates:");
            }
        }
    }

    public boolean turn(){
        boolean win;
        for (Player player: players) {
            board.clearPlayerLocation(player);
            System.out.println("Player" + player.getPlayerNumber() + " make a move:");
            if(!player.move(scanner.nextInt())){
                System.out.println(player.getMessage() + " player" + player.getPlayerNumber() + ".\nnothing was registered.");
            }
            player.setStepsCount(player.getStepsCount() + 1);
            win = board.updatePlayerLocation(player);
            board.printBoard();
            if(win){
                System.out.println("player" + player.getPlayerNumber() + " won!");
                player.setNumberOfWins(player.getNumberOfWins() + 1);
                return win;
            }
        }
        return false;
    }

    public void play(){
        play(false);
    }

    //Level 2
    public void play(boolean freeze){
        setup();
        board.initBoard();
        for (Player player: players) {
            if(board.updatePlayerLocation(player)){
                player.setNumberOfWins(player.getNumberOfWins() + 1);
                System.out.println(player.getMessage());
                board.printBoard();
                return;
            }
        }
        board.printBoard();
        while(!freeze && !turn());
    }

    public void playMarathon(){
        do{
            play();
            System.out.println("would you like to play another game? (y/n):");
        }while (Character.toLowerCase(scanner.next().charAt(0)) == 'y');

        //Print statistics
        for (Player player: players) System.out.println(player);
        System.out.println(players[getOverallWinner()-1].getMessage());
    }

    private int getOverallWinner(){
        if(players[0].getNumberOfWins() == players[1].getNumberOfWins()){
            if(players[0].getStepsCount() < players[1].getStepsCount()) return 1;
            return 2;
        }
        else if(players[0].getNumberOfWins() > players[1].getNumberOfWins())return 1;
        return 2;
    }

    private int calcStepsCorner(Coords player, Coords corner){
        return calcStepsX(player, corner) + calcStepsY(player, corner) + 1;
    }

    private int calcStepsX(Coords player, Coords corner){
        return Math.abs(player.getX() - (corner.getX()));
    }

    private int calcStepsY(Coords player, Coords corner){
        return Math.abs(player.getY() - corner.getY());
    }

    //Level 3
    private int getPlayerDistance(Coords player){
       Coords topLeftCorner = board.getRug().getTopLeftCorner();
       Coords topRightCorner = board.getRug().getTopRightCorner();
       Coords bottomLeftCorner = board.getRug().getBottomLeftCorner();
       Coords bottomRightCorner = board.getRug().getBottomRightCorner();

        if(player.getX() < topLeftCorner.getX()){
            if(player.getY() < topLeftCorner.getY()){
                return calcStepsCorner(player, topLeftCorner);
            }
            if(player.getY() > bottomLeftCorner.getY()){
                return calcStepsCorner(player, bottomLeftCorner);
            }
                return calcStepsX(player, topLeftCorner);
        }
        if(player.getX() > topRightCorner.getX()){
            if(player.getY() < topRightCorner.getY()){
                return calcStepsCorner(player, topRightCorner);
            }
            if(player.getY() > bottomRightCorner.getY()){
                return calcStepsCorner(player, bottomRightCorner);
            }
                return calcStepsX(player, topRightCorner);
        }
        if(player.getY() < topRightCorner.getY()){
                return calcStepsY(player, topRightCorner);
            }
        return calcStepsY(player, bottomRightCorner);
    }

    public int getWinnerWithBestChances(){

        int player1 = getPlayerDistance(players[0].getLocation());
        int player2 = getPlayerDistance(players[1].getLocation());

        System.out.println("Player 1: " + player1 + " steps");
        System.out.println("Player 2: " + player2 + " steps");
        if(player1 == player2) return 0;
        if(player1 < player2) return 1;
        return 2;
    }
}
