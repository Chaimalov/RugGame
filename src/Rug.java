public class Rug {
    private int size;
    private Coords topLeft;
    private Coords center;

    public Rug() {}

    public int getSize() {
        return size;
    }

    public boolean setSize(int size) {
        if(!new Coords(topLeft.getX()+size, topLeft.getY()+size).checkCoords()) return false;
        this.size = size;
        setCenter();
        return true;
    }

    private void setCenter(){
        center = new Coords(topLeft.getX()+(size/2), topLeft.getY()+(size/2));
    }

    public Coords getCenter() {
        return center;
    }

    public Coords getTopLeft() {
        return topLeft;
    }

    public boolean setRugTopLeft(Coords rugTopLeft) {
        if(!rugTopLeft.checkCoords()) return false;
        this.topLeft = rugTopLeft;
        return true;
    }
}
