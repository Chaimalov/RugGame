public class Board {
    private char[][] board;
    private Rug rug;
    public final int SIZE = 30;

    public Board() {
        board = new char[SIZE +2][SIZE +2];
        rug = new Rug();
    }

    public void initBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i == 0 || j == 0 || i == board.length - 1 || j == board.length - 1)
                    board[i][j] = '#';
                else if(i >= rug.getTopLeft().getY()
                        && i < rug.getTopLeft().getY() + rug.getSize()
                        && j >= rug.getTopLeft().getX()
                        && j < rug.getTopLeft().getX() + rug.getSize()) board[i][j] = '*';
                else board[i][j] = ' ';
            }
        }
    }

    public boolean updatePlayerLocation(Player player){
        if(isPlayerWon(player)) return true;
        board[player.getLocation().getY()][player.getLocation().getX()] = player.getPlayerNumber();
        return false;
    }

    private boolean isPlayerWon(Player player){
        return board[player.getLocation().getY()][player.getLocation().getX()] == '*';
    }

    public void clearPlayerLocation(Player player){
        board[player.getLocation().getY()][player.getLocation().getX()] = ' ';
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public Rug getRug() {
        return rug;
    }

    public void printBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
