package moba.gameobj.features;

public interface Movable {
    
    public abstract void move(int x, int y);

    public abstract int getPositionX();
    
    public abstract int getPositionY();

    public abstract int getDestinationX();

    public abstract int getDestinationY();

}
