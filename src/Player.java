public class Player {
    private Coords location;
    private char playerNumber;
    private int stepsCount;
    private int numberOfWins;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public Player(int playerNumber) {
        this.stepsCount = 0;
        this.numberOfWins = 0;
        this.playerNumber = String.valueOf(playerNumber).charAt(0);
    }

    public Coords getLocation() {
        return location;
    }

    public boolean setLocation(Coords location) {
        if(this.location == null) this.location = location;
        if(!location.checkCoords()){
            message = "illegal move";
            return false;
        }
        this.location = location;
        return true;
    }

    public String getMessage() {
        return message;
    }

    public int getStepsCount() {
        return stepsCount;
    }

    public void setStepsCount(int stepsCount) {
        this.stepsCount = stepsCount;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public char getPlayerNumber() {
        return playerNumber;
    }

    public boolean move(int direction){
        boolean status;
        switch (direction) {
            case 1 -> status = setLocation(new Coords(getLocation().getX(), getLocation().getY() - 1));
            case 2 -> status = setLocation(new Coords(getLocation().getX(), getLocation().getY() + 1));
            case 3 -> status = setLocation(new Coords(getLocation().getX() + 1, getLocation().getY()));
            case 4 -> status = setLocation(new Coords(getLocation().getX() - 1, getLocation().getY()));
            default -> {
                status = false;
                message = "wrong key";
            }
        }
        return status;
    }

    @Override
    public String toString() {
        return String.format(
                "Player%c:\t" +
                "number of wins: %d\t" +
                "number of steps: %d\t",
                playerNumber, numberOfWins, stepsCount);
    }
}
