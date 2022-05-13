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
                else if(i >= rug.getTopRightCorner().getY()
                        && i < rug.getBottomLeftCorner().getY()
                        && j >= rug.getTopLeftCorner().getX()
                        && j < rug.getBottomRightCorner().getX()) board[i][j] = '*';
                else board[i][j] = ' ';
            }
        }
    }

    public boolean updatePlayerLocation(Player player){
        if(isPlayerWon(player)) {
            player.setMessage("Player" + player.getPlayerNumber() + " Won!");
            return true;
        }
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
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + "  ");
            }
            System.out.println();
        }
    }
}
