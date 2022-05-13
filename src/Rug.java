public class Rug {
    private int size;
    private Coords topLeftCorner;
    private Coords topRightCorner;
    private Coords bottomLeftCorner;
    private Coords bottomRightCorner;

    public Rug() {}

    public int getSize() {
        return size;
    }

    public boolean setSize(int size) {
        if(!new Coords(topLeftCorner.getX()+size, topLeftCorner.getY()+size).checkCoords()) return false;
        this.size = size;
        setCorners();
        return true;
    }

    private void setCorners(){
        topRightCorner = new Coords(topLeftCorner.getX()+size, topLeftCorner.getY());
        bottomLeftCorner = new Coords(topLeftCorner.getX(), topLeftCorner.getY()+size);
        bottomRightCorner = new Coords(topLeftCorner.getX()+size, topLeftCorner.getY()+size);
    }

    public Coords getTopRightCorner() {
        return topRightCorner;
    }

    public Coords getBottomLeftCorner() {
        return bottomLeftCorner;
    }

    public Coords getBottomRightCorner() {
        return bottomRightCorner;
    }

    public Coords getTopLeftCorner() {
        return topLeftCorner;
    }

    public boolean setTopLeftCorner(Coords topLeftCorner) {
        if(!topLeftCorner.checkCoords()) return false;
        this.topLeftCorner = topLeftCorner;
        return true;
    }
}
